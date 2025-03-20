package graderbot

import (
	"bufio"
	"bytes"
	"fmt"
	"io"
	"os"
	"os/exec"
	"path/filepath"
	"strings"
	"sync"
)

var (
	studentFilePath      string
	dependenciesFilePath string
	testFilePath         string
	expectedOutputPath   string
	resultsFilePath      string
	HW                   string
	wg                   sync.WaitGroup
	mu                   sync.Mutex
	gradedMu             sync.Mutex
)

type Config struct {
	testName    string
	packageName string
	mu          sync.RWMutex
}

var GraderConfig = Config{testName: "flatland.Tester"}

func (c *Config) SetTestName(newTestName string, newPackageName string) {
	c.mu.Lock()
	defer c.mu.Unlock()
	c.testName = newTestName
	c.packageName = newPackageName
}

func (c *Config) GetTestName() string {
	c.mu.RLock()
	defer c.mu.RUnlock()
	return c.testName
}

// copyFiles copies all Java files from srcDir to destDir, except for a specific file.
func copyFiles(srcDir, destDir string) error {
	files, err := filepath.Glob(filepath.Join(srcDir, "*.java"))
	if err != nil {
		return err
	}

	for _, file := range files {
		_, fileName := filepath.Split(file)
		if fileName == fmt.Sprintf("%s.java", GraderConfig.testName) { // Avoid Student's Tester file
			continue // Skip the specific file
		}
		destPath := filepath.Join(destDir, fileName)

		srcFile, err := os.Open(file)
		if err != nil {
			return err
		}
		defer srcFile.Close()

		destFile, err := os.Create(destPath)
		if err != nil {
			return err
		}
		defer destFile.Close()

		if _, err := io.Copy(destFile, srcFile); err != nil {
			return err
		}
	}

	return nil
}

func deleteJavaFiles(dirPath string) error {
	files, err := filepath.Glob(filepath.Join(dirPath, "*.java"))
	if err != nil {
		return err
	}
	for _, file := range files {
		err := os.Remove(file)
		if err != nil {
			fmt.Println("Failure at deleting ", file, err)
		}
	}
	return nil
}

func cleanBin(binPath string) error {
	entries, err := os.ReadDir(binPath)
	if err != nil {
		return err
	}

	for _, entrie := range entries {
		filePath := filepath.Join(binPath, entrie.Name())
		err := os.RemoveAll(filePath)
		if err != nil {
			return err
		}
		//fmt.Println("Bin Cleared:", filePath)
	}

	return nil
}

func compile(studentPath string, dependPath string, testPath string, binPath string, resultFile *os.File) error {
	// Copy student's Java files to dependency folder, skipping a specific file
	if err := copyFiles(studentPath, dependPath); err != nil {
		return fmt.Errorf("failed to copy student files: %v", err)
	}

	cmd := exec.Command("javac", "-d", binPath, "-cp", binPath)
	tmpFiles, err := filepath.Glob(filepath.Join(dependPath, "*.java"))
	if err != nil {
		return err
	}
	cmd.Args = append(cmd.Args, tmpFiles...)

	cmd.Stdout = resultFile
	cmd.Stderr = resultFile

	//fmt.Println("Compiling:", tmpFiles)

	if err := cmd.Run(); err != nil {
		return fmt.Errorf("compilation failed: %v", err)
	}

	testFile, err := filepath.Glob(filepath.Join(testPath, "*.java"))
	if err != nil {
		return err
	}
	cmd = exec.Command("javac", "-d", binPath, "-cp", binPath)
	cmd.Args = append(cmd.Args, testFile...)

	cmd.Stdout = resultFile
	cmd.Stderr = resultFile

	//fmt.Println("Compiling Tester:", testFile)
	if err := cmd.Run(); err != nil {
		return fmt.Errorf("compilation failed: %v", err)
	}

	return nil
}

func countLines(filename string) (int, error) {
	file, err := os.Open(filename)
	if err != nil {
		return 0, err
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	lineCount := 0

	for scanner.Scan() {
		lineCount++
	}

	if err := scanner.Err(); err != nil {
		return 0, err
	}

	return lineCount, nil
}

func grading(studentOutput string, expectedOutput string, resultFile *os.File) (float64, error) {
	cmd := exec.Command("diff", "-bw", expectedOutput, studentOutput)

	var out bytes.Buffer
	cmd.Stdout = &out
	cmd.Stderr = &out

	err := cmd.Run()
	if err != nil {
		// Ignore "exit status 1" since it just means differences were found
		if exitError, ok := err.(*exec.ExitError); ok && exitError.ExitCode() == 1 {
			err = nil
		}
	}

	diffOutput := out.String()
	diffLines := 0

	fmt.Fprintf(resultFile, "Differences\n")
	for _, line := range strings.Split(diffOutput, "\n") {
		if strings.HasPrefix(line, ">") { // What Student got wrong compared to Expected Output
			fmt.Fprintf(resultFile, "%s\n", line)
			diffLines++
		}
	}

	totalLines, err := countLines(expectedOutput)
	if err != nil {
		return 0, fmt.Errorf("error gathering total lines")
	}

	if totalLines == 0 {
		return 0, fmt.Errorf("expectet output empty")
	}

	similarity := (1 - float64(diffLines)/float64(totalLines)) * 100

	return similarity, err
}

func executeTestFile(studentName string, binPath string, resultFile *os.File, errChan chan error) error {
	testName := GraderConfig.GetTestName() // Dynamically Get Test Name

	cmd := exec.Command("java", "-cp", binPath, testName)
	cmd.Stdout = resultFile
	cmd.Stderr = resultFile
	if err := cmd.Run(); err != nil {
		errChan <- fmt.Errorf("error running tester for %s: %v", studentName, err)
		return err
	}

	studentOutput, expectedOutput := fmt.Sprintf("%s/%s_results.txt", resultsFilePath, studentName), fmt.Sprintf("%s/output.txt", expectedOutputPath)
	score, err := grading(studentOutput, expectedOutput, resultFile)
	if err != nil {
		errChan <- fmt.Errorf("error grading %s: %v", studentName, err)
		return err
	}

	// Protect shared resource with mutex
	mu.Lock()
	fmt.Printf("Similarity for %s: %f%%\n", studentName, score)
	fmt.Fprintf(resultFile, "Similarity for %s: %f%%\n", studentName, score)
	mu.Unlock()

	return nil
}

func GradeStudents(selectedHW string) {
	HW := selectedHW
	dirPath := fmt.Sprintf("HW/%s/", HW) // This will be be changed depending on the HW

	gradedStudents := make(map[string]bool)

	// This walks through the directory for
	// gathering student,dependecies,test paths
	err := filepath.WalkDir(dirPath, func(path string, d os.DirEntry, err error) error {
		if err != nil {
			fmt.Println("Error: ", err)
			return nil
		}

		switch d.Name() {
		case GraderConfig.packageName: // Change this to correct package name
			dependenciesFilePath = filepath.Join(path)
		case "students":
			studentFilePath = filepath.Join(path)
		case "test":
			testFilePath = filepath.Join(path)
		case "expectedOutput":
			expectedOutputPath = filepath.Join(path)
		case "results":
			resultsFilePath = filepath.Join(path)
		}

		return nil
	})

	if err != nil {
		fmt.Println("Error Walking Through Directory: ", err)
	}

	studentEntries, err := os.ReadDir(studentFilePath)
	if err != nil {
		fmt.Println("Error Reading ", studentFilePath)
		return
	}

	errChan := make(chan error, len(studentEntries)*2)

	// Goes down the Students folder
	for _, students := range studentEntries {
		if !students.IsDir() {
			continue
		}
		studentName := strings.SplitN(students.Name(), "_", 2)[0]
		studentDir := filepath.Join(studentFilePath, students.Name())

		gradedMu.Lock()
		if gradedStudents[studentName] {
			errChan <- fmt.Errorf("%s has multiple folders, please combine their folders", studentName)
			gradedMu.Unlock()
			continue
		}
		gradedStudents[studentName] = true
		gradedMu.Unlock()

		wg.Add(1) // Adding to WaitGroup
		go func(studentName string, studentDir string) {
			defer wg.Done()
			//fmt.Println("Grading Student:", studentName)

			// Create a unique binPath for each student
			studentBinPath := filepath.Join(dirPath, "bin", studentName)
			if err := os.MkdirAll(studentBinPath, os.ModePerm); err != nil {
				errChan <- fmt.Errorf("failed to create bin directory for %s: %v", studentName, err)
				return
			}

			studentDependencyPath := filepath.Join(dependenciesFilePath, studentName)
			if err := os.MkdirAll(studentDependencyPath, os.ModePerm); err != nil {
				errChan <- fmt.Errorf("failed to create dependency directory for %s: %v", studentName, err)
				return
			}

			// Create result file
			resultFile, err := os.Create(fmt.Sprintf("%s/%s_results.txt", resultsFilePath, studentName))
			if err != nil {
				fmt.Println("Error creating output file:", err)
				return
			}
			defer resultFile.Close()

			// Find student's java files
			studentPath := ""
			localEntries, localErr := os.ReadDir(studentDir)
			if localErr != nil {
				errChan <- fmt.Errorf("error Reading %s: %v", studentDir, localErr)
				return
			}

			// Based on each Student's folder, check for path containing java files
			for _, student := range localEntries {
				fileDir := filepath.Join(studentDir, student.Name())
				err = filepath.WalkDir(fileDir, func(path string, d os.DirEntry, err error) error {
					if err != nil {
						fmt.Println("Error ", err)
					}

					if d.IsDir() && d.Name() == "__MACOSX" {
						return filepath.SkipDir
					}

					if !d.IsDir() && filepath.Ext(d.Name()) == ".java" {

						// If this is the first Java file found, set studentPath
						if studentPath == "" {
							studentPath = filepath.Dir(path) // Set to parent directory of Java file
						}
					}
					return nil
				})

				if err != nil {
					errChan <- err
					return
				}
			}

			// Compile and Execute Students Work
			if localErr = compile(studentPath, studentDependencyPath, testFilePath, studentBinPath, resultFile); localErr != nil {
				errChan <- fmt.Errorf("compilation Error for %s: %v", studentName, localErr)
			} else if localErr = executeTestFile(studentName, studentBinPath, resultFile, errChan); localErr != nil {
				errChan <- fmt.Errorf("execution Error for %s: %v", studentName, localErr)
			}
			if localErr = deleteJavaFiles(studentDependencyPath); localErr != nil {
				errChan <- fmt.Errorf("deleting failed for %s: %v", studentName, localErr)
			}
			if localErr = cleanBin(studentBinPath); localErr != nil {
				errChan <- fmt.Errorf("cleaning failed for %s: %v", studentName, localErr)
			}
			if err := os.RemoveAll(studentBinPath); err != nil {
				errChan <- fmt.Errorf("failed to delete %s: %v", studentBinPath, err)
			}
		}(studentName, studentDir) // Pass variables as arguments to avoid race conditions
	}
	wg.Wait()
	close(errChan)

	// Handle Errors after all goroutines complete
	fmt.Println()
	fmt.Println("Error Logs")
	for err := range errChan {
		fmt.Println("Error:", err)
	}

}

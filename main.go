package main

import (
	"bytes"
	"fmt"
	"io"
	"os"
	"os/exec"
	"path/filepath"
	"strings"
)

var (
	studentFilePath      string
	dependenciesFilePath string
	testFilePath         string
	expectedOutputPath   string
	resultsFilePath      string
	studentName          []string
	HW                   string
)

// copyFiles copies all Java files from srcDir to destDir.
func copyFiles(srcDir, destDir string) error {
	files, err := filepath.Glob(filepath.Join(srcDir, "*.java"))
	if err != nil {
		return err
	}

	for _, file := range files {
		_, fileName := filepath.Split(file)
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

func compile(studentPath string, dependPath string, testPath string, binPath string) error {
	// Copy student's Java files to dependency folder
	if err := copyFiles(studentPath, dependPath); err != nil {
		return fmt.Errorf("failed to copy student files: %v", err)
	}

	cmd := exec.Command("javac", "-d", binPath, "-cp", binPath)
	tmpFiles, err := filepath.Glob(filepath.Join(dependPath, "*.java"))
	if err != nil {
		return err
	}
	cmd.Args = append(cmd.Args, tmpFiles...)

	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr

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

	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr

	//fmt.Println("Compiling Tester:", testFile)
	if err := cmd.Run(); err != nil {
		return fmt.Errorf("compilation failed: %v", err)
	}

	return nil
}

func grading(studentOutput string, expectedOutput string, totalPoints int) (int, error) {
	cmd := exec.Command("diff", "-u", expectedOutput, studentOutput)

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

	for _, line := range strings.Split(diffOutput, "\n") {
		if strings.HasPrefix(line, "+") {
			diffLines++
		}
	}

	score := max(totalPoints-int(float64(diffLines)*2.0), 0)

	return score, err
}

func executeTestFile(binPath string) error {
	// Creating and Storing Result to .txt
	resultFile, err := os.Create(fmt.Sprintf("%s/%s_results.txt", resultsFilePath, studentName[0]))
	if err != nil {
		fmt.Println("Error creating output file:", err)
		return err
	}
	defer resultFile.Close()

	cmd := exec.Command("java", "-cp", binPath, "test")
	cmd.Stdout = resultFile
	cmd.Stderr = resultFile
	if err := cmd.Run(); err != nil {
		fmt.Println("Error running tester:", err)
		return err
	}

	studentOutput, expectedOutput := fmt.Sprintf("%s/%s_results.txt", resultsFilePath, studentName[0]), fmt.Sprintf("%s/output.txt", expectedOutputPath)
	score, err := grading(studentOutput, expectedOutput, 30)
	if err != nil {
		fmt.Println("Error grading:", err)
		return err
	}
	fmt.Println("Grade:", score)

	return nil
}

func main() {
	HW = "HW2"
	dirPath := fmt.Sprintf("HW/%s/", HW) // This will be be changed depending on the HW
	binPath := filepath.Join(dirPath, "bin")

	// This walks through the directory for
	// gathering student,dependecies,test paths
	err := filepath.WalkDir(dirPath, func(path string, d os.DirEntry, err error) error {
		if err != nil {
			fmt.Println("Error: ", err)
			return nil
		}

		if d.Name() == "polynomial" {
			dependenciesFilePath = filepath.Join(path)
		}
		if d.Name() == "students" {
			studentFilePath = filepath.Join(path)
		}
		if d.Name() == "test" {
			testFilePath = filepath.Join(path)
		}
		if d.Name() == "expectedOutput" {
			expectedOutputPath = filepath.Join(path)
		}
		if d.Name() == "results" {
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

	for _, students := range studentEntries {
		studentPath := ""
		if students.IsDir() {
			studentName = strings.SplitN(students.Name(), "_", 2)
			fmt.Println("Grading Student:", studentName[0])
			studentDir := filepath.Join(studentFilePath, students.Name())
			studentEntries, err = os.ReadDir(studentDir)
			if err != nil {
				fmt.Println("Error Reading ", studentDir)
				return
			}
			for _, student := range studentEntries {
				fileDir := filepath.Join(studentDir, student.Name())
				err = filepath.WalkDir(fileDir, func(path string, d os.DirEntry, err error) error {
					if err != nil {
						fmt.Println("Error ", err)
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
					fmt.Println("Error ", err)
					return
				}
			}
		}

		// Compile and Execute Students Work
		if err = compile(studentPath, dependenciesFilePath, testFilePath, binPath); err != nil {
			fmt.Println("Compilation Error:", err)
		} else if err = executeTestFile(binPath); err != nil {
			fmt.Println("Execution Error:", err)
		}
		if err = deleteJavaFiles(dependenciesFilePath); err != nil {
			fmt.Printf("deleting failed: %v\n", err)
		}
		if err = cleanBin(binPath); err != nil {
			fmt.Println("Cleaning failed:", err)
		}
	}

}

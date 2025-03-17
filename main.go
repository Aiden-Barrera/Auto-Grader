package main

import (
	"fmt"
	"io"
	"os"
	"os/exec"
	"path/filepath"
)

var (
	studentFilePath      string
	dependenciesFilePath string
	testFilePath         string
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

func compile(studentPath string, dependPath string, testPath string, binPath string) error {
	// Copy student's Java files to dependency folder
	if err := copyFiles(studentPath, dependPath); err != nil {
		return fmt.Errorf("failed to copy student files: %v", err)
	}

	cmd := exec.Command("javac", "-d", binPath, "-cp", fmt.Sprintf("%s:%s", dependPath, testPath), "-sourcepath", dependPath)
	tmpFiles, err := filepath.Glob(filepath.Join(dependPath, "*.java"))
	if err != nil {
		return err
	}
	cmd.Args = append(cmd.Args, tmpFiles...)

	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr

	fmt.Println("Compiling:", tmpFiles)

	if err := cmd.Run(); err != nil {
		return fmt.Errorf("compilation failed: %v", err)
	}

	return nil
}

func main() {
	dirPath := "HW/HW2/" // This will be be changed depending on the HW
	//binPath := filepath.Join(dirPath, "bin")

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
			fmt.Println("Grading Student:", students.Name())
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
		fmt.Println("Student Path: ", studentPath)
		// err = compile(studentPath, dependenciesFilePath, testFilePath, binPath)
		// if err != nil {
		// 	fmt.Println("Compilation Error:", err)
		// 	return
		// }
	}

}

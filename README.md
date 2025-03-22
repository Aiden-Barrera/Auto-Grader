# Auto-Grader

## Overview
Auto-Grader is a command-line tool designed to grade students' Java homework submissions automatically. It compiles and runs each student's Java file against a provided test file, compares the program output with the expected output, and calculates a similarity percentage. The grading results, including program output, compilation errors (if any), and differences between actual and expected output, are stored in the `results` folder for easy review.

## Features
- Automatically compiles and runs Java files submitted by students.
- Compares student output against an expected output file.
- Computes a similarity score to evaluate correctness.
- Stores grading results, including program output and errors.
- Supports structured homework folder management.

## Folder Structure
When running the Auto-Grader, the following folder structure is used:
```
HW_FOLDER/
│── bin/                # Compiled Java files
│── dependencies/       # Used for compiling students code with the package name
│── expectedoutput/     # Contains expected output (output.txt)
│── results/            # Stores grading results for each student
│── students/           # Contains each student's homework folder
│── tests/              # Contains the test Java file
```
- **`students/`**: Each student’s submission folder should be placed here.
- **`expectedoutput/output.txt`**: This file should contain the expected output.
- **`tests/`**: Stores the Java test file used for grading.

## Installation & Usage

### 0. Install GO for your OS
```sh
https://go.dev/ 
```

### 1. Clone the Repository
```sh
git clone <repo-url>
cd Auto-Grader
```

### 2. Build & Install
```sh
go build
go install
```

### 3. Running Auto-Grader
To start the Auto-Grader, use the following command:
```sh
Auto-Grader <command>
```

### Commands
#### `create`
Creates the necessary homework folder structure for grading. This command prompts the user for:
- Folder name
- Java package name used for the homework

Usage:
```sh
Auto-Grader create
```

#### `run`
Lists available homework folders and prompts the user to select one. It then executes the grading process, asking:
- The homework package name
- The test package name (if any)
- The name of the test Java file (without `.java` extension)

Once the inputs are provided, the Auto-Grader compiles and executes each student’s file, calculates similarity scores, and reports any compilation or runtime errors.

Usage:
```sh
Auto-Grader run
```

### Grading Output
After running, results are stored in the `results/` folder, where you can find:
- **Student program output**
- **Compilation errors (if any)**
- **Difference between student output and expected output**
- **Similarity scores**

## Example Workflow
1. Create the necessary folder structure:
   ```sh
   Auto-Grader create
   ```
2. Place student submissions in the `students/` folder.
3. Add the expected output in `expectedoutput/output.txt`.
4. Place the test Java file inside the `tests/` folder.
5. Run the Auto-Grader:
   ```sh
   Auto-Grader run
   ```
6. Review results in the `results/` folder.

## Notes
- Ensure Java is installed and available in the system path.
- Student submissions should follow the correct package naming convention.

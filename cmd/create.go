/*
Copyright © 2025 NAME HERE <EMAIL ADDRESS>
*/
package cmd

import (
	"Auto-Grader/cmd/ui/textInputs"
	"fmt"
	"os"

	tea "github.com/charmbracelet/bubbletea"
	"github.com/spf13/cobra"
)

// createCmd represents the create command
var createCmd = &cobra.Command{
	Use:   "create",
	Short: "A brief description of your command",
	Long:  `.`,
	Run: func(cmd *cobra.Command, args []string) {
		dirPath := "HW/"

		// Run the multi-step input model
		prompts := []string{"What is the name of the Homework to Grade",
			"What is the name of the Packaged used",
		}
		ph := []string{"Enter homework name",
			"Enter package name",
		}

		textInputProgram := tea.NewProgram(textInputs.InitializeTextInput(prompts, ph))
		model, err := textInputProgram.Run()
		if err != nil {
			cobra.CheckErr(err)
			return
		}

		if !model.(textInputs.Model).Quitting {
			return
		}

		selectedHomework, selectedPackage := model.(textInputs.Model).GetInputs()[0], model.(textInputs.Model).GetInputs()[1]

		entries, err := os.ReadDir(dirPath)
		if err != nil {
			cobra.CheckErr(err)
			return
		}

		for _, entry := range entries {
			if entry.Name() == selectedHomework {
				fmt.Print("\033[H\033[2J")
				fmt.Printf("Error: homework file %s already created", selectedHomework)
				return
			}
		}

		homeworkPaths := []string{
			fmt.Sprintf("HW/%s/", selectedHomework),
			fmt.Sprintf("HW/%s/bin", selectedHomework),
			fmt.Sprintf("HW/%s/dependencies/%s", selectedHomework, selectedPackage),
			fmt.Sprintf("HW/%s/expectedOutput", selectedHomework),
			fmt.Sprintf("HW/%s/results", selectedHomework),
			fmt.Sprintf("HW/%s/students", selectedHomework),
			fmt.Sprintf("HW/%s/test", selectedHomework),
		}

		for _, homeworkPath := range homeworkPaths {
			if err := os.MkdirAll(homeworkPath, os.ModePerm); err != nil {
				cobra.CheckErr(err)
				return
			}
		}

		filePath := fmt.Sprintf("HW/%s/expectedOutput/output.txt", selectedHomework)
		file, err := os.Create(filePath)
		if err != nil {
			cobra.CheckErr(err)
		}
		defer file.Close()

		fmt.Print("\033[H\033[2J")
	},
}

func init() {
	rootCmd.AddCommand(createCmd)

	// Here you will define your flags and configuration settings.

	// Cobra supports Persistent Flags which will work for this command
	// and all subcommands, e.g.:
	// createCmd.PersistentFlags().String("foo", "", "A help for foo")

	// Cobra supports local flags which will only run when this command
	// is called directly, e.g.:
	// createCmd.Flags().BoolP("toggle", "t", false, "Help message for toggle")
}

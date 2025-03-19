/*
Copyright © 2025 NAME HERE <EMAIL ADDRESS>
*/
package cmd

import (
	"Auto-Grader/cmd/ui/listInputs"
	"Auto-Grader/graderbot"
	"os"

	"github.com/charmbracelet/bubbles/list"
	tea "github.com/charmbracelet/bubbletea"
	"github.com/spf13/cobra"
)

// type item string

// func (i item) FilterValue() string { return "" }

// type listHomeworks struct {
// 	items []list.Item
// }

// runCmd represents the run command
var runCmd = &cobra.Command{
	Use:   "run",
	Short: "Run the grading process for selected homework",
	Long:  `Run the grading process for selected homework using a TUI to select the homework.`,
	Run: func(cmd *cobra.Command, args []string) {
		dirPath := "HW/"

		entries, err := os.ReadDir(dirPath)
		if err != nil {
			cobra.CheckErr(err)
		}

		var homeworks []list.Item
		for _, entry := range entries {
			if entry.IsDir() {
				homeworks = append(homeworks, listInputs.Item(entry.Name()))
			}
		}

		tprogram := tea.NewProgram(listInputs.InitializelListInput(homeworks))
		model, err := tprogram.Run()
		if err != nil {
			cobra.CheckErr(err)
		}

		selectedHomework := model.(listInputs.Model).Choice
		if selectedHomework == "" {
			return
		}

		// Call the grading function with the selected homework
		graderbot.GradeStudents(selectedHomework)
	},
}

func init() {
	rootCmd.AddCommand(runCmd)

	// Here you will define your flags and configuration settings.

	// Cobra supports Persistent Flags which will work for this command
	// and all subcommands, e.g.:
	// runCmd.PersistentFlags().String("foo", "", "A help for foo")

	// Cobra supports local flags which will only run when this command
	// is called directly, e.g.:
	// runCmd.Flags().BoolP("toggle", "t", false, "Help message for toggle")
}

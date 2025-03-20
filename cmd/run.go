/*
Copyright © 2025 NAME HERE <EMAIL ADDRESS>
*/
package cmd

import (
	"Auto-Grader/cmd/ui/listInputs"
	"Auto-Grader/cmd/ui/textInputs"
	"Auto-Grader/graderbot"
	"fmt"
	"os"
	"strings"

	"github.com/charmbracelet/bubbles/list"
	tea "github.com/charmbracelet/bubbletea"
	"github.com/charmbracelet/lipgloss"
	"github.com/spf13/cobra"
)

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

		fmt.Print("\033[H\033[2J")
		if model.(listInputs.Model).Quitting {
			return
		}

		selectedHomework := model.(listInputs.Model).Choice
		if selectedHomework == "" {
			return
		}

		// Run the multi-step input model
		prompts := []string{"What is the name of the Package used for the homework?",
			"What is the name of the Test Package (Leave blank if none)?",
			"What is the name of the Test file (Not including .java)?",
		}
		ph := []string{"Enter package name",
			"Enter test package",
			"Enter test file name",
		}

		textInputProgram := tea.NewProgram(textInputs.InitializeTextInput(prompts, ph))
		model, err = textInputProgram.Run()
		if err != nil {
			cobra.CheckErr(err)
		}

		fmt.Print("\033[H\033[2J")

		if !model.(textInputs.Model).Quitting {
			return
		}

		inputs := model.(textInputs.Model).GetInputs()
		selectedHomeworkPackage, selectedPackage, selectedTestName := inputs[0], inputs[1], inputs[2]

		// Call the grading function with the selected homework
		if selectedPackage == "" {
			graderbot.GraderConfig.SetTestName(selectedTestName, selectedHomeworkPackage)
		} else {
			graderbot.GraderConfig.SetTestName(fmt.Sprintf("%s.%s", selectedPackage, selectedTestName), selectedHomeworkPackage)
		}

		// Define Lipgloss styles
		boxStyle := lipgloss.NewStyle().
			Border(lipgloss.RoundedBorder()).
			Padding(1, 2).
			Margin(1, 0, 2).
			Width(80). // Adjust width as needed
			Align(lipgloss.Left)

		titleStyle := lipgloss.NewStyle().Bold(true).Foreground(lipgloss.Color("#FFD700"))
		studentStyle := lipgloss.NewStyle().Foreground(lipgloss.Color("#00FF00"))
		errorStyle := lipgloss.NewStyle().Foreground(lipgloss.Color("#FF0000"))

		results := graderbot.GradeStudents(selectedHomework)

		var output []string
		for _, res := range results {
			if strings.Contains(res, "Error") {
				output = append(output, errorStyle.Render(res))
			} else {
				output = append(output, studentStyle.Render(res))
			}
		}

		// Print final formatted output
		gradingResults := fmt.Sprintf(
			"%s\n%s",
			titleStyle.Render("📚 Grading Results 📚"),
			strings.Join(output, "\n"),
		)

		formattedBox := boxStyle.Render(gradingResults)
		fmt.Println(formattedBox)
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

package textInputs

import (
	"fmt"
	"strings"
	"sync"

	"github.com/charmbracelet/bubbles/textinput"
	tea "github.com/charmbracelet/bubbletea"
	"github.com/charmbracelet/lipgloss"
)

// Define a style using Lipgloss
var (
	titleStyle  = lipgloss.NewStyle().Bold(true).Foreground(lipgloss.Color("#FFA500")).Padding(0, 1)
	inputStyle  = lipgloss.NewStyle().Foreground(lipgloss.Color("#00FF00"))
	borderStyle = lipgloss.NewStyle().Border(lipgloss.RoundedBorder()).Padding(1).BorderForeground(lipgloss.Color("#FFFFFF"))
)

// Define the structure for multiple inputs
type Model struct {
	textInput    textinput.Model
	stepIndex    int // Track current step
	inputs       []string
	Prompts      []string
	Placeholders []string
	Quitting     bool
	err          error
	mu           sync.Mutex
}

// func (m *Model) SetPrompts(prompt []string) {
// 	m.mu.Lock()
// 	defer m.mu.Unlock()
// 	m.Prompts = append(m.Prompts, prompt...)
// }

// func (m *Model) GetPrompts() []string {
// 	m.mu.Lock()
// 	defer m.mu.Unlock()
// 	return m.Prompts
// }

// Initialize Model with multiple steps
func InitializeTextInput(prompts []string, ph []string) Model {
	ti := textinput.New()
	ti.Focus()
	ti.CharLimit = 156
	ti.Width = 30

	if len(ph) > 0 {
		ti.Placeholder = ph[0]
	}

	return Model{
		textInput:    ti,
		stepIndex:    0,
		Prompts:      prompts,
		Placeholders: ph,
		inputs:       make([]string, len(prompts)),
	}
}

// Init starts the blinking cursor
func (m Model) Init() tea.Cmd {
	return textinput.Blink
}

// Handle input updates and transitions
func (m Model) Update(msg tea.Msg) (tea.Model, tea.Cmd) {
	var cmd tea.Cmd

	switch msg := msg.(type) {
	case tea.KeyMsg:
		switch msg.Type {
		case tea.KeyEnter:
			m.mu.Lock()
			if m.stepIndex < len(m.inputs) {
				m.inputs[m.stepIndex] = m.textInput.Value()
			}
			m.mu.Unlock()

			// Move to the next step
			if m.stepIndex+1 >= len(m.Prompts) {
				m.Quitting = true
				return m, tea.Quit // Exit when all steps are completed
			}

			// Reset input field for next step
			m.stepIndex++
			m.textInput.SetValue("")
			m.textInput.Placeholder = m.Placeholders[m.stepIndex]

		case tea.KeyCtrlC, tea.KeyEsc:
			return m, tea.Quit
		}

	case tea.WindowSizeMsg:
		m.textInput.Width = msg.Width - 4
	}

	m.textInput, cmd = m.textInput.Update(msg)
	return m, cmd
}

// View renders the UI
func (m Model) View() string {
	var b strings.Builder
	fmt.Fprintf(&b, "%s\n\n", titleStyle.Render(m.Prompts[m.stepIndex]))
	fmt.Fprintf(&b, "%s\n", inputStyle.Render(m.textInput.View()))
	fmt.Fprintf(&b, "\n%s", borderStyle.Render("(Press Enter to continue, Esc to quit)"))
	return lipgloss.NewStyle().
		Border(lipgloss.RoundedBorder()).
		Padding(1, 2).
		Margin(0, 0, 2).
		Width(50).
		Align(lipgloss.Center).
		Render(b.String())
}

// Function to get final input results
func (m Model) GetInputs() []string {
	return m.inputs
}

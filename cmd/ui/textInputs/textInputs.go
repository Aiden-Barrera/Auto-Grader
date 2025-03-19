package textInputs

import (
	"fmt"

	"github.com/charmbracelet/bubbles/textinput"
	tea "github.com/charmbracelet/bubbletea"
)

type (
	errMsg error
)

type Model struct {
	textInput textinput.Model
	err       error
}

type Text struct {
	title       string
	placeholder string
}

var InputText = Text{title: "Title Here", placeholder: "Enter text here"}

func (t *Text) SetInputText(title, ph string) {
	t.title = title
	t.placeholder = ph
}

func (t *Text) GetTextInput() *Text {
	return t
}

func InitializeTextInput() Model {
	ti := textinput.New()
	ti.Placeholder = InputText.placeholder
	ti.Focus()
	ti.CharLimit = 156
	ti.Width = 20

	return Model{
		textInput: ti,
		err:       nil,
	}
}

func (m Model) Init() tea.Cmd {
	return textinput.Blink
}

func (m Model) Update(msg tea.Msg) (tea.Model, tea.Cmd) {
	var cmd tea.Cmd

	switch msg := msg.(type) {
	case tea.KeyMsg:
		switch msg.Type {
		case tea.KeyEnter, tea.KeyCtrlC, tea.KeyEsc:
			return m, tea.Quit
		}

	// We handle errors just like any other message
	case errMsg:
		m.err = msg
		return m, nil
	}

	m.textInput, cmd = m.textInput.Update(msg)
	return m, cmd
}

func (m Model) View() string {
	return fmt.Sprintf(
		"%s\n\n%s\n\n%s",
		InputText.title,
		m.textInput.View(),
		"(esc to quit)",
	) + "\n"
}

func (m Model) GetInputText() string {
	return m.textInput.Value()
}

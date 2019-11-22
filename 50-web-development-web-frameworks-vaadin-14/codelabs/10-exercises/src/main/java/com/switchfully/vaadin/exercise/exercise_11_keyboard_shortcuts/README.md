# Exercise 11 - Keyboard shortcuts

This exercise contains two forms.  
First try to add keyboard shortcuts using `Button.addClickShortcut()`.
Add shortcuts for all buttons on both forms, using the same the Enter-key as shorctut for the searchButton and 
submitButton, and Ctrl-C as the shortcut for both clearButtons.

The problem is that this defines these shortcuts globally.
You will notice that no matter where the focus is, the first form will always submit when pressing enter.

Try to solve this issue by using `Shortcuts.addShortcutListener()` in `ExampleForm1` and `ExampleForm2`.

If the focus is on the first form, then the shortcuts should trigger the first form only.
The same should apply for the second form.

## Relevant documentation
[Using Shortcuts in Components](https://vaadin.com/docs/v14/flow/components/tutorial-flow-shortcut.html)  

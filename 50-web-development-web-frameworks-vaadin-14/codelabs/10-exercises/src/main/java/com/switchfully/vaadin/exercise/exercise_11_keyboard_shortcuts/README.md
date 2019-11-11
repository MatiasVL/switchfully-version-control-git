# Exercise 11 - Keyboard shortcuts

This exercise contains two forms.  
The buttons have keyboard shotcuts defined on them using `Button.addClickShortcut()`.

The problem is that this defines these shortcuts globally.
You will notice that no matter where the focus is, the first form will always submit when pressing enter.

Try to solve this issue by using `Shortcuts.addShortcutListener()` in `ExampleForm1` and `ExampleForm2`.

If the focus is on the first form, then the shortcuts should trigger the first form only.
The same should apply for the second form.

## Relevant documentation
[Using Shortcuts in Components](https://vaadin.com/docs/v14/flow/components/tutorial-flow-shortcut.html)  

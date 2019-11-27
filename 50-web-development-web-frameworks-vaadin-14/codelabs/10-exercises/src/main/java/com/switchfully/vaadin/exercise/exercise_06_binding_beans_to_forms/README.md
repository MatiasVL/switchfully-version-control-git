# Exercise 6 - Binding beans to forms

![screenshot](exercise.png)

Take your solution from exercise 5 and copy it in this exercise.  
Remove all the binding logic.
Now use `Binder.bindInstanceFields()` to automatically bind the fields in `EditAccommodationForm` to the `Accommodation` 
bean based on the field names.  
Make sure that the java field names for the form components match the properties of `Accommodation`.  
Do not forget to register the DoubleToIntegerConverter for the number of rooms.  You can use `Binder.forMemberField()` for that.

[Relevant documentation](https://vaadin.com/docs/v14/flow/binding-data/tutorial-flow-components-binder-beans.html)
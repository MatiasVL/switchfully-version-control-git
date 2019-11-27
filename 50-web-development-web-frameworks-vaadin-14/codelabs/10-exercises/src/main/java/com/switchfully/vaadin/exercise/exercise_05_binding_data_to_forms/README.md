# Exercise 5 - Binding data to forms

![screenshot](exercise.png)

## Part 1: Updating an existing Accommodation
Create an EditAccommodationForm component by writing a new class `EditAccommodationForm` extending `FormLayout`.

Add fields to this component for the following properties of Accommodation:
* Name
* City
* Number of rooms
* Star Rating

When the user clicks an element in the `Grid`, open the `EditAccommodationForm` and load the selected Accommodation.
Place the EditAccommodationForm component to the right of the grid, but only after an accommodation was selected in the 
grid.

Add a Save button to this form to update the entity when the user clicks it.
Use `AccommodationService.save()` to update the entity.

**Note 1:** Use `Binder.setBean()` to bind the Accommodation bean to the fields in the form.

**Note 2:** Use `NumberField` for the 'Number of rooms'-field.  Create a DoubleToIntegerConverter for converting from 
Double to Integer.  Use it when binding the numberOfRooms-field.

**Note 3:** Try to also bind using `Binder.readBean()` and `Binder.writeBean()` instead of `Binder.setBean()`.  
Using `Binder.setBean()` is also called binding in **unbuffered** mode.  Conversely binding using `Binder.readBean()` 
and `Binder.writeBean()` is called **buffered** mode.  
To understand the difference, set a breakpoint in the setter methods of `Accommodation` and try to find out when these 
breakpoints are reached when editing the fields in the form.

## Part 2: Adding a new Accommodation
Add a 'Add new accommodation button' that opens an empty `EditAccommodationForm` form to add a new Accommodation.

Create the new Accommodation when the save-button is clicked.
Use `AccommodationService.save()` to save the entity.

## Part 3: Deleting an Accommodation
Add a Delete button to delete the entity.

Use `AccommodationService.delete()` to delete the entity.

## Part 4: Add a cancel button
Add a Cancel button to the form that closes the form.

## Part 5: Notifications
Show notifications when adding, updating and deleting accommodations.
Use `Notification.show()` for this.

## Extra credits
Add a `DateField` to the form for the 'dateCreated' property of Accommodation.
Make this read-only.  Hide it when creating a new Accommodation.

[Relevant documentation](https://vaadin.com/docs/v14/flow/binding-data/tutorial-flow-components-binder-beans.html)
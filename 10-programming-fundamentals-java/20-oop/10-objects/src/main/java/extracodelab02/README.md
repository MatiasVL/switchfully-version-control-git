# CoolEmployee

**For your information**: This extra, optional codelab already covers the creation of classes 
(which is different than creation object / instances of classes).
Creating classes will be covered in the next module (module: classes)

## Creating the CoolEmployee class

It should have the following state:
- id (int)
- firstName (String)
- lastName (String)
- salary (int)

It should have one constructor which you pass the following arguments:
- id
- firstName
- lastName
- salary

For each value, create a method that returns that value:
- id
- firstName
- lastName
- Name (full name)
- salary
- annual salary (monthly salary * 13.9)

Create the following methods, which set / modify the following values
- A method to set the salary to a provided value
- A method to raise the salary by the provided percentage value

Create a method to get the textual representation of CoolEmployee
- Tip: there is a Java specific method for this (that we can override)

## Unique ID's

Try to come up with a way to always have a unique ID.
- The first CoolEmployee that's being created should get ID = 0
- The second, ID = 1
- The third, ID = 2
- etc...

If your program gets restarted, you can start again with 0.

Tip: the solution is not as far fetched as you might think. ;)

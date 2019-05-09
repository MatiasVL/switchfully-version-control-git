# It's a Date

- Write a class definition for Date, 
an object type that contains three integers: year, month, and day.

- This class should provide two constructors. 
    - The first should take no parameters and initialize a default date. 
    - The second should take parameters named year, month and day, and use them to initialize the instance variables.

- Create a CONSTANT that stores a Date object named CHRISTMAS.

- Create the equals() and toString() methods.

- Write an addDays class method that adds a given number of days to a given date. 
Handling overflow for months is a non-trivial amount of work, 
you can use the following class in Java 8 to get the number of days in a month:

```
YearMonth yearMonthObject = YearMonth.of(1999, 2);
int daysInMonth = yearMonthObject.lengthOfMonth(); //28
```
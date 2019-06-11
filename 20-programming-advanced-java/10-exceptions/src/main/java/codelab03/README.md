# It's a date

## Part 1

1. Run the MyOwnLocalDateTest tests!
2. Inspect the tests to get an idea of what is required!
3. Inspect the MyOwnLocalDate code
4. Requirements:
    - year: values allowed from MIN_YEAR to MAX_YEAR
    - month: values from 1 to 12
    - dayOfMonth: value from 1 to 31 (not cross-referenced with month. 31 february is OK)
5. Implement the required methods to make all the tests green
6. Are all tests green? If so, go to part 2.


## Part 2

Create a executable application which provides a CLI to a user.
The CLI asks the user for a year, a month and a dayOfMonth.
With this data, it will create a MyOwnLocalDate object, which it will print out for the user.

Make sure that no exception is ever thrown back to the user (so no internal Java exception data should be spit out). 
If something exceptional occurs, provide the user with the message that was given to the exception when it was thrown. 
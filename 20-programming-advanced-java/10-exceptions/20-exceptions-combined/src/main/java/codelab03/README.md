# It's a date!

## What is required?

If you take a closer look at `MyOwnLocalDate`, you'll see that some methods are not properly implemented.
Instead of writing down the exact requirements (in text), we have written tests which cover these requirements.

Take a look at the tests of `MyOwnLocalDate`, they're located in class-file `MyOwnLocalDateTest.java` which resides in 
folder `src/main/tests`, package `codelab03`.
- Run the tests, they should all fail.
- Inspect why the tests are failing, correct the code of `MyOwnLocalData` so that the tests start working.
- (Do not change anything inside of `MyOwnLocalDateTest`)

We will help you out a tiny bit, we'll provide you with the rules for validation a year, month or day (but you'll have 
to look at the tests to see what the expected behavior is should the rules be violated)
- year: values allowed from MIN_YEAR to MAX_YEAR
- month: values from 1 to 12
- dayOfMonth: value from 1 to 31 (not cross-referenced with month. 31 february is OK)

Implement methods `validateYear(...)`, `validateMonth(...)` and `validateDayOfMont(...)` 
so that all the tests become green.

## Make a CLI

Create a executable application which provides a CLI to the user.
The CLI asks the user for a year, a month and a dayOfMonth.
With this data, it will create a MyOwnLocalDate object, which it will print out (using `toString()`) so the user can 
view it.

Any exception that can be thrown, either by the `MyOwnLocalDate` class or by the `Scanner` class (which you'll have to use),
has to be properly dealt with. 
- Don't let your program crash!
- Ideally, you keep asking the user for valid input when it's invalid. Only when (e.g.) a valid year is provided, will 
the program continue to ask for a (valid) month.
# TDD FizzBuzz

For every requirement:
1. Write a test
2. Run the test, see it fail
3. Let your pair implement a solution to fix that test (nothing more!)
4. Run the test, it should succeed
5. Refactor (if needed)
6. Repeat step 1, but switch roles. 

Repeat this process until the requirement is completely tested (happy path & boundary tests) and fully implemented.
Only then go to the next requirement

Remember to keep the XP practices in mind:
- Pair programming
- Good tests
- Incremental design

## Requirement 1
Create a method that accepts a number as argument and returns an array of numbers containing 1 to X where X is the provided argument

## Requirement 2
If X is <= 1, throw an IllegalArgumentException with a custom message

## Requirement 3
Return "Fizz" when the number is divisible by 3

## Requirement 4
Return "Buzz" when the number is divisible by 5

## Requirement 5
Return "FizzBuzz" when the number is divisible by both 3 and 5
# TDD Train

For every requirement:
1. Write a test
2. Run the test, see it fail
3. Let your pair implement a solution to fix that test (nothing more!)
4. Run the test, it should succeed
5. Refactor (if needed)
6. Repeat step 1, but switch roles. 

Repeat this process until the requirement is completely tested (happy path & boundary tests) and fully implemented.
Only then go to the next requirement

## Requirement 1
A Train has as property hoursDelayed which can never be negative
- A negative hoursDelayed should always be corrected to the value 0.

## Requirement 2
You have to create the `String customerSatisfaction()` method given following rules:
- 0 hours: 	“Nice ‘n’ rolling!”
- 1 hour:	“Just another day at the train …”
- 2 hours: 	“This train is annoying me!”
- 3 hours: 	“B-u-u-urn it!”
- +3 hours:	 The world explodes (exception)



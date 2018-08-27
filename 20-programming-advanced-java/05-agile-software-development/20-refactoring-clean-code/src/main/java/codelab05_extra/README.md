# String Calculator

Start with this codelab when you've finished the previous codelabs.

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
- Write clean code

## Requirement 1
Create a simple String calculator with a method ```int add(string numbers)```
- The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will return 0) 
for example "" or "1" or "1,2"
- Start with the simplest test case of an empty string and move to 1 and two numbers
- Remember to solve things as simply as possible so that you force yourself to write tests you did not think about

## Requirement 2
Allow the Add method to handle an unknown amount of numbers

## Requirement 3
Allow the Add method to handle new lines between numbers (instead of commas).
- The following input is ok:  "1\n2,3"  (will equal 6)
- The following input is NOT ok:  "1,\n"

## Requirement 4
Support different delimiters
- To change a delimiter, the beginning of the string will contain a separate line that looks like this:  ```"//[delimiter]\n[numbers…]"```
    - for example ```"//;\n1;2"``` should return 3, where the default delimiter is ';'.
- The first line is optional. all existing scenarios should still be supported

## Requirement 5
Calling Add with a negative number will throw an exception "negatives not allowed: X", where X is the negative that was passed.
if there are multiple negatives, show all of them in the exception message.

## Requirement 6
Numbers bigger than 1000 should be ignored, so adding 2 + 1001  = 2

## Requirement 7
Delimiters can be of any length with the following format:  ```"//[delimiter]\n"``` 
- for example: ```"//[***]\n1***2***3"``` should return 6.

## Requirement 8
Allow multiple delimiters like this: ```"//[delim1][delim2]\n"``` 
- for example ```"//[*][%]\n1*2%3"``` should return 6.

## Requirement 9
Make sure you can also handle multiple delimiters with length longer than one char


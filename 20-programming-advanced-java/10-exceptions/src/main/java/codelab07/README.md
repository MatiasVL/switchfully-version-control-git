# Safely Divide V2

For starters: copy/paste the contents of codelab06 (Divide, DivideApplication and their Test classes)

Now, update your entire program so that it validates the user input (numerator and denominator) 
right after asking for it. If an exception is thrown (e.g. NumberFormatException), 
the program should keep asking the user for input until valid input is provided.
Do mind that you'll from now on, the denominator should be an Integer, not a Double!
- Integers do not know the concept of **Infinity**, so... be careful... :)

Do know that:
- You can change Divide and DivideApplication as much as you like 
and (obviously) create new classes and methods if you want.
- You'll have to change the existing tests and write new ones.

Your output of your DivideApplication should match the following example:

```
Dear human, welcome to the divide program!
> Please provide a numerator:
hello
The provided numerator is not a valid double number!
> Please provide a numerator:
9.5
Thank you human!
> Please provide a denominator:
hi
The provided denominator is not a valid integer number!
> Please provide a denominator:
1.5
The provided denominator is not a valid integer number!
> Please provide a denominator:
0
The provided denominator can not be ZERO!
> Please provide a denominator:
2
Thank you human!
Calculating the division...
Result: 4.75
```

## Finished?

Let someone else review your code!
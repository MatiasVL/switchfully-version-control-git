# Safe calculations

In this package, you'll find a - very simplistic - but functioning CLI (command-line interface) calculator.

Execute it, you are prompted (in the command-line) to input a numerator, and then a denominator.
- As the numerator, provide `9`
- As the denominator, provide `2`
- The resulting quotient should be `4` (since we're working with integer instead of floating point numbers)

Works like a charm... not!

There are multiple ways to let our program crash!
Do you already know some?

Let's discover them one by one and protect our code against them.

## Math rules (as in the noun 'the rules', not the verb)

According to the laws of math, it's impossible to divide by zero.

Execute the program, as the denominator, provide value `0`.

Upon executing the `divide` method, the program will crash, an un-caught exception was thrown:
```
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at codelab02.CalculatorService.divide(CalculatorService.java:6)
	at codelab02.Calculator.main(Calculator.java:27)
```

Although there are multiple ways of dealing with this (ask the user for a different denominator should it be equal to 0), 
we are going to catch this specific exception should it occur.

In the `main` method, wrap the potentially unsafe code with a `try...catch` block. Should an `ArithmeticException` 
exception be thrown, print out the following text: *"Could not divide {numerator} by {denominator}"*.

Re-run your program, provide as the denominator value `0`.
- Verify that you receive your custom error message.
- Verify that your program doesn't crash.

## Never trust input...

When we allow users to input data into our application (as in here: a numerator and denominator), 
we always have to be wary (careful).

Although we're asking our users to input integer values, they're free to input floating point values of even textual values.

Re-run your program, as the numerator provide value `5.9`. It will crash...
```
Exception in thread "main" java.util.InputMismatchException
	at java.base/java.util.Scanner.throwFor(Scanner.java:939)
	at java.base/java.util.Scanner.next(Scanner.java:1594)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
	at codelab02.Calculator.main(Calculator.java:22)

```

Again, re-run your program, as the numerator provide value `Hello!`. It will crash...
```
Exception in thread "main" java.util.InputMismatchException
	at java.base/java.util.Scanner.throwFor(Scanner.java:939)
	at java.base/java.util.Scanner.next(Scanner.java:1594)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
	at codelab02.Calculator.main(Calculator.java:22)

```

If you closely look at the trace of the **Stack** (also known as the **Stack trace**), you'll see that it goes wrong 
on line `22` -> at `codelab02.Calculator.main(Calculator.java:22)`. It's where we call method `nextInt` of `Scanner`.
- No idea what the Stack is? We'll soon cover this in the slides. 

If we continue to go up the stack trace (the bottom of the stack trace is the last output line), we see that it goes wrong on line `2212`, 
which is in the body of method `nextInt` -> `at java.base/java.util.Scanner.nextInt(Scanner.java:2212)`. That's as deep as we need to go.

We now know we are calling an unsafe method (`nextInt`) and where exactly we are calling it (line `22` of method `main`).
Time to protect our code against the exception it can throw!

Make it so that should an `InputMismatchException` be thrown, it is caught and the value of the numerator is set to 10.
- Also, print the following message: *"(invalid numerator provided. Therefore it is set to value 10)"*
Otherwise, the provided value is used.
- Do this similarly for the denominator, but instead of value 10, set it to value 5. Also print a similar message.
- However, make sure that when the numerator is wrong, we still get the option to provide a (correct) denominator and 
visa versa.

Should one provide an invalid numerator and denominator, this should be the output:
```
Provide a numerator (int): Hi!
(invalid numerator provided. Therefore it is set to value 10)
Provide a denominator (int): 8.5
(invalid denominator provided. Therefore it is set to value 5)
The quotient of the division is: 2
```

## We only want good input!

**This assignment is completely optionally**

Make it so that whenever an invalid numerator or denominator is provided (not an integer value), the program asks for a new numerator 
(or denominator). It keeps doing this until a valid numerator (or denominator) is provided.

E.g.:
```
Provide a numerator (int): Hi!
     Not a valid numerator...
Provide a numerator (int): Hello
     Not a valid numerator...
Provide a numerator (int): 40
Provide a denominator (int): 4.5
     Not a valid denominator...
Provide a denominator (int): 10
The quotient of the division is: 4
```

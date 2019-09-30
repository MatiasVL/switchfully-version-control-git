# Exceptions V1

Start by running the `ExceptionApplication` (it has a `main` method).

It should print the following output:
```
I can show you the world!
```

So far, so good.

## Throw an exception

Inside of the `MyExceptionService`, complete the `doSomethingExceptional` method:
- It should create an object of `IllegalStateException` and **throw** it.
- As the exception's message, provide *"I'm so exceptional"*

Notice how afterwards all the code (`ExceptionApplication` and `MyExceptionService`) still compiles, although an 
exception is thrown. Based on that, you should know whether `IllegalStateException` is a **checked** or **unchecked** exception.
- Answer this question: is `IllegalStateException` a **checked** or **unchecked** exception?

Run the `ExceptionApplication` again. This should be the output:
```
Exception in thread "main" java.lang.IllegalStateException: I'm so exceptional
	at codelab01.MyExceptionService.doSomethingExceptional(MyExceptionService.java:9)
	at codelab01.ExceptionApplication.main(ExceptionApplication.java:11)
``` 

The program crashed...

## Stack trace

If you closely look at the trace of the **Stack** (also known as the **Stack trace**), you'll see that it goes wrong 
on line `11` -> at `codelab01.ExceptionApplication.main(ExceptionApplication.java:11)`. 
It's in our `main` method of `ExceptionApplication`. On that line (line: `11`) we call method `doSomethingExceptional` of `MyExceptionService`.
However, to know where in method `doSomethingExceptional` it goes wrong, we have to continue to go up the stack trace. 

If we continue to go up the stack trace (the bottom of the stack trace is the last output line), we see that something 
goes wrong on line `9` -> at `codelab01.MyExceptionService.doSomethingExceptional(MyExceptionService.java:9)`. If we look
what's on line `9` of `MyExceptionService`, we see that it's the place where we create and throw our exception. It's the 
root cause (that let our program crash), it's at the top of the stack.  

Since an exception is thrown, which reaches our `main` method (where it is not caught), our program crashes. This occurs
at line `11` of our `main` method (`at codelab01.ExceptionApplication.main(ExceptionApplication.java:11`)). This means 
that line `12` of our `main` method (`System.out.println("I can show you the world!");`) is never executed 
(because the program crashes right before it). This is the reason why we don't see that text printed in the console.

## Fix ya code...

In `ExceptionApplication`, protect yourself against the call to `doSomethingExceptional`.
Make sure the `System.out.println("I can show you the world!");` statement is always executed.

Afterwards, running the `ExceptionApplication` class should output the following:
```
Something went wrong: I'm so exceptional
I can show you the world!
```
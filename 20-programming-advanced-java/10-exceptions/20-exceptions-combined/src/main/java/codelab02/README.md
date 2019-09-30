# Exceptions V2

Start by running the `ExceptionV2Application` (it has a `main` method).

It should print the following output:
```
I can show you the world!
```

So far, so good.

## Throw an exception

Inside of the `MyExceptionV2Service`, complete the `doSomethingExceptional` method:
- It should create an object of `IOException` and **throw** it.
- As the exception's message, provide *"I'm so exceptional"*

Notice how afterwards the `MyExceptionV2Service` class **no longer** compiles, 
a compilation error is thrown! Based on that, you should know whether `IOException` is a **checked** or **unchecked** exception.
- Answer this question: is `IOException` a **checked** or **unchecked** exception?

Fix the compilation by adding a `throws` clause to the method's signature.
- Do not surround the exception with a `try...catch` in the `doSomethingExceptional` itself (it would also fix the compilation, 
but it would make little sense to let a method create, throw **and** catch an exception).

You'll now notice that `MyExceptionV2Service` compiles, however, `ExceptionV2Application` does not!
Do to the nature of `IOException` (checked v.s. unchecked) which is now part of the method's signature (using `throws`), 
it is required that you catch (or rethrow) the exception.

Wrap the `myExceptionService.doSomethingExceptional();` statement with a `try...catch`. When caught, print out the message
of the `IOException` exception. 

Your code should now compile again.

Lastly, run the `ExceptionV2Application` class again, it should output the following:
```
Catched: I'm so exceptional
I can show you the world!
```

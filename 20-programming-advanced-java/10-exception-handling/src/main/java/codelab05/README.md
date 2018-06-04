# Logging the stack trace


## Part 1

1. Run the ApplicationRunner
2. Notice how an exception is thrown, which is never catched and 
therefore shown to the user of the application (in this case, to you in the console)

Closely inspect what you see in the console!
What you see is what we call the **stack trace**.
It shows you the list of method calls the application was performing when the exception was thrown.

- Starting from the bottom, you'll see the main method.
- Going upwards through the list, you'll get deeper into the execution of the methods.
    - main called startProcess of MyService
    - startProcess of MyService then called processData of SomeOtherService
    - processData of SomeOtherService then called retrieveExternalData of ExternalService
    - While executing retrieveExternalData, an exception was thrown!

For now:
- Catch the exception in your main method.
Extract the message (Something went wrong!) from the exception and only show that message to the user.
    - Tip: Go to the online Java docs of Exception, see which methods it provides.
- Also, no matter if an exception is thrown or not, make sure to always print the message "Bye!"

## Part 2

The stacktrace can be extremely useful for developers for debugging purposes!
However, a stack trace is something very technical, so a user of your application should never be confronted with it.

Therefore, when an exception occurs in our application, we often write the stacktrace to a special file, called a **log file**.
This way, the users of our application are not confronted with it, but we as developers can still inspect it.

- Create a MyLogger class
    - Create a method writeStackTraceToFile which accepts an RuntimeException object as argument
    - It should write the stacktrace of the RuntimeException object to a file called "mylogfile.txt"
- The writeStackTraceToFile method should be called in the catch block of the main method


- Hints:
    - Your log file will probably be created inside your root working directory folder
    - You'll need the java.io.FileWriter, java.io.PrintWriter and the printStackTrace method of Exception
        - Java 8 docs: FileWriter, PrintWriter, Exception
        - Do they use checked or unchecked exceptions?
    - java.io resources such as FileWriter and PrintWriter always need to be closed, always (during normal and exceptional behavior)!
        - Otherwise the writing to a file will not be finalized and memory leaks can occur
        - Closing resources might trigger exceptions, have fun... :)

## Finished?

Let someone else review your code!    
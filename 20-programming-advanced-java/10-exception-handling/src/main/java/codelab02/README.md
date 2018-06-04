# Exceptions V2

1. Run the ExceptionV2Application
2. Implement the doSomethingExceptional method of MyExceptionV2Service
    - It should throw a new IOException
3. Notice how your doSomethingExceptional method will no longer compile. 
You're required to surround the exception with a try...catch 
or add the exception to the method signature (using throws)
    - Why is this?
    - Add the exception to the method signature (using throws)
4. Notice how now ExceptionV2Application won't compile?
    - Why is this?
5. Catch the exception and print the message "We're sorry, something went wrong"
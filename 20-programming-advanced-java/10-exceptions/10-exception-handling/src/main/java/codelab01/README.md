# Exceptions

1. Run the ExceptionApplication
2. Implement the doSomethingExceptional method of MyExceptionService
    - It should throw a new IllegalStateException
3. Notice how ExceptionApplication will still compile
    - Why is this?
4. Run ExceptionApplication
    - The exception is not catched and therefore thrown back to the user (CLI, GUI). 
    This is not something we want to do, a user will have no clue what just happened.
5. Catch the exception and print the message "Sorry, something went wrong"
# Swappable Bonus calculators (during runtime) V2

If not already, finish codelab06, then copy/paste the code of codelab06 to this codelab.

To further demonstrate how flexible our bonus application is and that you can swap the calculators during runtime,
we're going to alter the Application class.

Hint: We'll be using the Java Scanner class to read input from the console

- If an Application is launched
    - It should ask the user for an employee name
    - It should ask the user for an yearly salary for the employee
    - Based on this data, it should create an employee
    - It should then ask the user for a bonus calculator:
        
        ``` 
        Dear user, please choose a bonus calculator:
        Option [1]: Good Year Bonus Calculator
        Option [2]: Bad Year Bonus Calculator
        Option [3]: Exceptional Employee Bonus Calculator
        ``` 
    - Based on the option (digit 1, 2 or 3), the correct bonus calculator should be created and added to the employee
    - It should then calculate the bonus of that employee and print out the result to the user.
    - It should then again start with asking the user for an employee name
        - In other words, it should repeat the whole process
        - It should repeat this process infinitely until the user provides the text "QUIT" as the employee name!
    
- Extra requirements
    - Make the application as user-friendly as possible for the user (good feedback, clear instructions)
    - Validate all the input the user provides!
        - Always validate user-input! Not all users have good intentions!
        - Let your neighbour try and crash your program (by providing unexpected input)
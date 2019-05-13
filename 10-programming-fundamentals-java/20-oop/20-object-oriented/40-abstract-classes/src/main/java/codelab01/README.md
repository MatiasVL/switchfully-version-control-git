# Employee

Create a class `Employee`, this class should contain a `name` and a `basic annual salary`.

We should be able to calculate the monthly salary (`calculateMonthlySalary`) for an `Employee` object.
- Calculating the monthly salary is highly dependent on the type of employee:
    - A normal employee gets 1/12 of the annual salary, as its monthly salary.
    - A manager gets 1/11 of the annual salary + a bonus, as its monthly salary.
        - The bonus ranges from 100 to 250 euro and is assigned to the manager upon creating the object.
        - The bonus of a manager can be changed (but still, it has to be between 100 - 250 euro). 
    
Additional technical requirement: **Use an abstract class and an abstract method**.
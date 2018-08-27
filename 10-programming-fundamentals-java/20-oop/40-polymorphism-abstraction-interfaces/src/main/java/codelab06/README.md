# Swappable Bonus calculators (during runtime)

We provided you with an Employee class, a BonusCalculator interface, 
a BonusService and an Application with an executor method.

With this application, we can create employees and calculate their bonuses.
Thoroughly analyze the code:
    - Notice how Employee has a BonusCalculator
    - Notice how BonusService has an unfinished method
    - Make sure you fully understand all the code
    - Try to run the Application, inspect why we're getting this message! Make sure you fully understand.
    
We now want to extend our code so that it is able to select a BonusCalculator 
based on the year for which we want to calculate bonuses.
There should be 3 different BonusCalculators:
- One for a good year: `yearlySalary / 12 * 1.4`
- One for a bad year: `yearlySalary / 12 * 1.1`
- One for exceptional employees: `yearlySalary / 12 * 1.8`
    
Complete the `setBonusCalculatorBasedOnYear` method in BonusService using following psuedo-code:
```
// if bonusYear is a bad year
// then
    // For every employee in employees
    //      set its bonusCalculator to the bonusCalculator for a bad year
// else
    // For every employee in employees
    //      set its bonusCalculator to the bonusCalculator for a good year
```

In Application, right before you call the `calculateBonuses` method on BonusService,
swap / set the bonusCalculator for employee `employeeDavidWhoIsExceptional` 
to the bonus calculator for exceptional employees.

Run the Application, inspect the result.
We've created a flexible application which can swap calculating mechanism / algorithms during runtime.
Pretty neat, right?
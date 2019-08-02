# One problem, 3 solutions

As you see, we have provided different classes for StrictCalculator (`V1`, `V2`,...)

All StrictCalculator classes are (at the moment) the same. They offer a method `multiplyBy2` which (at the moment) simply takes in an `int`,
multiplies it by 2 and then returns the result. However, since it's a strict calculator, we will have to be more strict.
More precisely: the `multiplyBy2` method will have to be modified so that it checks if a certain condition is met before multiplying.
If the condition is not met, it will simply return the initial `int` without multiplying.
- Psuedo-code
    ```
    IF condition is OK
    THEN return number * 2
    ELSE return number
    ```

What this condition is exactly, is not up to the `multiplyBy2` method to decide. 
It simply doesn't know this, all it knows is that it can only multiple if a certain condition is met.

You'll see that every StrictCalculator has a `main` method, calling the `multiplyBy2` method 3 times.
For each call, the client should be able to specify what ruleset he wants to use (a ruleset implements a certain condition).
You will have to edit the `multiplyBy2` method so that it can take in a ruleset as an argument.
Each StrictCalculator version allows for 3 rulesets:
1. **Ruleset #1:** the number is valid (for being multiplied) if it's positive but smaller or equal than 5
2. **Ruleset #2:** the number is valid (for being multiplied) if it's negative and bigger than -4
3. **Ruleset #3:** the number is valid (for being multiplied) if it is equal to 8,9,10,11,12 or 13

However, **each version of StrictCalculator will have a different way of providing and implementing these rulesets:**
1. **Version 1:** define a ruleset functional interface with 3 different implementing classes (one for each ruleset). 
Instances of these concrete implementations can be provided as an argument to method `multipleBy2`.
2. **Version 2:** Use an existing built-in functional interface and 3 anonymous classes (one for each ruleset). 
Provide every anonymous class as an argument to `multipleBy2` for each call.
3. **Version 3:** Use an existing built-in functional interface and 3 lambda expressions (one for each ruleset). 
Provide each lambda expression as an argument to `multipleBy2` for each call. 
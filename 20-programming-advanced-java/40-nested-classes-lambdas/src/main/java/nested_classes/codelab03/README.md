# Callback

1. Modify method multiplyBy2 of StrictCalculator so that it takes a callback method to validate the operator.
2. Only if the operator is valid, should the operator be multiplied by 2.
3. For the 3 different examples in the main method, there are 3 different rulesets to define if the operator is valid
    1. Ruleset #1: operator is valid if it's positive but smaller or equal than 5
    2. Ruleset #2: operator is valid if it's negative and bigger than -4
    3. Ruleset #3: operator is valid if it is equal to 8,9,10,11,12 or 13
4. If the operator is not valid, the operator should not be multiplied by 2 (simply return it as-is).
# TDD Vampire

For every requirement:
1. Write a test
2. Run the test, see it fail
3. Let your pair implement a solution to fix that test (nothing more!)
4. Run the test, it should succeed
5. Refactor (if needed)
6. Repeat step 1, but switch roles. 

Repeat this process until the requirement is completely tested (happy path & boundary tests) and fully implemented.
Only then go to the next requirement.

Remember to keep the XP practices in mind:
- Pair programming
- Good tests
- Incremental design

## Requirement 1
A Vampire can bite a Human, when he does, the Human transforms into a vampire as well

## Requirement 2
- Only if the human is bitten after midnight, will he turn into a vampire.
- If the human is bitten before midnight, nothing will happen.

## Missed edge case
Oops, we missed an edge case (resulting in a bug)... What if the human is bitten ON midnight?
He should be transformed into a vampire as well.
Make sure you first write a test for this scenario, to once and for all cover that scenario (make the bug visible with a test, then fix it)

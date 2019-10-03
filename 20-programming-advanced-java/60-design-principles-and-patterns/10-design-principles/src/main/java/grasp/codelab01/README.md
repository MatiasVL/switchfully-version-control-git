# GRASP

> Only take a look at the solution (see the `solution` package) when you're done, not before.

We have already provided you with 4 classes and a working solution:
1. Board
2. Country
3. Soldier
4. RiskGame (example of a Controller)

Calling the (static factory) method `createDefaultGameSetup` of `RiskGame` will create a default Risk game, which includes:
1. A `RiskGame` object.
2. A `Board` object
3. Four specific `Country` objects (named "East-Europe", "West-Europe", "United Kingdom" and "Scandinavia").
4. Eight `Soldier` objects (2 per country), each with strength == 1.
 
Validate the current code according to the following principles (among maybe others):
- Creator
- Information Expert
- Low coupling

Detect the violations and refactor the code by applying these GRASP principles.

Take your time, think about the design and your solution!

**When you're done, take a look at the solution (in the `solution`) package.**

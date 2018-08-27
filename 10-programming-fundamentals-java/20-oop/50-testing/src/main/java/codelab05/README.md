# Tested RaceCar

You're about to create a RaceCar.
However, we want you to always first write a tests for a criteria and only then implement that criteria!
Keep repeating this process until all criteria are covered in tests.

Create a RaceCar which has a numberOfGears and a currentGear (both int).
As its behavior, a RaceCar has 4 methods:
- shiftGearUp and shiftGearDown which shifts the currentGear one gear up or down
    - The following criteria should apply:
        - currentGear can never be negative
        - currentGear can never be higher than numberOfGears
- shiftGear which takes the gear to shift to
    - The argument gear can never be more than 1 gear higher or lower than currentGear
        - e.g. calling shiftGear(2) when currentGear == 1 will result in currentGear == 2
        - e.g. calling shiftGear(2) when currentGear == 3 will result in currentGear == 2
        - e.g. calling shiftGear(2) when currentGear == 4 will result in an IllegalArgumentException with a custom message
- The overridden toString method which returns the text "Racecar with {numberOfGears} in total, currently in {currentGear} gear."        
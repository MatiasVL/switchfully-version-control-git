# RailroadCar

                CHOO CHOO!
    ----------------------------------
    |                                 |
    |        ___           ___        |
    |       |___|         |___|       |
    |               NMBS              |
    |               SNCB              |
    |                                 |__
    -------------------------------------|
    OO                               OO

## Create class RailroadCar

Create a class `RailroadCar`, a train has the following instance variables:
- `serialNumber` (every `RailroadCar` has a unique identifier, e.g. `xyz0105`)
- `isFirstClass` (its either a first class or second class Railroad car)
- `numberOfSeats`
- `hasToilet` (either it has one or hasn't one)

## Constructors

Create the following, different, constructors:
1. A single argument constructor that takes a `serialNumber` as an argument
    - Instance variable `serialNumber` should be set to parameter `serialNumber`
    - Instance variable `isFirstClass` should be set to `false`
    - Instance variable `numberOfSeats` should be set to `100`
    - Instance variable `hasToilet` should be set to `false`
2. A 4-argument constructor that takes a `serialNumber`, a `isFirstClass`, a `numberOfSeats` and a `hasToilet` as an argument
   - Instance variable `serialNumber` should be set to parameter `serialNumber`
   - Instance variable `isFirstClass` should be set to parameter `isFirstClass`
   - Instance variable `numberOfSeats` should be set parameter `numberOfSeats`
   - Instance variable `hasToilet` should be set to parameter `hasToilet`
   
Make sure you do proper data encapsulation.
   
## Main method
 Create yourself a new class (e.g. `TrainSimulator`) that has a main method in which you create some `RailroadCar` instances
- Use some dummy data
- Make sure to use both of the constructors

## Override the toString method

Override the toString method, it should return the following String:
- `"RailroadCar <serialNumber>: Number of seats: <numberOfSeats> - First class: <isFirstClass> - Has a toilet: <hasToilet>"`

## Create getters
Create getter methods for all the instance variables

## Change isFirstClass
Create a setter method to set the instance variable `isFirstClass` to the value provided (as an argument)

## Change Toilet
- Create a method to toggle the `hasToilet` instance variable
    - If `hasToilet` was `false`, the new value should be `true`
    - If `hasToilet` was `true`, the new value should be `false`
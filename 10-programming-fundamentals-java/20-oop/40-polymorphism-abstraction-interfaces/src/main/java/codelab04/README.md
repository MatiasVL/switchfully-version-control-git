# Driving and Honking

Start with determining and implementing the correct inheritance between:

- A Car
- A Vehicle
- A Truck
- A Hatchback
- A Formula1
- A ToyCar

Then, continue:

- Vehicle and Car should never be instantiated (to create an object of this type)
- Every vehicle has Wheels
    - A Wheel consists of a thickness in cm (int) and a type
        - type is an enum
            - LARGE
            - SMALL
            - SPEED
            - TOY
- Every vehicle has a display method which will print a custom message
    - E.g. Formula1: "I'm sleek, low and long"
- Truck, Hatchback and Formula1 should have a method drive and a method getIn
    - drive prints a message describing how it feels to drive the specific vehicle
    - getIn prints a message describing how you can get in the specific vehicle
    - In real-life, it's pretty impossible to drive or get in a toy car, 
    so we don't want to add this behavior to Toycar in our code.
- Truck and Hatchback should have honk behavior
    - honk prints a message describing the sound the honk makes of the vehicle
    - Since neither Formula 1 or Toy cars are equipped with honks in real-life, 
    we don't want to add this behavior in our code.
- Truck, Hatchback and Formula1 should have a method inspectEngine
    - inspectEngine will always print the same message, namely: "Engine's looking good!"
    - Come up with a solution that allows you to only once write the print statement in your code (and not 3 times)
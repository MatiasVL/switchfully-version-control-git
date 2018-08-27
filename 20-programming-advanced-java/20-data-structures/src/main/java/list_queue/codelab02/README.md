# Warming up

Create SolarSystem which contains a list of all the planets (String) of our solar system.

- Create a method in SolarSystem to add a new planet to the end of the list, do this test-first.
- Create a method in SolarSystem to add a new planet at a specific index of the list, do this test-first.
    - All planets with the same or a higher index should be shifted to the right.
- Create a method in SolarSystem to remove a planet from the list, do this test-first.
- Create a method in SolarSystem to replace a planet with another at a specific index from the list, do this test-first.
- Create a method in SolarSystem to swap two planets in the list based on their index, do this test-first.
- Create a method in SolarSystem to shuffle the planets in the list, do this test-first.
- Create a method in SolarSystem to reverse the current order of the planets in the list, do this test-first.
- Create a method in SolarSystem to properly print all the planets from the list, do this test-first.
- Make sure to properly encapsulate the list of planets, then provide a getter method that returns the list of planets
    - What is the result if another class creates an object of SolarSystem, calls this getter and adds a new planet directly to retrieved list?
    - Does this undermine encapsulation?
    - Search for unmodifiableList, see what it does and modify your getter.
        - Make sure you understand why this is important.
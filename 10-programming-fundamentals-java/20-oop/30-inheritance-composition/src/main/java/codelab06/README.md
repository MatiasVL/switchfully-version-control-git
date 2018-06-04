# Battle sim.

Design and implement a battle simulator service.

- A Soldier has a name, age, weapon and armor
- A Soldier has different types:
    - Archer
    - Swordsman
    - Pikeman
    - Axethrower
    - Slave
- A weapon has a name, attacking power and a variable stating if its a one- or two-handed weapon
- A weapon has different types:
    - Sword (high attacking power, one-handed)
    - Bow (medium attacking power, two-handed)
    - Pike (very high attacking power, two-handed)
    - Axe (medium attacking power, one-handed)
    - Dagger (low attacking power, one-handed)
- An armor has a name and defending power
- An armor has different types:
    - Strong armor (high defending power)
    - Medium armor (medium defending power)
    - Low armor (low defending power)
    - No armor (zero defending power)
    
Question: What is composition, what is inheritance?

- An army has a name and soldiers
- An army should have the following behavior
    - get the total attacking power of the army
    - get the total defending power of the army
    - get the total amount of soldiers in the army
    - merge armies: takes 2 armies, merges their soldiers and returns a new army
        - Question: Class or Instance method?
    - Print out a status report of the army, containing an overview of:
        - The different type of soldiers present in the army
        - Per soldier type, the total amount of soldiers
        - Per soldier type, the sum of their attacking and defending power
- A battle simulator service has no state, it does provide the following behavior:
    - a Method to run the application
    - fight, which takes 2 armies (an attacking and defending army) and returns the victorious army
        - If the attacking army is double the size (or even more bigger) than the defending army, it automatically wins.
        - If the attacking army is half the size (or even smaller) than the defending army, it automatically loses.
        - Otherwise, if the combined attacking power of the attacking army is 1.2 times the combined defending power of the defending army,
        the attacking army wins. Otherwise the defending army wins.
        
Create some armies and let them fight using your battle simulator application. 
Ave, Imperator, morituri te salutant!
# Monster

> This is an optional codelab, for if you need some extra practice.

## Requirements

1. Create a `Monster` class that has 3 child classes: `KindMonster`, `GiantMonster` and `ScaryMonster`.
2. Every monster has a name and an attack power and a health (which can be 0 up to and including 10)
    - By default, the health is 10.
    - The attack power is specific to the type of monster
        - Kind monsters have attack = 1
        - Giant monsters have attack = 15
        - Scary monsters have their attack provided on 
3. Every monster has a `isAlive()` method. It will return `false` if the health is 0 and `true` otherwise.
4. Every monster has a `fight(...)` method.
    - As a parameter, a monster object should be provided (the monster to fight)
    - By default, a fight method will subtract the attacking monster's attack
    from the attacked monster's (provided as the argument) health.
        - (Health can not go below 0)
    - When a dead (not alive) monster attacks or is attacked, the health is not changed. 
5. For the `KindMonster`, the `fight(...)` method does something else: instead of subtracting the attack value from the 
attacked monster's health, the attack value is added (it's a kind monster...).
    - A dead (not alive) kind monster can not fight (the health remains unchanged)
    - A kind monster fighting a dead monster will still add its attack to the health of the dead monster (thus reviving him).

Finally, in a `main` method, create multiple `KindMonster`, `GiantMonster` and `ScaryMonster` objects
and let them fight. Make sure to check if they are alive between fights.        

# Habitats for Animals

A Habitat contains a list of Animals
and offers an (abstract or not?) method addInhabitant to allow adding another animal.

Using generics:
- Make sure that only Fish can be added to the Ocean habitat
- Make sure that only Camels can be added to the Desert habitat

The diagrams below might assist you:

```` 
..............
| (abstract) |
|   Animal   |
..............
    ^  ^
    |  |__________
    |             |
..........    ..........       
| Camel  |    |  Fish  |
..........    ..........
````
```` 
..............
| (abstract) |
|   Habitat  |
..............
    ^  ^
    |  |__________
    |             |
...........    ...........       
|  Desert |    |  Ocean  |
...........    ...........

````

# Habitats for Animals

A `Habitat` (generic or not?) contains a list of animals
and offers an (abstract or not?) method `addInhabitant` to allow adding another animal to the habitat.
- E.g. a fish (animal) should be able to be added to the list of inhabitants of the ocean (habitat)

Using generics:
- Make sure that only `Fish` (animals) can be added to the `Ocean` habitat
- Make sure that only `Camel` (animals) can be added to the `Desert` habitat

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

# Fruit tree

> An apple a day keeps the doctor away.

You're going to create a generic fruit tree class that is able to hold fruits.

# Requirements

Create a `FruitTree` class, it should declare a type parameter which is used for the type of the fruit it stores.

A `FruitTree` provides 2 methods:
- A method to add a (one) new piece of fruit to the tree
- A method to get all the fruits from the tree

A `FruitTree` has, besides its fruits, also an `age` as its state.

When an instance of a `FruitTree` is created, an initial `age` should be provided (a newly created `FruitTree` does not contain any fruits yet).

## Fruit

Currently, there exist 2 different kinds of fruit: `Apple` and `Orange`

## Execute

Create a separate class in which you implement a `main` method.
- Create a `FruitTree` instance that holds `Apple` fruits and add some apples to it.
    - Then, also get all the fruits of that fruit tree.
- Create a `FruitTree` instance that holds `Orange` fruits and add some orange to it.
- Create a `FruitTree` instance that holds any kind of fruit and add some apples and oranges to it.
- Create a `FruitTree` instance that holds `String` objects and add some string objects to it.
    - Is this possible? Is this desirable?
    - We'll see how we can deal with situations like this in the coming slides.


# Generic interface

We're going to create a way to store 2 objects into one object, in a so called pair or tuple object.
- One pair object will hold 2 other objects (a left and a right object)

## Requirements

Create an interface called `Pair`.

It should define 3 methods:
- Method `store` which takes in two arguments **of the same type**, the arguments are our two pair elements (left and right).
- Method `getLeft` to get the left element of the pair.
- Method `getRight` to get the right element of the pair.

For the type of the left and right element of the pair, use a type parameter.
- Thus, `Pair` is a generic interface
- The left and right element **must always be of the same type**!

## Implementations

Create two distinct implementations of `Pair<E>`:
- `StringPair` which is a non-generic class that implements `Pair<E>`. `StringPair` should only be able to hold left anc right elements of type `String`.
- `IntegerPair` which is a non-generic class that implements `Pair<E>`. `IntegerPair` should only be able to hold left anc right elements of type `Integer`.

## Execution

Create a `main` method in which you create at least one `IntegerPair` and one `StringPair`, then use the `getLeft`and `getRight` methods on them. Validate the types (and objects) that are returned by these methods.
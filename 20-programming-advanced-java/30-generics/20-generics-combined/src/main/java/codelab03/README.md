# Generic class and generic interface V2.0

Copy and paste you `Pair<E>` interface and your `SimplePair<T>` class from the previous codelab into this package.

## Requirements

This time, we're going to refactor our existing `Pair<E>` interface.

Up until this point, the left and right element had to be of the same type.

Now, **refactor your interface so that the left and right element can be of a different type**!

Then, **create class `FlexPair`**, which implements your refactored `Pair` interface and declares two type parameters of itself (one for the type of the left element, one for the type of the right element)

Normally, class `SimplePair<T>` should fail to compile now (since we changed the interface it has to implement). 
Fix the `SimplePair<T>` class so that it compiles again.
- However, **make sure that the left and right element of a `SimplePair<T>` object still always are of the same type!**
    - For your information: `SimplePair<T>` only requires one type parameter, namely `T`.

## Execution

Create a `main` method in which you create at least two different `FlexPair<T1, T2>` instances:
 - One instance for which you provide type `String` for type parameter `T1` and `Integer` for type parameter `T2`
 - One instance for which you provide type `String` for type parameter `T1` and `String` for type parameter `T2`
 
 Also, create an instance of `SimplePair<T>`:
 - One instance for which you provide type `String` for type parameter `T`.
 
 Then, use the `getLeft`and `getRight` methods on them. Validate the types (and objects) that are returned by these methods.
 
 Hopefully, it's clear that `FlexPair<T1, T2>` can do whatever `SimplePair<T>` can **and more** *(making `SimplePair<T>` redundant)*.
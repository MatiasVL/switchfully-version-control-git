# Generic class and generic interface

Copy and paste you `Pair<E>` interface from the previous codelab into this package.

## Requirements

This time, we're not going to create two distinct implementations of `Pair<E>`. Instead, we're going to create one, generic implementation.

Create class `SimplePair`, which implements interface `Pair<E>` and declares a type parameter of itself (call it `T`).
- The type parameter `T` of `SimplePair<T>` should be used as the provided type for the type parameter of interface `Pair<E>` upon implementation.

## Execution

Create a `main` method in which you create at least three different `SimplePair<T>` instances:
 - One instance for which you provide type `String` for type parameter `T`.
 - One instance for which you provide type `Integer` for type parameter `T`.
 - One instance for which you provide type `Double` for type parameter `T`.
 
 Then, use the `getLeft`and `getRight` methods on them. Validate the types (and objects) that are returned by these methods.
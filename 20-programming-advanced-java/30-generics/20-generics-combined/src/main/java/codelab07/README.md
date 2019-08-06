# Generic count

**Note:** This is a difficult exercise. However, it does show the true powers of generics for creating reusable,
generic methods (and classes). Do give it a real try!

Write a generic method (`genericCounter`) that has as parameters a collection and a certain filter, 
and returns the amount of elements of the collection that match the given filter.
- Each element from the collections should be checked with the filter (does it match?)
  - Thus, the filter should have a single method that takes in an element and checks if it matches against a certain criteria.
- The type of the elements of the collection should always be the same as the type of the element the filter takes in

Some examples:
- Given List of Strings `("Hello", "Wooooorld", "ok")` and a Filter `MaxLength5` (length of string should be 5 or lower)
  - Should `return 2`.
- Given List of ints `(1,2,3,4,5,6,7)` and a Filter `UnevenInts` (only uneven int's)
  - Should `return 4`.

## Tips

If you think you know everything to get started, please just go for it.

If not, here is some **pseudo-code** for what a possible implementation for the `GenericCounter` method could look like. (You still have to design your filters though):
```
method int GenericCounter(collection, filter)
    counter = 0
    foreach element in collection
        if element matches with filter
            then increment counter with 1
        else do nothing
    return counter
```

## Actual Solution

You can find a solution of the problem in the `solutions` branch.
However, don't yet take a look at it. Only click on the link if have solved the codelab or if you have really tried to solve this codelab 
AND already asked for help from on of the trainer-developers.

> A Solution: https://docs.oracle.com/javase/tutorial/java/generics/QandE/generics-answers.html


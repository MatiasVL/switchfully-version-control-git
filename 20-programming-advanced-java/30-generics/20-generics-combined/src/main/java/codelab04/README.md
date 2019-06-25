# Generic swapper

Write a **generic method** to exchange the positions of two different elements in an array.
The method should return the new array (wherein the two elements have been swapped).

- As parameters, provide the array itself, the index of the first element to swap and index of the second element to swap.
- As return type, use the type of the array.

Apply **TDD**, write your tests first!

## Example calls

- calling `YourClass.swap([1, 8, 3], 0, 2)` (pseudo-code) should return an array of type `int` containing `[3,8,1]`
- calling `YourClass.swap(["x", "b", "c"], 0, 2)` (pseudo-code) should return an array of type `String` containing `["c", "b", "x"]`
- ...
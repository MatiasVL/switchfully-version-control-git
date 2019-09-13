# Shape

> This is an optional codelab, for if you need some extra practice.

## Requirements

1. Create a `Shape` class that has two child classes: `Rectangle` and `Triangle`.
2. All shapes have a color (a self-created enum with colors red, blue, green and yellow as allowed values).
3. All shapes have a `getArea()` method, the default implementations is to return value 0.0
    - (ideally, we make it abstract, but that's something you have to yet learn, so don't)
4. A `Rectangle` has a length and a width.
    - For a `Rectangle`, the `getArea()` should return the area based on length and width.
5. A `Triangle` has a base (width) and a height.
    - For a `Triangle`, the `getArea()` should return the area based on length and width.
6. All shapes should have a `toString()` method.
    - By default, it returns the color
    - Additionally, for a `Rectangle`, it also returns the length and width (+ the color)
    - Additionally, for a `Triangle`, it also returns the base and height (+ the color)
    
Finally, in a `main` method. Create an array in which you store 2 `Rectangle` objects and 2 `Triangle` objects.
Then, loop over the array and call - for every object in it - the `getArea()` method (and print the result + the full object). 

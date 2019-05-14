# Treehehehe

Let's create some Tree's and save mother earth!

> Disclaimer: you're not going to save mother earth by doing this codelab... :'(

## Tree

A `Tree` has an age (int) and height (`Height`)

### Height
A `Height` has 
- A heightAmount (double)
- A heightUnit (Enum `HeightUnit`: METER, FOOT)

A `Height` has the following behavior
- A conversion method which takes meters, converts it to feet and returns a new Height object.
- A conversion method which takes feet, converts it to meter and returns a new Height object.

`Height` is a great example of what we call a **value object**. It doesn't have an identity and should be **immutable** (make all fields `final`).
Furthermore, it only offers **pure** methods. 
- [Value objects](https://en.wikipedia.org/wiki/Value_object)
- [Pure method / function](https://en.wikipedia.org/wiki/Pure_function)

Once you're done with `Height`, get back to `Tree` itself.

A `Tree` has the following behavior
- `grow` which grows the height of the Tree
- A method to result its height and age in a textual representation. 
    - It would be a bonus if we could also have the type (appletree, oak,...) in this text.

A `Tree` has different types:
- AppleTree
    - calling grow will grow this tree by 0.6 meter
- Oak
    - calling grow will grow this tree by 0.5 meter
- WeepingWillow
    - calling grow will grow this tree by 0.1 meter
- Fir
    - calling grow will grow this tree by 1.2 meter
- OrangeTree
    - calling grow will grow this tree by 0.3 meter
- BulaYakaTree
    - calling grow will grow this tree by 0.8 meter
        
So far so good!

## Fruit trees   
        
A `FruitTree` is a `Tree` that has `FruitItems` (max size: 10)
- AppleTree, OrangeTree and BulaYaka are FruitTree's
- A FruitItem has a Color (awt package)
- A FruitItem has different types:
    - Apple (red)
    - Orange (orange)
    - Bula (yellow)
    - Yaka (red)

A FruitTree has the following behavior
- `harvestFruit` which will empty the array of FruitItems
    
Almost there...

## Forest
    
A `Forest` contains `Trees`
- A Forest has the following behavior
    - `displayTrees` which returns a String containing the total amount of trees in the forest and the
    textual representation of every tree
    - `forestFire` which removes all the FruitTrees from the Forest
    
## Application    
    
Create an application that
- Creates a Forest with 10 or more Trees.
    - Some trees should be FruitTrees, give them some FruitItems!
- Uses the `displayTrees` method
- Uses the `forestFire` method
- Uses the `displayTrees` method again



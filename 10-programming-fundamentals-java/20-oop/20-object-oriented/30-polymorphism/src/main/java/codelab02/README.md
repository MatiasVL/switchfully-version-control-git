# Treehehehe

- A Tree has an age (int) and height (Height)
    - A Height has 
        - A heightAmount (double)
        - A heightUnit (Enum HeightUnit: METER, FOOT)
    - A Height has the following behavior
        - A conversion method which takes meters, converts it to feet and returns a new Height
        - A conversion method which takes feet, converts it to meter and returns a new Height
- A Tree has the following behavior
    - grow which grows the height of the Tree
    - A method to result its height and age in a textual representation. 
    It would be a bonus if we could also have the type (appletree, oak,...) in this text.
- A Tree has different types:
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
        
- A FruitTree is a Tree that has FruitItems
    - AppleTree, OrangeTree and BulaYaka are FruitTree
    - A FruitItem has a Color (awt package)
    - A FruitItem has different types:
        - Apple (red)
        - Orange (orange)
        - Bula (yellow)
        - Yaka (red)
- A FruitTree has the following behavior
    - harvestFruit which will empty the array of FruitItems
    
Almost there:
    
- A Forest contains Trees
- A Forest has the following behavior
    - displayTrees which returns a String containing the total amount of trees in the forest and the
    textual representation of every tree
    - forestFire which removes all the FruitTrees from the Forest
    
Create an application that
- Creates a forest with 10 or more trees.
    - Some trees should be FruitTrees, give them some FruitItems!
- Uses the displayTrees method
- Uses the forestFire method
- Uses the displayTrees method again



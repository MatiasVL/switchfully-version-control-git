# Binary Tree

A binary tree is a tree data structure in which each node has 0, 1 or 2 children nodes. (google for more information if required, or just if you're curious.)

Example Binary Tree:
```
           Node A
             /\
            /  \
           /    \
          /      \
      Node B    Node C
        /\
       /  \
      /    \
     /      \
 Node X    Node Y
```

Create a class `BinaryTree` that represents a binary tree. The only thing the binary tree needs to know about is its root node (the node from which the binary tree starts: (Node A in the example)).

The root `Node`, as any other `Node`, should only know about its direct children (in example: Node B and Node C).

A `Node` has a label (of any type). **This type is provided upon instantiation of a binary tree**. 
A binary tree instantiated with a certain type for its type parameter can not hold nodes with another type parameter than his own.
- E.g. a label can be a Character (`A`), an Integer (`1`) or even a String (`Alpha`).

## Draw
Create a method `draw()` in the binary tree class that draws the binary tree (see an example output below).
It starts from the root node and then continues with its children. Deeper and deeper until fully traversed (and drawn).
- Traverse the tree depth-first (google this)
    - (Traversing the tree breadth-first will be more a lot more difficult)

Example output (the binary tree from above, printed out in your program):
```
A 
  \ --- B  
          \ --- X
          \ --- Y      
  \ --- C
```

# Graph Algorithms

Write an application which implements the depth-first and bread-first algorithms to traverse a graph.

- A Graph consists of Nodes (and edges connecting those nodes)
- A Node has a name and a list of child Nodes (per definition the edges).
- A Node can have 0, 1 or more children

```
    A __
   / \  \__
  /   \    \__
 /     \      \
B       C      D
       / \  
      /   \ 
     /     \ 
    E       F 
```

The application should provide a answer for the following problem: Given a starting Node, find the path to a goal Node

E.g.: Given above Graph, find a path from starting Node A to goal Node D
- Order of visited Nodes using Depth-first: A -> B -> C -> E -> F -> D
- Order of visited Nodes using Bread-first: A -> B -> C -> D 

## The application

1. Write implementations of Depth-first search and Bread-first search
2. Write a method which accepts a search algorithm, a Graph and a goal Node as arguments. 
This method should return the path (list of Nodes).
    - We'll always have A as our starting node

Use the following Graph (actually a Tree, which is an undirected Graph).
(Draw this graph on a piece of paper)

```
A ---> B
A ---> C
A ---> D
A ---> E
A ---> F
B ---> G
B ---> H
F ---> I
H ---> J
H ---> K
C ---> L
C ---> M
M ---> N
M ---> O
O ---> P
O ---> Q
E ---> R
E ---> S
E ---> T
E ---> U
T ---> V
T ---> W
F ---> X
F ---> Y
Y ---> Z
```

Execute the following cases in your application
1. Starting Node A, goal Node S
2. Starting Node A, goal Node F
3. Starting Node A, goal Node K
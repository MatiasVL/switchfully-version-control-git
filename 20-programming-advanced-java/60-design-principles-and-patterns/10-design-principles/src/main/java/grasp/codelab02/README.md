# Game of Life

>: The Game of Life, also known simply as Life, is a cellular automaton devised by 
the British mathematician John Horton Conway in 1970. The game is a zero-player game,
meaning that its evolution is determined by its initial state, requiring no further input. 
One interacts with the Game of Life by creating an initial configuration and observing how 
it evolves, or, for advanced players, by creating patterns with particular properties. (Wikipedia)

## GRASP

GRASP stresses the importance of a good design. 
Use GRASP to see why the game of life exercise is an example of poor design.
- Go over the GRASP principles and verify them against the current code
    - do they apply here?
    - are they violated?

Use GRASP to improve the design.
- Try to come up with a solution that is more inline with GRASP
- Draw your design and discuss with your pair before implementing 
- Implement your solution
    - What improved using GRASP?
    - What are the drawbacks?
    
There's a fully worked out solution in the `solutions` branch. Take a look at it when you're done with your own solution.
- It might be a bit over-engineered, but it demonstrates how far (even too far) you can go in refactoring code according to principles.

## Tests

There is a test class present to validate the exact behavior of the code.
- You're welcome :)

## Rules of Game Of Life
The universe of the Game of Life is an (infinite), two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, alive or dead, (or populated and unpopulated, respectively). Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:

1. Any live cell with fewer than two live neighbors dies, as if by underpopulation.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

The initial pattern constitutes the seed of the system. The first generation is created by applying the above rules simultaneously to every cell in the seed; births and deaths occur simultaneously, and the discrete moment at which this happens is sometimes called a tick. Each generation is a pure function of the preceding one. The rules continue to be applied repeatedly to create further generations.

These rules have been implemented (be it in an ugly way) by the `life` method. 

## More information
1. [Game of Life (Wikipedia)](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)
2. [Game of Life (Wikipedia, Dutch)](https://nl.wikipedia.org/wiki/Game_of_Life)
3. [Examples of Patterns (Wikipedia)](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#Examples_of_patterns)
4. [Game of Life Simulation](https://bitstorm.org/gameoflife/)

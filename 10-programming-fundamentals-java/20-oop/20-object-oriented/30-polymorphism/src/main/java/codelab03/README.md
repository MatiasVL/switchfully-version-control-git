# Make some poly-sound!

When you look at the SoundService, you'll notice the allMakeSound method is overloaded a couple of times.
In total, we have 4 versions of the allMakeSound, which do exactly the same, they only differ in their argument type.

Also notice how Baby, Cat, Dog and Computer all have a method makeSound which 
returns a textual representation of the sound they make.

# Firstly
- Create a Car
    - Write a test for Car which calls the method makeSound and expects the value "Tuut tuut!" to be returned.
    - Implement the makeSound method
    - Run the test again, it should be green now
- In the SoundService, create a new overloaded allMakeSound method which accepts an array of Cars    

# Secondly
Come up with a design on paper to refactor the code in such a way that we only need one allMakeSound method 
that accepts Babies, Cats, Dogs, Computers an Cars. 
At the moment, there isn't a hierarchical relation between these classes (and should there be one?) 
When ready with your design, discuss it with someone who also has his design ready!

Only then start with your implementation. Notice how all classes have tests, run them often! 
Write a new test for SoundService, try to do this before implementing your entire solution!

In the end, you'll have an implementation that is more powerful, 
more flexible and cleaner than the current implementation.
To demonstrate this:
- Create a Piano
- In the SoundService, you should be able to reuse the existing allMakeSound method, 
you don't have to write extra code / methods. Something which you would have to do in the old code!

# Safely Divide

## Part 1

- Run the DivideApplication, it should crash
- Run the DivideTest and DivideApplicationTest, all tests should fail.

Now, Implement method divide of Divide which should calculate the division of the numerator and denominator.
Hint: you'll need to parse a String to a double (class Double has a method for this)
- For now, you don't have to care about invalid user input
- All tests of DivideTest should become green

Running DivideApplication should now work, however, we'll be able to make it crash!
Try to make it crash yourself.
- This is also why still 3 out of 5 tests of DivideApplicationTest will fail.

## Part 2

Only start with this part if you've completed part 1.

In our divide method certain exceptions can occur:
- When the numerator or denominator are not parsable numeric double values

So, who's throwing these exceptions? Go to the online Java docs of Double, 
and go to the detail of the method which you used to parse Strings to doubles.

Inspect the method definition, inspect the `Throws` section! It tells you this method will throw certain exceptions under certain conditions.
It's important to be aware if (and what) exceptions are thrown by a method, by being aware, 
we can shield ourselves against their exceptional behavior which is relevant to us.

As **good** programmers, we have to do the following:
- Catch these exceptions in the divide method (we're not going to do this now) 
OR **explicitly** indicate that divide is a method which has exceptional behavior (let's do this)
- Catch the relevant exception (in our main method) which can be thrown by method divide
    - print message "Could not divide: non-numeric values were inserted" 
        - When the numerator or denominator are not parsable numeric double values
        
Run all the tests!
- Those of DivideTest should have remained green
- Those of DivideApplicationTest should now all be green as well

## Part 3

So, what if divide by zero? Won't this throw an exception? 
If it doesn't, shouldn't we throw an exception for it?

As you can see in the test, dividing by zero is something that is allowed in Java for Double.
We won't crash on it, the special Double value **Infinity** is automatically returned when this happens.
So although it might not be entirely desirable, the normal flow of our program won't be interrupted when receiving a 
denominator with value 0. So for now, we'll just let it fly and don't use any exceptions for it. 

## Finished?

Let someone else review your code!
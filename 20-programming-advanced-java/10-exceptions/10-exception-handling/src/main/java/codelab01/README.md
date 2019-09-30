# We're Nuclear!

Closely inspect the `NuclearPowerplant` class, and more specifically, the `increasePower(...)` method.
It's a potentially unsafe method (as it might throw an exception under a certain condition).

## Start simple

Start by going to the `PowerplantOperator` class, it serves as our application launcher (as it defines the `main` method).
In it, do the following:

1. Create an object of `NuclearPowerplant`.
2. on that object, call the `increasePower(...)` method with value `45`.
3. Print the value that is returned to the console.
4. Run the `main` method.
    - It should output value `95`.
    
So far, so good. Although the method is potentially unsafe, it's working without issues so far (since we're not 
triggering the exceptional situation).

### Let's trigger an exception

Now, in the main method, below the code of the previous assignment, do the following:

1. Create a new object of `NuclearPowerplant`.
2. on that object, call the `increasePower(...)` method with value `55`.
3. Print the value that is returned to the console.
4. Run the `main` method.
    - The exception of method `increasePower` should be thrown!
    - The program crashes....
    - Your statement printing the returned value is never reached, thus not executed.
        - The `increasePower` never even returned a value, as the method never successfully finished its execution (instead, it threw an exception).
        
Your output should be very similar to this:
```
95
Exception in thread "main" java.lang.IllegalArgumentException: DANGER! The total power would exceed the critical threshold of 100 (tried to increase with 55)
	at codelab01.NuclearPowerplant.increasePower(NuclearPowerplant.java:22)
	at codelab01.PowerplantOperator.main(PowerplantOperator.java:12)
```
- Notice how `95` is still being printed, however, the returned value of our second `NuclearPowerplant` object is not.

When it's clear a potentially unsafe method can be called in a way that it results in an exception being thrown, 
we should always **handle** its exception(s).

Let's do that right now!

### Handle that exception

In your `main` method, you have created two `NuclearPowerplant` objects, on which you called the `increatePower` method 
and printed our its result.

We have learned that calling the `increasePower(...)` method is potentially unsafe. Protect yourself against it by wrapping
that code in a `try...catch` block. For now, wrap all the code that's part of your `main` method into the `try{...}` block.

When you catch the exception, make sure to print out the following message: *"Could not increase power: {message of exception}"*.
- Where `{message of exception}` is filled-in with the message of the exception (`exceptionObject.getMessage()`). 

After having implemented this, run the `main` method again, the output should be as follows:
```
95
Could not increase power: DANGER! The total power would exceed the critical threshold of 100 (tried to increase with 55)
```
  
### Interrupted execution

Start by changing the argument of the first `increasePower(...)` method call from `45` to `77`. So, now also this call will 
result in an exception being throw (and not only the second call to `increasePower(...)`).

Then, run the `main` method. The output should be as follows:
```
Could not increase power: DANGER! The total power would exceed the critical threshold of 100 (tried to increase with 77)
```   
- Nothing is printed about our second call to `increasePower(...)` with value `55`... 

So... this means that the second call to `increasePower(...)` with value `55` is no longer executed. Remember how when 
an exception is thrown, the **execution is interrupted until a catch block is found** (if none is found, the program crashes).

After handling the exception in the `catch` block, the execution is resumed after / below that `catch` block.
Since our second call the `increasePower(...)` was part of that same `try` block, it will not be executed...

### Multiple try...catch blocks

Now, change the code in your `main` method so that both `increatePower` method calls are made in a different `try...catch` blocks.

Then, again, run the `main` method. The output should be as follows:
```
Could not increase power: DANGER! The total power would exceed the critical threshold of 100 (tried to increase with 85)
Could not increase power: DANGER! The total power would exceed the critical threshold of 100 (tried to increase with 55)
```   

Both method calls are performed, although both throw an exception. This is important to remember, and it might help you 
to decide whether or not to use one 'bigger' `try...catch` block, or multiple 'smaller'. It might also help you decide
what should be part of the `try` block and what should be place outside of it. 

Finally, change the argument of the second `increasePower(...)` method call from `55` to `11`.

Then, again, run the `main` method. The output should be as follows:
```
Could not increase power: DANGER! The total power would exceed the critical threshold of 100 (tried to increase with 85)
61
```   
- It's important to notice, that although our first method call results in an exception (which is caught!), 
the execution is resumed (from after the `catch` block) and thus executes our second `try` block, which successfully 
executes the `increasePower(...)` method and prints its returned value. 
# Eat, sleep, rave, repeat!

> Editorial remark: isn't it more logical to first rave, then sleep?

## Requirements

Implement the following requirements:

In `StringHelper`, create a class method (not an instance method) called `repeatArray` that:
- Takes in, as arguments, an array of String objects and a `count` (int).
- Returns a single String object that contains every word, repeated by the amount of `count`, in their original order.

An example to help clarify the requirements:
- Given `["Ha", "Jim"]` (String array) and `3` (count).
    - Return: `"HaHaHaJimJimJim"`
    
The following technical requirements have to be met as well:
- Implement your solution Test first (TDD): so first write one or more tests, only then implement the method. 
    - You can already define the method itself in `StringHelper`, however do not yet implement its body before having written the tests.
    - (Look at the tests of `codelab03` for inspiration)
- Use the `repeat` method of the `String` class.
    - Depending on whether you're using Java SDK 11, 12 or another version, read the proper documentation of method `repeat`.
    The class and method we're interested in might have been updated in a later version, so it's important to know which version of it you are using.
        - Java SDK 11: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#repeat(int) 
        - Java SDK 12: https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/String.html#repeat(int)
        - Java SDK 8: (the `repeat` method was introduced in Java 11, so it does not exist in any lower version)
    - Is the `repeat` method a potential unsafe method? Read the documentation, you'll get your answer.
    
## Done?

Done with the above? Good, then read on.

Create a `main` method. In it, run the following code snippet:
 ```Java
StringHelper.repeatArray(new String[]{"Beep"}, -1);
```

Did your program crash? Good! Detect who or what is throwing the exception.
Then, do the following:
1. Write a test for this specific situation (it should fail, thus exposing the issue we're having)
2. Fix the test by changing the code inside of `repeatArray`.
3. Rerun the test, it should succeed.
4. Rerun the `main` method, it should no longer crash. 
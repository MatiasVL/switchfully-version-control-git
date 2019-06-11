# What's on TV?

You'll find a `Television` class which has some potentially unsafe methods.

It offers 3 methods (`plugIn`, `turnOn` and `switchChannelTo`), when called in the right order (and with the right arguments),
they will never throw an exception. However, still, it's best to protect ourselves against any potential exceptions.

## TvApplication

Create a new class called `TvApplication` that has a `main` method. In it, create a new `Television` object.

On that object, call the `turnOn` method, followed by the `plugIn` method, followed by the `switchChannelTo(90)` 
method (mind the argument `90`).

Make sure that all methods are part of one big `try...catch` block that catches all the potential exceptions that could 
be thrown be these methods.
- An `IllegalStateException` should be catched and its message (`getMessage`) printed to the console.
- An `IllegalArgumentException` should be catched and its message (`getMessage`) printed to the console, 
but, prefix it with the text "INVALID ARGUMENT: {message of exception}".

In the `finally` block, make sure to print the entire `Television` object (use `toString()`).



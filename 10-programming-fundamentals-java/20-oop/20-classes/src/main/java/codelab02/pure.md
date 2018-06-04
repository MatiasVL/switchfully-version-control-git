# Pure and impure methods

You may not have noticed, but the way that we have implemented our add method, 
has turned our immutable object and made it mutable. 
There is now a way to modify the time object after it was created. 
This might not be an issue right here and now, but in practice, mutability adds complexity, 
complexity leads to problems, and problems lead to the dark side.

The add method as it is defined now is called an impure (or mutator) method because it changes the 
state of the object by modifying its attributes. 
The alternative is called a pure method, because it doesn't change the state of the object on which it is invoked, 
but rather returns the result of the modification to the caller.
# Rational

A rational number is a number that can be represented as the ratio of two integers. 
For example, 2/3 is a rational number, and you can think of 7 as a rational number with an implicit 1 in the denominator.

- Define a class called Rational. 

- A Rational object should have two integer instance variables that store the numerator and denominator.

- Write a constructor that takes no arguments and that sets the numerator to 0 and denominator to 1.

- Write the toString method for Rational (but first, write a test!).

- Write a second constructor that takes two arguments and uses them to initialize the instance variables.

- Write an instance method called negate that reverses the sign of a rational number. 
This method should be a mutator, so it should be void.

- Write an instance method called invert that inverts the number by swapping the numerator and denominator. 
It should be a mutator.

- Write an instance method called toDouble that converts the rational number to a double (floating-point number) 
and returns the result. This method is a pure method; it does not modify the object.

- Write an instance method named reduce that reduces a rational number to its lowest terms by finding the greatest 
common divisor (GCD) of the numerator and denominator and dividing through. 
This method should be a pure method; it should not modify the instance variables of the object on which it is invoked. 
Hint: Finding the GCD only takes a few lines of code. Search the web for “Euclidean algorithm”.

- Write an instance method called add that takes a Rational number as an argument, adds it to this, 
and returns a new Rational object. There are several ways to add fractions. You can use any one you want, 
but you should make sure that the result of the operation is reduced so that the numerator and denominator 
have no common divisor (other than 1).
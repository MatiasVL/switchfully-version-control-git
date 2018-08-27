# Self evaluation 1

## Codelab 00
### Questions
1. What is the difference between .java and .class files?
2. What is the signature of a method?
3. What is method overloading?

### More Questions (by Oracle)
4. The term "instance variable" is another name for ___.
5. The term "class variable" is another name for ___.
6. A local variable stores temporary state; it is declared inside a ___.
7. A variable declared within the opening and closing parenthesis of a method signature is called a ____.
8. What are the eight primitive data types supported by the Java programming language?
9. Character strings are represented by the class ___.
10. An ___ is a container object that holds a fixed number of values of a single type.

Correct answers(no peeking, only use it to validate your answers **afterwards**):
- https://docs.oracle.com/javase/tutorial/java/nutsandbolts/QandE/answers_variables.html


## Codelab 01
### Coding
1. Create a method that prints the string "Hello World!"
2. Create a method (`printAny`) that prints any string you give it.
3. Using method overloading, create two methods with the same name (`printNumber`).
    - Both have one parameter.
    - Both should print a message, although the message differs based on the type (int or double):  
        - I'm an int: <parameter> 
        - I'm a double: <parameter>
4. Create a method that returns the number it receives plus 1
5. Run the tests!
    - The tests expect all the methods to be static, which they can be.

### Questions
1. What are parameters?
2. What are arguments?
3. What is ```public static void main(String args[])``` ?
4. What are static methods?
5. What is the return type void?
6. What's the difference between int and Integer? double and Double?
7. What is the difference between a primitive and a (reference) data type?
8. What does over and under flow mean?
9. What is the difference between int and double?
10. What is variable declaration?
11. What is variable initialization?
12. What will the next block of code print: `1/2` or `0.5`? Why?  
    - `System.out.println(1/2);`

## Codelab 02
### Coding
1. Create a method that returns an array with all the letters of the alphabet.
    - Check the test to see if it's required to include lower and upper-casing
    - Run the test 
2. Replace the 3th element of an array by "do".
    - Run the tests

### Questions
1. What is the difference between a varargs and an array?
2. What are (the) different ways of initializing arrays?
3. Can we dynamically alter the dimension (size) of an array?

## Codelab 03
### Coding
1. Create a 2 dimensional array with size X and create the next patterns

Some examples (size = 2)

	@@
	@@

Some examples (size = 3)
 
	@@@
	@ @
	@@@
    
Some examples (size = 4)
    
	@@@@
	@  @
	@  @
	@@@@

Some examples (size = 5)
    
	@@@@@
	@   @
	@   @
	@   @
	@@@@@

    
### Questions
1. Can you create a 3 dimensional array?

### Questions not related to Arrays
1. What is autoboxing and unboxing? (Search it, if you don't know what it is)
2. What is casting? explain widening/upcast and narrowing/downcast
3. What are access modifiers? Explain all 4.
4. What is null?

## Codelab 04
### Coding
1. Create a method that returns the month in English by its number.
2. Create a method that takes in a number of elements and calculates a price based on the following rules:
    1. The first 10 elements costs 5 euro each.
    2. The following 5 elements costs 4 euro each.
    3. Every next element costs 3 euro each.
    4. A negative amount of elements will return 0
3. Create a method that returns the following:
    1. When the input is 1: "It's something"
    2. When the input is 2: "That's more like it"
    3. When the input is 3: "Way to go"
    4. Other input: "That's a fail whale"
    
### Questions
1. What is the difference between ```i++``` and ```++i```
2. What are the different kind of loops? explain their difference.
3. What are the different logical operators?
4. What is the output of following codeblock?
```java
boolean isTrue = true;
if(isTrue != false){
    System.out.println("It is true");
}
System.out.println("It is false");
```

## Codelab 05
### Questions (by Oracle)

Consider the following code snippet:
```
int i = 10;
int n = i++%5;
```
- What are the values of i and n after the code is executed?
- What are the final values of i and n if instead of using the postfix increment operator (i++), you use the prefix version (++i))?

### Extra questions (by Oracle)
- To invert the value of a boolean, which operator would you use?
- Which operator is used to compare two values (literals or references), = or == ?
- Explain the following code sample: 
```
result = someCondition ? value1 : value2;
```

Correct answers(no peeking, only use it to validate your answers **afterwards**):
- https://docs.oracle.com/javase/tutorial/java/nutsandbolts/QandE/answers_operators.html

## Codelab 06
### Coding
1. Create an `Alarm`.
2. Make sure we can use a no-arg constructor and an single argument (the sound to make) constructor. By default, the sound to make is "BEEP"
3. The ```makeSound``` method(s) should return an array containing x-times the sound to make.
    - We should be able to provide x, although it should not be required
    - If x is not provided, the return should contain the 'sound to make' 3 times.
        - This number is fixed!
    - Implement these requirements test-first!

### Questions
1. What is a class?
2. What is an object?
3. What is an instance?
4. What is the `Object` class?
5. What is inheritance?
6. What is method overriding? 
7. What is composition (and why favor it over inheritance)?

## Codelab 07
### Coding

1. Write a class whose instances represent a single playing card from a deck of cards. Playing cards have two distinguishing properties: rank and suit.
2. Write a class whose instances represent a full deck of cards.
3. Write a small program to test your deck and card classes. The program can be as simple as creating a deck of cards and displaying its cards.

### Questions

1. Consider the following class:
```
public class IdentifyMyParts {
    public static int x = 7; 
    public int y = 3; 
}
```
- What are the class variables?
- What are the instance variables?

2. What is the output from the following code:

```
IdentifyMyParts a = new IdentifyMyParts();
IdentifyMyParts b = new IdentifyMyParts();
a.y = 5;
b.y = 6;
a.x = 1;
b.x = 2;
System.out.println("a.y = " + a.y);
System.out.println("b.y = " + b.y);
System.out.println("a.x = " + a.x);
System.out.println("b.x = " + b.x);
System.out.println("IdentifyMyParts.x = " + IdentifyMyParts.x);
```

3. What's wrong with the following program?
```
public class SomethingIsWrong {
    public static void main(String[] args) {
        Rectangle myRect;
        myRect.width = 40;
        myRect.height = 50;
        System.out.println("myRect's area is " + myRect.area());
    }
}
```

4. The following code creates one array and one string object. How many references to those objects exist after the code executes? Is there one (or more) object(s) eligible for garbage collection?
```
String[] students = new String[10];
String studentName = "Peter Parker";
students[0] = studentName;
studentName = null;
```

5. How does a program destroy an object that it creates?

Correct answers(no peeking, only use it to validate your answers **afterwards**):
- https://docs.oracle.com/javase/tutorial/java/javaOO/QandE/creating-answers.html
- https://docs.oracle.com/javase/tutorial/java/javaOO/QandE/objects-answers.html

## Codelab 08
### Coding

Write a Dog, Labrador and Chihuahua class
- Dogs have a name and can bark
    - The barking sound is specific to the breed of dog
    - The name is specific to the instance of a dog
- Dogs also have an average breed weight
- We should be able to let dogs bark and get their average breed weight
- Chihuahuas also have a color
- Override the toString method
- Override the equals method: two dogs are equal if they are of the same breed and have the same name

## Codelab 09
### Coding

Write a Laptop class
- A laptop consists of a screen, a storage device, RAM, a processor, a keyboard and a mouse
    - Make sure that each of these is represented by a correct state and has some useful behavior.
    - A screen can be LCD or LED
    - A storage device can be HDD or SSD
    - A processor can have 3 different states: energy-saving, normal and overclocked. It should be possible to let a processor switch from state (during runtime)
    - We should be able to get the active and idle energy consumption of screens, storage (devices) and processors
- Think about your design (simply think about these questions):
    - When and where do we need inheritance?
    - When and where do we need abstraction?
    - When and where do we need composition?
    - When and where do we need interfaces?
    - When and where do we need to create additional concepts (classes)
    
## Finished? 
1. Ask feedback on your solutions
2. Complete all uncompleted previous codelabs.    
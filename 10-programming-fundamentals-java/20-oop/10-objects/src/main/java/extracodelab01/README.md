# MyCircle

**For your information**: This extra, optional codelab already covers the creation of classes 
(which is different than creation object / instances of classes).
Creating classes will be covered in the next module (module: classes)

## Create MyCircle class
Start by creation a `MyCircle` class.

It should have the following attributes / properties / state:
    - radius (double)
    - color (String)

It should have the following constructors:
    - A no-argument constructor which sets the radius to 1.0 and the color to "blue"
    - A constructor with radius as argument, the color should be set to blue
    
It should have the following intance methods / state:
    - getRadius() which returns the value of radius
    - getArea() which returns the area of a circle
    - setColor() which takes a color as a parameter and assigns it to the color instance variable (but doesn't return it)
    - getColor() which returns the color

## Inside MyCircleApplication

Firstly:
1. Declare an instance of MyCircle class called c1.
2. Construct the instance c1 by invoking the "default" constructor which sets its radius and color to their default value.
3. Print out the radius, area and color in a fun sentence

Secondly: 
1. Declare an instance of class MyCircle called c2.
2. Construct the instance c2 by invoking the second constructor with 8.5 as radius and default color. 
3. Print out the radius, area and color in a fun sentence

Make sure to not duplicate the code required for the third step in both (printing).
How can we reuse this code and write it once, but use it twice?
  
    
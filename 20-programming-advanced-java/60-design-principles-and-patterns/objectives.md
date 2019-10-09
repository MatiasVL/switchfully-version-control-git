# Design patterns and principles
- I understand the solid principles
    - I know what single responsibility means
        - I create methods with one purpose
        - I create classes with one purpose
        - I split methods and classes when they've got to much responsibilities   
    - I know what open/closed means
        - I create my classes in such a why that they are extendable
        - When I need to change a part of my code that is not extendable I make it extendable
        - I try to avoid instanceof or other structures that break inheritance
    - I know what the Liskov substitution principle entails
        - I know that I only can extend from a class if I have exactly the same behaviour as that class
        - I understand that every subclass is seen as an object of a superclass and needs to behave in the same way
    - I know what interface segregation means
        - I try to design my interfaces in such a way that every implementation can implement every method
        - When my interfaces is no longer a concise concept I split my interface to have better cohesion
    - I know what dependency inversion means
        - I try to program to interfaces as much as possible
        - I build in flexibility in my classes by using interfaces
        - I let the constructor of a class set the dependencies of that class
    - I know that I can not use the solid principles everywhere
        - I know that I can use them to create flexibility and reduce the amount of bugs, but I only use them if flexibility is required.
        
- I understand the GRASP principles
    - I understand what low coupling means and why it's important
    - I understand what high cohesion means and why it's important
    - I know that I need to think about which classes have which behaviour in order to reduce coupling and increase cohesion
    - I can model a simple application in such a way that it is easy to understand and maintain 
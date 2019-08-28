# Dependency inversion
## Testing and refactoring
* Try to write a test for SelfMadeBreadService without using mocks and without depending on the implementation of NormalBreadRepository
    * Is this possible? 
    * Why or why not?
 
* Refactor the code so that it confirms to Dependency Inversion
    * Implement interfaces & classes should no longer create objects
       
* Try to write the test again
    * Is it possible now?
    
* Introduce Dependency Inversion for the Service, Resource and the Mapper
    * Note! You won't be able to do this for every class. Which ones?
    * Note! Ignore the classes in the extras package for now
    
## Application configuration
* Remove the comments from the BakeryMain class
    * What kind of problem do you get?
    * Any idea how to solve this without using Spring (or any other kind of 3th-party framework)?
    
## Other configurations    
You want to sell your application to other kinds backeries: a fancy bakery that sells fancy bread and a wholesale bakery that gets its bread from a factory

* The necessary classes are already implemented in the extras package.
    * Change the classes in extras so they fit in the rest of the application
    * Adapt the main class so that 
        * when you provide 'fancy' as startup argument you get a fancy bakery application
        * when you provide 'wholesale' as startup argument you get a wholesale bakery application
        * when you provide 'normal' as startup argument you get the plain old application from the first exercise 
    

    
       

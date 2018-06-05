#JPA Creating, Reading, Updating, Deleting (CRUD)

## Exercises
### Create
1. Creating people
    1. Create a new table ``PERSON`` and a sequence for that table
        1. A person has a first name, last name and favorite color
    1. Create a method on ``PersonRepository`` that will persist a new person to the database
        1. What should happen if that person already exists?

### Read    
1. Reading people 
    1. Create a method on ``PersonRepository`` that will find a person by his name
        1. What should happen if you can't find a person?
        2. What should happen if you find more than one person?

### Update    
1. Updating people.
    1. Create a method where you lookup a person by his name and change his favorite color to a given new color.
        1. A repository should only implement the most basic methods. A good idea would be to use ``PersonService`` for this exercise.
        1. Do you need to do these two steps in one method? What will happen if you do them separatly? 

### Delete    
1. Deleting people.
    1. Given the name of a person, delete him from the database
        1. What should happen if the person does not exist?
        
### Transactions
1. Make a new method that will create a new Person. Throw an exception right after the creation. 
    1. What should happen?
    1. Why is this important?
        
        

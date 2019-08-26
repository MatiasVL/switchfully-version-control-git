#JPA Creating, Reading, Updating, Deleting (CRUD)

We continue with transforming `SwitchToTheSun` to hibernate.

## Exercises
### Create
1. We're going to focus now on the creating a country functionality.
    1. Try inserting a new country in the database with `entitymanager.persist` in the `CountryRepository`
    1. You'll probably get an error saying something about ids
        1. Try to fix this with the `@SequenceGenerator` and `@GeneratedValue` annotations
    1. Next try again inserting a new country in the database. You'll get a new error talking about transactions.
        1. Try to fix the error with the `@Transactional` annotation.
        1. Be sure to use the spring `@Transactional` and not the javax one
    1. This time it should work!
    1. Make sure that all edge cases still work. If not: fix them!

### Read    
1. Now we're going to replace all the jdbc queries with hibernate queries. The remaining queries should be: 'findAttractionsOfType', 'findAttractionsInCountry' and 'getAllCountries'
    1. Replace all three with hibernate queries. You'll need to lookup what the differences are.
        1. Are all queries prepared statements?
    1. Normally you should have introduced a type field for findAttractionsOfType of type String. 
    Make an enum name AttractionType with values `MONUMENT, BEACH, CITY`. Change the type of the field type into AttractionType.
        1. Look at the `@Enumerated` annotation for help 

### Update
1. The only update statement we have is the metadata so lets switch that one to hibernate as well.    
    1. Create a metadata class and make it an entity
    1. Change the getNumberOfVisits to getAllMetadata and let it return a list of metadata
    1. Update the metadata in the `ReportHandler`
        1. Does the update still work?
        1. Try adding `@Transactional` in the repository does it work now?
        1. Try starting the transaction in the `CommandHandler` does it work now?
        1. Why does it behave in this way?
        
#### Extra
1. Throw an exception after updating the numberOfVisits in the `ReportHandler`. Will the update be persisted? 

### Delete
1. We only have one jdbcTemplate left! Go to the `CountryRepository` and change the delete method so that it uses hibernate.
    1. You'll need to lookup the country that will be deleted first    
1. Deleting people.
    1. Given the name of a person, delete him from the database
        1. What should happen if the person does not exist?
        
        
        

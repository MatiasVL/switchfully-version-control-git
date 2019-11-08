#JPA Creating, Reading, Updating, Deleting (CRUD)

We continue with transforming `SwitchToTheSun` to JPA (Hibernate).

- Look at the slides for links to additional resources **(!!)**

## Exercises
### Create
1. We're going to focus now on the 'creating a country' functionality.
    1. Try inserting a new country in the database with `entitymanager.persist` in the `CountryRepository`
        1. You'll need to specify the id generation strategy, or you will get an error / incorrect id
            1. Try to fix this with the `@SequenceGenerator` and `@GeneratedValue` annotations.
            1. https://www.mkyong.com/jpa/jpa-insert-oracle-sequences-example/
            1. https://www.objectdb.com/java/jpa/entity/generated
        1. Secondly, in order to persist, the entityManager needs an active transaction (which it wants to commit)
            1. Try to fix the error with the `@Transactional` annotation.
            1. Be sure to use the spring `@Transactional` and not the javax one!
    1. The persist, resulting in a stored Country entity with a correct id should succeed now.
    1. Make sure that all edge cases still work. If not: fix them!

### Read    
1. Now we're going to replace all the jdbc queries with JPA queries. The remaining queries should be: 'findAttractionsOfType', 'findAttractionsInCountry' and 'getAllCountries'
    1. Replace all three with JPA (using JPQL) queries. You'll need to lookup what the differences are.
        1. Are all queries prepared statements? (so, no raw data inputs but parameters)
    1. Normally you should have introduced a type field for findAttractionsOfType of type String. 
        1. Make an enum name AttractionType with values `MONUMENT, BEACH, CITY`. Change the type of the field type into AttractionType.
        1. Look at the `@Enumerated` annotation for help 

### Update
1. The only update statement we have is the metadata so lets switch that one to JPA as well.    
    1. Create a MetaData class and make it an entity
    1. Change the getNumberOfVisits to getAllMetadata and let it return a list of metadata
    1. Update the metadata in the `ReportHandler`
        1. Does the update still work?
        1. Try adding `@Transactional` in the repository does it work now?
        1. Try setting the annotation on the `Handler` interface does it work now?
        1. Why does it behave in this way?
        
#### Extra
1. Throw an exception after updating the numberOfVisits in the `ReportHandler`. Will the update be persisted? 

### Delete
1. We only have one jdbcTemplate left! Go to the `CountryRepository` and change the delete method so that it uses JPA.
    1. You'll need to lookup the country that will be deleted first.
    1. Make sure that all edge cases still work

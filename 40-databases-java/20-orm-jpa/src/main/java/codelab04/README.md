# Spring

In this codelab we'll be looking at a few ways Spring can make our life easier when working with databases.

- Look at the slides for links to additional resources **(!!)**

## Exercises
### Spring Data JPA Repositories
Spring boot has a handy sub-project named Spring Data.
By adding the `spring-boot-starter-data-jpa` artifact dependency, we get access to it.

One of its most 'magical' features are the Spring Data JPA repositories:
- It allows you to create a full fledged repository with just a minimal amount of code.

Change `AttractionRepository` and `CountryRepository` so that they use (one of) Spring Data's repositories.

### Spring testing
We've ignored testing thus far (the horror!). 

One of the issue's you might have while testing that it can influence the data you have on your local database, 
or that the executing of the tests takes more time as it has to connect to a remote database..
Let's write a test that uses an in-memory-database (the H2 in-memory database is already added as a dependency).

1. Write an integration test for `AddCountryHandler`.
    1. Test afterwards that the new country is in the in-memory-database
1. Write an integration test for `FindAttractionsInCountry`
    1. You'll need to prepare the database before you can start the test. Look at the different ways of doing this.
    
For your information: If your tests are properly configured, Spring will automatically roll-back the transaction started 
in the test, when the test ends. Meaning, no data is persisted, not even when using a 'real' database.
- The only exception is when we write an end-to-end test, when we test from the 'outside' (e.g. we startup our Spring Boot Application and contact the RESTful Web API of the application through HTTP).
    - In that scenario, the test will not be able to roll-back the transaction of the running Spring Boot Application. (in this scenario, a in-memory test database will prove itself most usable)

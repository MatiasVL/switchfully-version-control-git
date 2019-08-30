# Spring

In this codelab we'll be looking at a few ways Spring can make our life easier when working with databases.

## Exercises
### Spring data
Spring-boot has a handy extension named spring-data. 
It allows you to create a full fledged repository with just a minimal amount of code.
1. Change `AttractionRepository` and `CountryRepository` so that they use spring-data.`

### Spring testing
We've ignored testing thus far (the horror!). 
One of the issue's you might have while testing that it can influence the data you have on your local database.
Let's write a test that uses an in-memory-database.
1. Write an integration test for `AddCountryHandler`.
    1. Test afterwards that the new country is in the in-memory-database
1. Write an integration test for `FindAttractionsInCountry`
    1. You'll need to prepare the database before you can start the test. Look at the different ways of doing this.
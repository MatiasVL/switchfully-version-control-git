# Basic JDBC Connection

We're going to use JdbcTemplate to get data from the database

## Setup
1. Go to ``resources\application.properties`` and make sure that the ``app.datasource.password`` has the correct password.
2. Run ``SightRepositoryTest `` to make sure that everything is configured correctly
3. Execute `tour-operator.sql` to initialise your database

## Exercise
`SwitchToTheSun` is a local tour operator that is just starting their business.
 They come to you for setting up their web application.  
 
1. A nephew of `SwitchToTheSun` already started initialising a database. Unfortunately he couldn't finish because he just received a ps4 for his birthday.
Can you make an application that returns all the `sights` that are already in the database?
    1. `SightRepository` needs to return a list of all the sights in the `Sights` table but the implementation is incomplete.
        1. Complete the implementation so that the repository returns a list of all the sights
        1. Change the main method in `SwitchToTheSun` so that it prints out a list of all the sights
    1. `SwitchToTheSun` also wants you to show a list of all the countries in their database.
            1. Create a new `CountryRepository` and `country` class.
            1. Change the main method in `SwitchToTheSun` so that it prints out a list of all the sights  

1. Each country in the ``COUNTRIES`` table reference a region. We would like to to see the region for each country.
    1. Change the ``Country`` class so that it also has a region field.
    1. Change the ``getAllCountries`` method so that the countries it returns have the correct region.
        1. HINT: try to remember how to get the result of two tables with one query. 
    

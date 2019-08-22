# JDBC

We're going to use JdbcTemplate to get data from the database

## Setup
1. Go to ``resources\application.properties`` and make sure that the ``app.datasource.password`` has the correct password.
2. Run ``CountryRepositoryTest `` to make sure that everything is configured correctly

## Exercises
_Warning:_ The classes have the same name as the next exercise. Always verify that you have the right class by looking at the package name.
1. ``CountryRepository`` needs to return a list of all the countries in the ``COUNTRIES`` table but the implementation is incomplete.
    1. Complete the implementation so that it does work.
    1. Add Portugal (PO) to the database and verify that ``CountryRepository`` returns this as well.

1. Each country in the ``COUNTRIES`` table reference a region. We would like to to see the region for each country.
    1. Change the ``Country`` class so that it also has a region field.
    1. Change the ``getAllCountries`` method so that the countries it returns have the correct region.
        1. HINT: try to remember how to get the result of two tables with one query. 
    

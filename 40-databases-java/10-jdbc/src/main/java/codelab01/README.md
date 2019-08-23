# Basic JDBC Connection

We're going to use JdbcTemplate to get data from the database

## Setup
1. Go to ``resources\application.properties`` and make sure that the ``app.datasource.password`` has the correct password.
2. Run ``AttractionRepositoryTest `` to make sure that everything is configured correctly
3. Execute `tour-operator.sql` to initialise your database

## Exercise
`SwitchToTheSun` is a local tour operator that is just starting to automate their business.
 They come to you for setting up their web application.
 
### Reporting functionality
1. A nephew of `SwitchToTheSun` already started initialising a database. 
Unfortunately he couldn't finish because he just received a ps4 for his birthday.
Now `SwitchToTheSun` isn't sure what is in the database and what isn't.
To make more clear what is in the database they want you to create a reporting functionality.
    1. `AttractionRepository` needs to return a list of all the attractions in the `attractions` table.
        1. Complete the implementation so that the repository returns a list of all the attractions
        1. Change the main method in `SwitchToTheSun` so that it prints out a list of all the attractions
    1. `SwitchToTheSun` also wants you to show a list of all the countries in their database.
        1. Create a new `CountryRepository` and `Country` class.
        1. Read out the `Country` table and show a list of all available countries
        1. Change the main method in `SwitchToTheSun` so that it prints out a list of all the attractions *AND* all the countries
    1. Lastly do the same for all the continents in the database
1. The manager of `SwitchToTheSun` isn't sure if the reporting functionality will be used that often and wants to keep track of its use.
    1. Look at the `metadata` table. Every time you run the main method the `NUMBER_OF_VISITS` column needs to increase by 1.
    2. Print out after each report the number of times a report has been made.
    

### Admin functionality
1. The business notices that the continent of Antarctica isn't in the list of continents. They want you to provide a way of adding a continent.
    1. The main method is no longer used for just reporting. First change the main method so that it will listen to user input.
    Every time you type in `report` it should print out a report.
    1. Add a second functionality. Every time you type `add continent <name>` it should add a continent with name `<name>`
        1. What happens if you try to add the same continent twice? Provide a clear message for the user!
    1. Try out your new functionality
        1. Add a new continent and print out a report
        1. Restart your application and print out a report. Your new continent should still be there.
1. One of employees argues that Antarctica will soon no longer exist due to global warming. 
You try to explain that Antarctica is land and not just ice, to no avail.
Provide a way to delete a continent.
    1. Add a third functionality. Every time you type `remove continent <name>` it should remove the continent with name `<name>`
        1. What happens if the continent no longer exists?
        1. What happens if there are countries linked to the continent?
        1. Provide clear messages for both!
    
### QUERYING
1. For the last main functionality `SwitchToTheSun` wants you to provide some query mechanics
    1. Every time you type `find attractions with <type>` you print out all the attractions of type `<type>`
    1. Every time you type `find attractions in <country>` you print out all the attractions that are in the country `<country>`
    1. Every time you type `find countries in <continent>` you print out all the countries that are in the continent `<continent>`

### Refining
1. The business is happy with your reporting functionality and now wants you to extend it.
    1. Extend the reported attractions
        1. Every attraction is linked to a country. Change the reporting so that you also print out the country after the name of the attraction.
            - E.g. `The Louvre - France`
        1. Every country is linked to a continent. Change the reporting so that you also print out the continent after the name of the country.
            - E.g. `France - Europe`
        1. Extends the attraction reporting even more. Now print out both the country and the continent.
            - E.g. `The louvre - France - Europe`
    1. Make sure that the queries report in the same way!
            
### Extra's
1. New functionality that let's you add a new country and attraction
1. New functionality that reports the number of attractions in a country
1. New functionality that shows all the continents that have more than 2 attractions
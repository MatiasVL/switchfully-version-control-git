# Basic JDBC Connection

We're going to use JdbcTemplate to get data from the database

## Setup
1. Go to `resources\application.properties` and change to datasource properties so that they match your own.
    - Datasource URL: `jdbc:oracle:thin:@database.cuvv0osxzgmi.eu-west-3.rds.amazonaws.com:1521:admin`
    - Datasource username: STUDENTX
    - Datasource password: STUDENTX
2. Run `AttractionRepositoryTest ` to make sure that everything is configured correctly.
3. Execute `tour-operator.sql` (using IntelliJ Database or SQL Developer) to initialise your database.

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
1. The manager of `SwitchToTheSun` isn't sure if the reporting functionality will be used that often and wants to keep track of its use.
    1. Look at the `metadata` table. Every time you run the main method the `NUMBER_OF_VISITS` column needs to increase by 1.
    2. Print out after each report the number of times a report has been made.   

### Admin functionality
1. Travelling to Iceland is getting more popular by the day. Business would like Iceland to be in the list of countries. Can you provide a way to add countries.
    1. The main method is no longer used for just reporting. First change the main method so that it will listen to user input.
    Every time you type in `report` it should print out a report.
    1. Add a second functionality. Every time you type `add country <name>` it should add a country with name `<name>`
        1. What happens if you try to add the same country twice? Provide a clear message for the user!
    1. Try out your new functionality
        1. Add a new country and print out a report
        1. Restart your application and print out a report. Your new country should still be there.
1. One of employees argues that Iceland will no longer exist soon due to global warming. 
You try to explain that Iceland is land and not just ice, to no avail.
Provide a way to delete a country.
    1. Add a third functionality. Every time you type `remove country <name>` it should remove the country with name `<name>`
        1. What happens if the country no longer exists?
        1. What happens if there are attractions linked to the country?
        1. Provide clear messages for both when these cases happen!
    
### QUERYING
1. For the last main functionality `SwitchToTheSun` wants you to provide some query mechanics
    1. Every time you type `find attractions with <type>` you print out all the attractions of type `<type>`
    1. Every time you type `find attractions in <country>` you print out all the attractions that are in the country `<country>`

### Refining
1. The business is happy with your reporting functionality and now wants you to extend it.
    1. Extend the reported attractions
        1. Every attraction is linked to a country. Change the reporting so that you also print out the country after the name of the attraction.
            - E.g. `The Louvre - France`
    1. Make sure that the queries report in the same way!
            
### Extra's
1. The manager asked the business to give him the list of all attractions in Europe, so he could ask for governmental funds. 
However the business found no way of creating such a list besides doing it manually.
Help them out by linking all the countries to their respective continents.
    1. What will need to change so that you can provide a list off all the countries in a continent?
    1. What will need to change so that whenever you print out a country, you also print out the continent
    1. What will need to change so that when an attraction is printed out, you also, besides printing out the country, print out the continent?
    1. Do we need to change the interface for adding countries?
1. Create a new query that returns all the countries with no attractions    
1. Provide a way to add new attractions
1. Create a new query that reports the number of attractions in a country
1. Create a new query that shows all the continents that have more than 2 attractions

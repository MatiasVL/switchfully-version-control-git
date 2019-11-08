# Mapping

In this codelab we'll be extending the `SwitchToTheSun` exercise with extra data, thus allowing us for more relationships.

- Look at the slides for links to additional resources **(!!)**

## Exercises

### Embeddable
1. Extend the `COUNTRY` table with the following columns:
    1. population
    1. land area
    1. GDP
1. Create a new class `GeographicalInformation` (which encapsulates population, land area and gdp) 
and make it an embeddable of `Country`
    1. `GeographicalInformation` is a nice example of a Value Object, so give it the characteristics of a Value Object (see slides) 
1. Create a new functionality: Whenever you type in `geographical information <country>`, you'll get the geographical information of `<country>`
    1. As always think of the edge cases.
 
### OneToOne
1. Create a new table `ATTRACTION_OVERVIEW` with columns:
    1. Score `An overal score of the attraction between 0 and 100`
    1. Description
    1. Price
    1. Visitors per year
1. Create a one-to-one relationship between attraction and attraction overview.
    1. Create a link between the tables in the database
    1. Create an entity `AttractionOverview`
    1. Link the entities `AttractionOverview` and `Attraction` together
1. Create a new functionality: Whenever you type `attraction information <attraction>`, you'll get the extra information of `<attraction>`. 
    1. (Instead of spaces use '_': so, `attraction information The Colosseum` should become `attraction information The_Colosseum`)
    1. As always think of the edge cases
1. Think about the differences between an embeddable and a oneToOne relationship.
    1. What are the benefits?
    1. Why would you use one over the other?
  
### ManyToOne vs OneToMany
1. Let's add continents to our model (the table `CONTINENT` already exists).
    1. Start by adding a continent field to `Country`. Look at how `Attraction` added a country field.
    1. Make sure that every time you print a report of all the countries, you'll print out the continent name.
        1. e.g. `France - Europe`
1. Add a new functionality that prints out all the Countries in a `Continent` whenever you type `find countries in <continent>`.
    1. Do this by adding a field of type `List<Country>` to `Continent`
    1. Look at the `@OneToMany` annotation to help you.
1. Right now we have a bidirectional relationship. Most of the time this is not preferable. Try making the relationship unidirectional.
    1. Make the continent field in `Country` a `Transient` field.
    1. Adapt the OneToMany annotation so that it keeps working
    1. Test the `find countries in` functionality. It should print out the countries with null as continent name (because the continent was made transient)
1. Alternatively, make the bidirectional relationship unidirectional by keeping the `ManyToOne` annotation and dropping the `OneToMany` annotation.
1. Put everything back. So that you yet again have a bidirectional relationship.
Think about how you can make this relationship unidirectional without loosing any of the functionality. 
    1. Implement a solution
    1. Think about why we most of the time prefer to keep our relationship unidirectional.

### ManyToMany
1. Now we're going add tourists to our application (the table `TOURIST` already exists). 
A tourist can visit multiple attractions and attractions will be visited by multiple tourists.
We'll be adding two new functionalities `find tourists visiting <attraction>` and `find attractions for <tourist>`   
    1. Start by creating a tourist entity
    1. Then add a `List<Tourist>` field to `Attraction` and provide the mapping annotations. You can make changes to the database schema.
    1. Now try to a add a `List<Attraction>` to `Tourist`. What are the problems you face? What can you do to fix it? You can make changes to the database schema.
    1. Implement both functionalities
    1. Populate the database with some dummy data.
1. Yet again we have a bidirectional relationship. Do you see a way to change it to an unidirectional relationship, while keeping both functionalities?
    1. What would you do if both `Tourist` and `Attraction` have business logic depending on the relation,
     e.g. a tourist can only visit attractions in the same country and every attraction has a max amount of visitors?

####Extra
1. Write a functionality that will create an attraction. 
A user needs to provide information of the country the attraction is in and the overview information of the attraction.
    1. Look up cascade to help you
1. Write a functionality that will clear all the attractions from a country.
    1. An attraction that isn't connected to a country anymore should be deleted.
    1. Look at orphan removal for help
1. Extend the functionality of `remove country` so that also it deletes all the attractions the country has.
1. Write functionality that will add an attraction to a tourist.
    1. Create a subclass of tourist named CultureTourist. This tourist can only visits monuments and cities. 

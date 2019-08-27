# Mapping

In this codelab we'll be extending the `SwitchToTheSun` exercise with extra data.
## Exercises
### Embedables
1. Extend the `COUNTRY` table with the following columns:
    1. population
    1. land area
    1. GDP
1. Create a new class `GeographicalInformation` and make it an embeddable of `Country`
1. Create a new functionality. Whenever you type in `geographical information <country>`. 
You'll get the geographical information of `<country>`
    1. As always think of the edge cases.
 
### OneToOne
1. Create a new table ATTRACTION_OVERVIEW with columns:
    1. Score `An overal score of the attraction between 0 and 100`
    1. Description
    1. Price
    1. Visitors per year
1. Create a one-to-one relationship between attraction and attraction overview.
    1. Create a link between the tables in the database
    1. Create an entity `AttractionOverview`
    1. Link the entites `AttractionOverview` and `Attraction` together
1. Create a new functionality. Whenever you type `attraction information <attraction>`. 
You'll get the extra information of `<attraction>`. (Instead of spaces use '_')
    1. As always think of the edge cases
1. Think about the differences between an embeddable and a oneToOne relationship.
    1. What are the benefits?
    1. Why would you use one over the other?
  
### ManyToOne vs OneToMany
1. Let's add continents to our model.
    1. Start by adding a continent field to `Country`. Look at how `Attraction` added a country field.
    1. Make sure that every time you print a report of all the countries, you'll print out the continent name.
        1. e.g. `France - Europe`
1. Add a new functionality that prints out all the Countries in a `Continent` whenever you type `find countries in <continent>`.
    1. Do this by adding a field of type `List<Country` to `Continent`
    1. Look at the `@OneToMany` annotation to help you.
1. Right now we have a bidirectional relationship. Most of the time this is not preferable. Try making the relantionship unidrectional.
    1. Make the continent field in `Country` `Transient`.
    1. Adapt the OneToMany annotation so that it keeps working
    1. Test the `find countries in` functionality. It should print out the countries with null as continent name (because the continent was made transient)
1. Put everything back. So that you yet again have a bidirectional relationship.
Think about how you can make this relationship unidirectional without loosing any of the functionality.
    1. Think about why we most of the time prefer to keep our relationship unidirectional.

### ManyToMany
1. create a mapping between tourists and attractions
1. A book can belong to multiple people and a person has multiple books
    1. How would you model this relationship?
    1. Write a test where you add a book to a person and the book than has that person as a reader
        1. Can you see why such relationships are difficult to maintain?
        
#### Extra
1. Back to the bidirectional relationships
    1. Try setting the relation between person and address via the not owning side (probably address). 
    1. What happens?
1. Read the extra chapter on cascading
    1. Try to use a cascading type on a oneToMany relationship
    1. Does it simplify things
    1. Why is this not on by default?
    1. Why are there different cascading types?
    
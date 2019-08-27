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
  
### ManyToOne
1. Same as many to one. Already implemented
1. Create a new table ``hobby``
    1. it should have a ``name`` and a ``type``
1. Make a method that let's you create a new hobby
1. Make a method where you can give a person a hobby
    1. What happens if you use @OneToOne instead of @ManyToOne?
    1. How do you enforce that the oneToOne relational really is a oneToOne relationship?
    
### OneToMany
1. Create a mapping between continent and country
1. Create a new ``BOOK`` table. A book should have the following fields:
    1. Title
    1. Author
1. A Person can have multiple books. Use a OneToMany relationship.
    1. Create a test where you add a book to a person.
    1. Create a test where you remove a book from a person.
    1. Create a test removing all the books starting with an 'a'
    
### Unidirectional vs Bidirectional
1. Try to make the relation between ``PERSON`` and ``ADDRESS`` bidirectional
    1. Do you need to change the database schema?
    1. How do you add an address to a person? What has changed?
    1. How do you remove an address?
    1. Who owns who?
    1. What needs to change if you change the ownership?
 1. Try to make the relation between ``BOOK`` and ``PERSON`` bidirectional
    1. Same questions as above
 1. What are the reasons to only use unidirectional relationships?
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
    
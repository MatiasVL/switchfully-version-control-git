# Mapping

## Exercises
### Embedables
1. Extend the ``PERSON`` table from the previous exercise with the following columns:
    1. street name
    1. house number
    1. region
    1. zip code
1. A Person should have an address. Use the ``Address`` class as an embeddable.
    1. Adapt the test for creating a person. You should now be able to create a person with an address.
    1. Adapt the test for finding a person. Verify that the result also has an address.
 
### OneToOne
1. Remove the address columns from ``PERSON``.
1. Create a new ``ADDRESS`` table with the old columns.
1. Make a OneToOne relation between ``PERSON`` and ``ADDRESS``
    1. What is the relationship between person and address? Who should know who?
    1. Verify that the tests for creation and finding still work
1. What are the differences between using an embeddable and a OneToOne relationship?
    1. When would you use an embeddable?
    1. When would you use an OneToOne relationship?
  
### ManyToOne
1. Create a new table ``hobby``
    1. it should have a ``name`` and a ``type``
1. Make a method that let's you create a new hobby
1. Make a method where you can give a person a hobby
    1. What happens if you use @OneToOne instead of @ManyToOne?
    1. How do you enforce that the oneToOne relational really is a oneToOne relationship?
    
### OneToMany
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
    
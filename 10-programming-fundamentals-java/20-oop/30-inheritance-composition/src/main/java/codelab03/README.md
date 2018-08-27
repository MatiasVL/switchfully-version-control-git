# Person

Note: There is a test-class created (PersonTest).
It contains more information on what is expected to be implemented.
All test-methods are commented out (otherwise the code wouldn't compile). 
As soon as you think you're done with implementing the code, uncomment the tests and run them.

- Create a class Person with a name and a birthdate.
- Create a class Adult that has a jobtitle. It should also have a name and birthdate
- Create a class Child that has the name of the school they go to.
- Create a class UnbornChild that doesn't have a name nor a birthdate.
- They should all be connected to Person, and constructed with all of their expected values.

- Then, create the method introduce()
    - For a Person it would return "I'm a person: {name} I'm {age} years old";
    - For an adult it would return "I'm a person: {name} I'm {age} years old and work as a {jobtitle}"
    - For a child it would return "I'm {name} I'm already {age}! I go to {school}"
    - For an unborn child it would return an empty string.

# Funiversity

Let's create your own REST API in Spring

## Functional Requirements
- Create 2 Resources (a.k.a. Controllers)
    - professor (id, firstname, lastname)
        - E.g.: `Professor profFreddy = new professor(1, "Freddy", "Mertens");`
    - course (id, name, studyPoints, category, professor)
        - E.g. (object-based): `(1, "IT essentials", 6.0, "Computer Sciences", profFreddy);`
        - E.g. (id-based): `(1, "IT essentials", 6.0, "Computer Sciences", 1);`
- For each resource, we should be we able to do the basic CRUD operations: Create, Read (one and every), Update and Delete.
- Make it so we can do a (REST) search on courses based on their studyPoints and / or category.
    - E.g. 'give me the courses that consist of 4 study points'
- Make it so we can do a (REST) call to get all courses, given a professor (id)

## Technical Requirements
- Use Spring Boot (starter-web)
- Create an in memory data structure that functions as a 'database'.
    - Provide some initial data in your 'database'
- Use DTO's and Mappers
    - Do your own research! Why would one use DTO's?
- Create and throw your own custom exceptions in your code
    - Some examples
        - Someone tries to update an id
        - Someone tries to create a resource while providing an id
        - Someone tries to delete a resource with an unknown id
        - Someone tries to get a resource with an unknown id
        - ...
    - Forward your exceptions to the client of your API by using @ControllerAdvice (do your own research)
        - Use correct HTTP status codes in those cases!
            - E.g. when a professor could not be found for a given id, return status code 404.
- Make sure to have a layered (by module) structure: api - service - domain
- Write Tests-firsts
- write some integration tests (at the end) that test the complete integration: from controller to repository.

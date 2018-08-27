# Funiversity!

We've created a funiversity (fun university) REST API which offers some basic CRUD capabilities for professors.
You're going to have to make some calls to this API.

Since our webbrowser only performs simple GET calls, we need a tool do more complex and also other kinds of calls (POST, PUT, DELETE).

- Use the built in REST-test tool: `Tools > Test RESTful Web Service`
- Or, download Postman or Advanced Rest Client

## The API
- The base url of our funiversity is: `https://switchfully-funiversity.herokuapp.com`
- The resource (path) we'll use is: `professors`.

*Note: the first call can be very slow, it'll be a lot faster after that*

The API allows to 
- Get all professors
- Get an existing single professor
- Create a new professor
- Update an existing professor
- Delete an existing professor

## Making Requests

1. Perform a call to get all the professors
    - Inspect the response headers! What HTTP status code is returned? In what format is the data returned (Content-Type)?
    - Inspect the response! What data is returned?
2. Perform a call to get a single professor by providing an id in the path
    - The normal REST convention is used for this: `/resource/{id}`
    - Inspect the response headers! What HTTP status code is returned? In what format is the data returned (Content-Type)?
    - Inspect the response! What data is returned?
3. Create a new professor, give him/her a funny name
    - Inspect the response headers! What HTTP status code is returned? In what format is the data returned (Content-Type)?
    - Inspect the response! What data is returned?
4. Update your newly created professor (`/resource/{id}` + a payload), alter the name a bit
    - Inspect the response headers! What HTTP status code is returned? In what format is the data returned (Content-Type)?
    - Inspect the response! What data is returned?
5. Delete your professor (`/resource/{id}`)
    - Inspect the response headers! What HTTP status code is returned? In what format is the data returned (Content-Type)?
    - Inspect the response! What data is returned?

## Extra requests

If you didn't already, make the following requests:

1. Perform a call to get a single professor by providing an non-existing id!
    - What is returned (status code, body)? Why?
2. Create a new professor, but provide an id in the body
    - What is returned (status code, body)? Why?
3. Update a professor, but provide a non-existing id in the path (`/resource/{id}`)
    - What is returned (status code, body)? Why?
4. Update an existing professor, but provide an id in the body
    - What is returned (status code, body)? Why?
5. Delete a non-existing professor
    - What is returned (status code, body)? Why?
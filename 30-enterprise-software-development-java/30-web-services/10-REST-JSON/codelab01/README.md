# Funiversity!

We've created a Funiversity (fun university) REST(ful) Web API which offers some basic CRUD (Create, Read, Update, Write) capabilities for professors.
You're going to have to make some calls to this Web API.

The Funiversity REST(ful) Web API serves as the entrypoint to (and is in itself part of) the Funiversity backend application (which in its turn connects to a database). 
The Funiversity web application (frontend) will request data from the backend, using the Web API, and then present the received data to the user through its GUI.
- (There doesn't exist a Funiversity frontend)

You will serve as a client, just as the Funiversity frontend would.

Since our web browser only performs GET calls, we need a tool do more complex and also other kinds of calls (POST, PUT, DELETE).

- Use the built in REST-test tool of IntelliJ IDEA: `Tools > Test RESTful Web Service`
- Or, download Postman, Advanced Rest Client or a similar tool.

## The API
- The BASE URL of our funiversity web API is: `https://switchfully-funiversity.herokuapp.com`
- The resource we'll use is: `professors`.
- Combined, the URL is `https://switchfully-funiversity.herokuapp.com/professors`

*Note: the first call can be very slow, as the server might be idle (sleeping). It'll be a lot faster after that.*

The Funiversity REST(ful) Web API allows endpoints to 
- Get all professors
- Get an existing single professor
- Create a new professor
- Update an existing professor
- Delete an existing professor

## Making Requests

1. Perform a call (HTTP Request) to get all the professors
    - Inspect the response headers! What HTTP status code is returned? In what format is the data returned (Content-Type)?
    - Inspect the response! What data is returned?
        - You'll have to use the same format to create a professor.
2. Perform a call (HTTP Request) to get a single professor by providing an id in the path
    - The normal REST convention is used for this: `/resource/{id}`
    - Inspect the response headers! What HTTP status code is returned? In what format is the data returned (Content-Type)?
    - Inspect the response! What data is returned?
3. Create a new professor (by performing a HTTP Request), give him/her a funny name
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
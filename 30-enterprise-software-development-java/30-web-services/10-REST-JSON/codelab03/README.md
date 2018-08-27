# Client for Funiversity!

Write a client that uses your Funiversity API you created in the previous codelab.

Your API should allow to 
- Get all professors
- Get an existing single professor
- Create a new professor
- Update an existing professor
- Delete an existing professor
- Get all courses
- Get an existing single courses
- Get all courses based on study points and / or category
- Get all courses of a professor
- Create a new courses
- Update an existing courses
- Delete an existing courses

## Functional requirements

- Create a new project
- Write a Client that offers methods to perform each possible API call
    - The results should be printed
- If the API call results in an error, we want to log the error message of the server!
    - Do your research on Logging!
        - Use a logger!
    - Do your research on custom ResponseErrorHandlers of RestTemplate
        - Use a custom ResponseErrorHandler

## Technical requirements

- Use Spring boot (starter-web)
- Use RestTemplate
- Since your client is another project than your api, 
which will have to run when your client is running in order for your client to work, you'll have to make sure your client runs on a different port than 8080.
    - Do your research regarding spring's application.properties and the server.port property
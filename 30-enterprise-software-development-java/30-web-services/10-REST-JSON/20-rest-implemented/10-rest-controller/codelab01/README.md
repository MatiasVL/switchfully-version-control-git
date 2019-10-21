# Moviebase

This codelab contains (single-module) Maven project that contains a Spring boot application called Moviebase.

>: Moviebase is a simple Web API application that allows to get, create or update movie information.

The application should start without any problem, you can try this yourself by executing the `MoviebaseApplication` class.
If you receive the following statements in your console, the application is working as intended:

```
...
20XX-0X-XX 15:44:20.561  INFO 17088 --- [  main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8921 (http)
20XX-0X-XX 15:44:20.584  INFO 17088 --- [  main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
20XX-0X-XX 15:44:20.585  INFO 17088 --- [  main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.22]
20XX-0X-XX 15:44:20.675  INFO 17088 --- [  main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
20XX-0X-XX 15:44:20.675  INFO 17088 --- [  main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1122 ms
20XX-0X-XX 15:44:20.855  INFO 17088 --- [  main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
20XX-0X-XX 15:44:21.018  INFO 17088 --- [  main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8921 (http) with context path ''
20XX-0X-XX 15:44:21.022  INFO 17088 --- [  main] c.s.rest.moviebase.MoviebaseApplication  : Started MoviebaseApplication in 1.963 seconds (JVM running for 3.315)
```

Your application will listen on port 8921, with context path ' '
- Meaning: `http://localhost:8921` will contact our application (the base-path)
    - (if the context path was configured to, for example, `api`, we contact our application through `http://localhost:8921/api` (the base-path)) 

At package `com.switchfully.rest.moviebase.domain` you'll find the `Movie` class and the `MovieRepository` (bean) class. 
Inspect them closely, you will need to use them.
- However, you will not have to change them! They're "good to go".

At package `com.switchfully.rest.moviebase.webapi`, you'll find the `MovieController` class. You will have to modify 
this class and turn it into a proper REST(ful) controller that allows to accept some specific requests.

At package `com.switchfully.rest.moviebase.webapi.dtos`, you'll find the `CreateMovieDto`, `MovieDto` and `UpdateMovieDto` classes known 
as (Data) Transfer Objects. DTOs are simple objects that should not contain any business logic but may contain get, set, 
serialization and deserialization mechanisms for transferring data "over the wire" (e.g. HTTP). 
- Instead of sending our domain class `Movie` over the wire, we will use dedicated DTO classes. 

There are tests available.
- Unit tests for the repository
    - These will already succeed
- An integration test for the Controller.
    - This one will fail, as the code it is testing is not yet implemented...
    - Feel free to write new integration tests for the controller, e.g. for the Get One Movie method.

## MovieController

The `MovieController` should offer four distinct actions.
 
Make sure to pick the right resource name (http://base-url/<resource-name>), according to conventions.
 
In this controller, implement the following handler methods:
1. Create Movie
2. Get All Movies
3. Get One Movie
4. Update One Movie
 
### Create Movie
 
The handler method for creating a movie will have as its parameter a `CreateMovieDto` object (it should be the 
payload of the HTTP call). The method should return a `MovieDto` object.
- The data from `CreateMovieDto` has to be used to create a new `Movie` object, which is a **domain entity**.
- The new `Movie` object will receive a unique ID upon creation (see its constructor).
- Save the new `Movie` object using the `MovieRepository` (which is a Spring bean, so inject it properly in your controller).
- Use the data from the new `Movie` object an map it into a `MovieDto` object.
- Then, finally, return the `MovieDto` object.

The payload in both the HTTP-request and response should be of type JSON (`application/json`). The HTTP status code 
should return 201-CREATED (instead of 200-OK)

### Get All Movies

The handler method for getting all movies will have no parameters (at first). The method should return a list or array 
of `MovieDto` objects (not `Movie` objects, we do not want to expose our domain objects to the 'outside'), 
we use our DTO's for this).
- Get all the `Movie` objects using the `MovieRepository` (which is a Spring bean, so inject it properly in your controller)
- For every `Movie` object, map it into a `MovieDto` object.
- Then, finally, return all the `MovieDto` objects as a list or array.

The payload in the HTTP-response should be of type JSON (`application/json`). 

### Get One Movie

The handler method for getting one movie will contain a path variable (the ID of the movie). The method should return 
the `MovieDto` object (with data of the `Movie` object that corresponds to the ID. 
- Get all `Movie` object for the specified ID using the `MovieRepository` (which is a Spring bean, so inject it properly in your controller)
- Use the data from the new `Movie` object an map it into a `MovieDto` object.
- Then, finally, return the `MovieDto` object.

The payload in the HTTP-response should be of type JSON (`application/json`).

### Update One Movie
 
The handler method for updating a movie will have as its parameter an `UpdateMovieDto` object (it should be the 
payload of the HTTP call). The method should return a `MovieDto` object. The method has to contain a path variable (the ID of the movie to update).
- Get the existing `Movie` object using the specified ID and the `MovieRepository`.
- All the data from `UpdateMovieDto` has to be used to update the `Movie` object that corresponds to the specified ID.
- Save the updated `Movie` object using the `MovieRepository`
- Use the data from updated `Movie` object an map it into a `MovieDto` object.
- Then, finally, return the `MovieDto` object.

The payload in both the HTTP-request and response should be of type JSON (`application/json`).

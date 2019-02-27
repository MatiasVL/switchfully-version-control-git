# Digibooky application

In the previous codelab, using the Funiversity Web API, you could perform certain requests related to "professors".

Because the Funiversity Web API followed the standard conventions for REST(ful) Web API's, you knew the following:

If **GET** `https://switchfully-funiversity.herokuapp.com/professors` responded with a list of all professors.
- Then **GET** `https://switchfully-funiversity.herokuapp.com/professors/{id}` would respond with the professor matching `{id}`.
- Then **POST** `https://switchfully-funiversity.herokuapp.com/professors` would create a new professor (with the data from the body, which you hopefully provided in the right structure).
- ...

However, without being able to take a look at the actual implementation code of the Web API, there's no way to know if other resources or operations exist... 
Maybe the `students`, `courses` and `studyPrograms` resources exist?

**OpenAPI** is a specification that allows for defining REST(ful) Web API's. **Swagger** is an implementation (library) of OpenAPI that we can use in our Web API to properly define it.

We have added Swagger to the Digibooky backend.

## Digibooky backend

Let's start off with a HTTP GET request to `https://switchfully-ft-digibooky.herokuapp.com/digibooky/api/as/bookmanagement/books`
- Use Postman, make sure to set the following HTTP header: `Accept: application/json`.
- As a response, the Digibooky Web API should give you all the available books of Digibooky in JSON format.

*Note: the first call can be very slow, as the server might be idle (sleeping). It'll be a lot faster after that.*

Now, to find out what other resources are exposed and what operations are possible on them, navigate to the following URL
- [https://switchfully-ft-digibooky.herokuapp.com/digibooky/v2/api-docs](https://switchfully-ft-digibooky.herokuapp.com/digibooky/v2/api-docs)

It should look like one big JSON object that isn't very readable. But it does describe the Digibooky REST(ful) web API in detail.

However, since we're humans and not JSON parsers, Swagger includes a GUI the presents the above JSON file in a visual way. You can view it (and even use it as a client) on the following URL
- [https://switchfully-ft-digibooky.herokuapp.com/digibooky/swagger-ui.html](https://switchfully-ft-digibooky.herokuapp.com/digibooky/swagger-ui.html)
- (You can ignore the basic-error-controller)

Take your time to discover this visual API Document **and** sample client.
- If you feel like it, create a new Book or BookCopy or BookLoan.

## Digibooky frontend

This time, there is a frontend application available (an Angular web-app to be precise) that consumes (performs request to) the backend (using the REST(ful) Web API).

Using your browser, surf to [https://switchfully.com/track/functional/digibooky](https://switchfully.com/track/functional/digibooky).
- Try out the web application.
- Books that you created using the REST(ful) Web API directly (using Postman or the Swagger GUI) should also be visible in the web application.

Finally, let's validate that the web application (frontend) is communicating with the Web API (the backend).
1. Click on the Digibooky logo (top-left corner, in the header).
2. Press F12, this should open up your Developer Tools window in your browser.
3. Navigate to the Network tab (and leave it open, it will track your network traffic).
4. Now, click on the 'Books' link in the header.
5. A new record should appear in the Network tab (namely `Books`).
6. Click on it, you'll see that it was a HTTP(S) request from the web application to the REST(ful) web API.
    - Inspect the Headers (General, Request and Response)
    - Inspect the (HTTPS) Response, it contains all the books as JSON.
7. Now, click on the 'Create book' link in the header.
    - Another record should appear in the Network tab. This time `authors`.
    - Inspect it as well.
    - Since the user needs to select an author for the book he's creating, the web application first has to contact the backend to retrieve all the available authors. 
    The web application then creates a dropdown form element that contains these authors.
8. Create a book. After pressing the `Create Book` button a new record named `books` will appear in the Network tab.
    - This time, it's a **POST** call (containing a Request Payload).
    - (You can ignore the OPTIONS call; it's mandated by CORS)
    
Feel free to expirement some more with both the frontend or/and backend.

# Library

In this folder, you'll find two files:
1. The `Library.wsdl`file.
2. The `LibrarySOAPWebService-soapui-project.xml` file.

We'll use both.

## Library.wsdl

The `Library.wsdl`file describes the Library SOAP Web Service which consists of multiple operations.
- Open it in your favorite editor or even your browser and go through it. 
- Challenge yourself as to understand what operations are defined and what types can be provided in specific SOAP-requests and responses.

## LibrarySOAPWebService-soapui-project.xml

The `LibrarySOAPWebService-soapui-project.xml` file is a project file of SoapUI. SoapUI just happens to use XML as its project/document format. Equivalently, Microsoft Word uses DOCX (binary, not text) for its project/document format.

This SoapUI project-file contains two distinct things:
- A client for the Web Service, generated from the `Library.wsdl` file.
    - We have generated one ourselves in the previous codelab.
- A **Mock Service**, generated from the `Library.wsdl` file.
    - This is a fake SOAP Web Service (Server)
        - It can be started and will run locally on port 8088, mapped to `LibraryPB` (http://localhost:8088/LibraryPB)
    - When running, it is programmed to give correct SOAP-responses (containing the right XML elements) to SOAP-responses (from the client).
        - The data in the SOAP-response is hard-coded, it will always be the same returned data per operation.
        
Let's start using this SoapUI project file!

1. Open SoapUI
2. In the upper menu bar, go to `File > Import project`. Or, simply press `ctrl`+`i`.
3. In the popup that appeared, navigate to and select the `LibrarySOAPWebService-soapui-project.xml` file.
4. After pressing `Open`, you should see appear the `LibrarySOAPWebService` project in the Navigator pane on the left.
5. Click on the `+` icon to expand it.
6. You should now see:
    - `LibraryPB`, which is the generate client
    - `LibraryPB Mock (Fake) Web Service Server`, which is the mock service (sometimes useful for testing)
7. Explore both. See how both Client and Mock service (Server) have all the existing operations available.
    - For the Mock service, each operation has one hard-coded request available.
    - For the Client, each operation has one valid request available.
    
### Using the Mock Service

Go to the client (`LibraryPB`) and open the `CountAllBooks` operation. Double-click its `Request 1` element and 
perform a new request (green triangle 'play' icon).
- This should not work, as you're contacting the following endpoint url: **http://localhost:8088/LibraryPB**. 
    - Whenever you see localhost, it means that your own computer is expected to act as the server, and that it should run the process of the SOAP Web Service application **locally** on port 8088, mapped on path `LibraryPB`.

So, the first step is to start the Mock Service.
1. In the Navigator, go to `LibraryPB Mock (Fake) Web Service Server` and double-click its name.
2. A window should open, listing the different operations. To start this Mock service, click the green 'play' icon.
3. As long as you don't press the red 'stop' button, the Web Service will be available on port 8088.
    - The port (8088) and path (`LibraryPB`) are defined in the Port element of the WSDL.
    - (Don't press the stop button...)
    
Now, we can use the client to perform requests to the Mock service.

Again, go to the client (`LibraryPB`) and open the `CountAllBooks` operation. 
Double-click its `Request 1` element and perform a new request (green triangle 'play' icon).
- This time, you should get a (hard-coded) response.

For every operation, make a request. If you're not sure what (type of) data should be provided in the request, 
take an extra look at the **XML Schema** section of the `Library.wsdl` file.
- Don't forget however that the Mock service gives hard-coded responses. If you search books based on a author-name (provided in the request), you won't get a different response for a different author-name from this Mock service.
    - If you provide invalid requests, the Mock service will give a different response. Try it.
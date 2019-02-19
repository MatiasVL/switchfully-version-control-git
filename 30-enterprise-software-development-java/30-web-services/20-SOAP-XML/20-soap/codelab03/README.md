# Countries WSDL

In Codelab01 and 02 you have been creating your own SOAP-requests for the Countries SOAP Web Service. In order for you to do so, 
we had to provide you with a lot of information:
1. The Endpoint URL (https://switchfully-countries-soap.herokuapp.com/ws)
2. The possible operations (get all countries, search a country) with the required XML elements (`getAllCountriesRequest` and `getCountryRequest`)
3. The XML Schema (XSD) so you could validate whether or not your constructed XML elements were valid.
4. The version of the SOAP Message (1.2, which requires HTTP Header `Content-Type: application/soap+xml`)
5. The default namespace used by the web service (https://switchfully.com/ws/soap-web-service)
6. Etc...

Without this information, you would not have been able to perform a single request to our SOAP Web Service. 

Furthermore, maybe the SOAP Web Service allows for much more different operations (e.g. Create a country, Delete a country, Update a country, Get countries per continent,...) without you even knowing. 
The truth is that you can't really know that at this moment...

Luckily, there's a WSDL file available that describes the entire SOAP Web Service **and** can be used by SoapUI to automatically create a client out of it.

## WSDL

You can find the WSDL of the Web Service on [https://switchfully-countries-soap.herokuapp.com/ws/countries.wsdl](https://switchfully-countries-soap.herokuapp.com/ws/countries.wsdl)
- Once loaded, you can download it by right-clicking on the content and selecting 'save as' (or press `ctrl`+`s`)
- Save the WSDL as `countries.wsdl`, you'll need it in a few minutes.

Now, study the WSDL. Keep the slides (Chapter 4: WSDL, sub chapter: WSDL document) close.
1. Explore the service part of the WSDL; what is the name of the service?
    - Do you see how it defines the Port?
    - Do you see how the Port has a binding?   
2. Explore the binding part of the WSDL;
    - Do you see how it uses soap12? (SOAP V1.2)
    - Do you see how it has a PortType?
3. Explore the PortType part of the WSDL; what operation(s) are available?
    - Do you see how the operator's input and output reference a message?
4. Explore the message part of the WSDL
    - See how the parts reference an XML element?
5. Explore the types part of the WSDL
    - See how it contains an XML Schema (XSD)?
    
## Creating a client with the WSDL file

Let's use SoapUI to create a client from the WSDL file.

1. Open SoapUI
2. In the navigator (left-side of screen), right-click on `Projects`.
3. In the appeared dropdown menu, click on `New SOAP Project` (Or, press `ctrl`+`n`).
4. A popup should appear:
    - Project name: `CountriesSoapWebService`
    - Initial WSDL: Browse to, and select the downloaded `countries.wsdl` file
    - Create Requests: Check
    - Create Testsuite: Uncheck
    - Relative paths: Uncheck
5. Click on button **OK** to create the SOAP Project
6. In the navigator (left-side of screen), you'll see your new SOAP Project (the client for our SOAP Web Service). In it, you should see an element with the name of the WSDL Binding (`CountriesPortSoap12`).
7. Click on the `+` symbol of binding `CountriesPortSoap12` to open it up. You should now see the two operations that are defined in the WSDL (`getAllCountries` and `getCountry`)
8. Click on the `+` symbol of operation `getAllCountries`, you should see a valid, sample request (`Request 1`).
9. Double-click on `Request 1`, it will open up the request window.
10. In the request window, you'll see:
    - The Endpoint URL (https://switchfully-countries-soap.herokuapp.com:443/ws)
    - The SOAP Message
11. Finally, press the green **Play** button to perform the request, you should get a response from the SOAP Web Service.

Experiment with it. Try the `getCountry` operation as well. 
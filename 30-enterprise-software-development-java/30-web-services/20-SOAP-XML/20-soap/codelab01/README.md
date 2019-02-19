# Countries SOAP Web Service

We have created a SOAP Web Service that's running on a remote server (which is located somewhere in Europe...).

For this codelab, we'll see how to call that SOAP Web Service 'manually' by creating SOAP-requests over HTTP(S). 
- In later codelabs, we'll use the WSDL file to let a tool such as SoapUI generate us a client (which automatically performs the SOAP-requests over HTTP(S) for us whenever we click the 'perform request' button).

## Information about the Web Service

Our SOAP web service has an endpoint available which allows us to request all the countries that are stored in the database.

In the request, we need to provide a specific XML document (root element = `getAllCountriesRequest`) as part of the SOAP Body. 
As the response, we'll get back a specific XML document (root element = `getAllCountriesResponse`) as well (again, as part of the SOAP Body).

An XML Schema (XSD) was created to define both these XML documents (`getAllCountriesRequest` and `getAllCountriesResponse`):

```XML
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" 
           xmlns:tns="https://switchfully.com/ws/soap-web-service"
           targetNamespace="https://switchfully.com/ws/soap-web-service" 
           elementFormDefault="qualified">

    <xs:element name="getAllCountriesRequest">
        <xs:complexType>
            <xs:sequence>
                <!-- Empty type -->
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="getAllCountriesResponse">
        <xs:complexType>
            <xs:sequence maxOccurs="unbounded">
                <xs:element name="country" type="tns:country"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:complexType name="country">
        <xs:sequence>
            <xs:element name="name" type="xs:string"/>
            <xs:element name="population" type="xs:int"/>
            <xs:element name="capital" type="xs:string"/>
            <xs:element name="currency" type="tns:currency"/>
        </xs:sequence>
    </xs:complexType>

    <xs:simpleType name="currency">
        <xs:restriction base="xs:string">
            <xs:enumeration value="GBP"/>
            <xs:enumeration value="EUR"/>
            <xs:enumeration value="PLN"/>
        </xs:restriction>
    </xs:simpleType>
</xs:schema>
``` 

Using this XML Schema, we can validate whether or not the XML document we're creating for the request is valid XML.
This is (for example) a valid `getAllCountriesRequest` instance.
```XML
<getAllCountriesRequest/>
```

## Make a request to the SOAP Web Service

We're going to make a request to the SOAP Web Service to get all the countries (it's something the web service offers us).

To do so, we need a few **prerequisites**:
1. A tool such as Postman or SoapUI (you'll need SoapUI later on, but for now Postman will do) for performing a POST HTTP request.
    - Postman you already used during the REST fundamentals submodule.
    - SoapUI is an open-source web service testing application. Its functionality covers web service inspection, invoking, development, simulation and mocking, functional testing, load and compliance testing.
2. The correct SOAP Message: consisting of a SOAP Envelope and SOAP Body element.
3. The proper XML element for the request we're going to make (`getAllCountriesRequest`) nested inside of the SOAP Body.
4. The URL on which the SOAP Web Service is mapped and available.
    - This will be [https://switchfully-countries-soap.herokuapp.com/ws](https://switchfully-countries-soap.herokuapp.com/ws)
    
### SOAP-Request
If you're using Postman, create a new **Request**. If you're using SoapUI, click the blue **Endpoint Explorer** button.
1. as the HTTP Method, use **POST**. Our SOAP Web Service requires this (it's implemented to expect POST)
2. Add the following HTTP Header: `Content-Type: application/soap+xml`. Since our SOAP Web Service is implemented with SOAP 1.2 it expects the 'application/soap+xml' media type. 
The HTTP Body should therefore also contain a SOAP 1.2 Message (not a 1.1 version).
3. As the body, provide the following SOAP Message:
    ```XML
    <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope"
                   xmlns="https://switchfully.com/ws/soap-web-service">
        <soap:Header/>
        <soap:Body>
            <getAllCountriesRequest/>
        </soap:Body>
    </soap:Envelope>
    ```
4. Last but not least, fill in `https://switchfully-countries-soap.herokuapp.com/ws` as the Endpoint / Request Url.

That's all. You have manually configured a SOAP-request. Now, simply perform the request by pressing the **Send** button.
You should receive a SOAP-response back. 

## SOAP-Response

In the SOAP-Response you got back, you'll find the `getAllCountriesRequest` XML document containing 3 `country` elements.
```XML
<env:Envelope xmlns:env="http://www.w3.org/2003/05/soap-envelope">
    <env:Header/>
    <env:Body>
        <ns2:getAllCountriesResponse xmlns:ns2="https://switchfully.com/ws/soap-web-service">
            <ns2:country>
                <ns2:name>Poland</ns2:name>
                <ns2:population>38186860</ns2:population>
                <ns2:capital>Warsaw</ns2:capital>
                <ns2:currency>PLN</ns2:currency>
            </ns2:country>
            <ns2:country>
                <ns2:name>United Kingdom</ns2:name>
                <ns2:population>63705000</ns2:population>
                <ns2:capital>London</ns2:capital>
                <ns2:currency>GBP</ns2:currency>
            </ns2:country>
            <ns2:country>
                <ns2:name>Spain</ns2:name>
                <ns2:population>46704314</ns2:population>
                <ns2:capital>Madrid</ns2:capital>
                <ns2:currency>EUR</ns2:currency>
            </ns2:country>
        </ns2:getAllCountriesResponse>
    </env:Body>
</env:Envelope>
```

If a web-application would make this request and then receive this response, it would un-marshall (XML to Objects) the XML in the response 
and then properly display it (maybe in a nicely styled table or in a grid).
 
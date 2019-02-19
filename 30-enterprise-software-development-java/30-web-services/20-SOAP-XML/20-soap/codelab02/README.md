# Countries SOAP Web Service (part 2)

We're going to continue using the SOAP Web Service from Codelab01. It can do more than just the one operation we performed on it.

Besides being able to get all the countries, we can also use the SOAP Web Service to search for a specific country by providing its name.

## XML Schema

The complete XML Schema used by the SOAP Web Service actually looks like this:

```XML
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" 
           xmlns:tns="https://switchfully.com/ws/soap-web-service"
           targetNamespace="https://switchfully.com/ws/soap-web-service" 
           elementFormDefault="qualified">

    <xs:element name="getCountryRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="name" type="xs:string"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="getCountryResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="country" type="tns:country"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

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

Compared to the XSD from the previous codelab, this one contains two additional elements: 
`getCountryRequest` and `getCountryResponse`. These two XML elements are required to perform the search operation and get a response.

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
          <getCountryRequest>
             <name>Poland</name>
          </getCountryRequest>
       </soap:Body>
    </soap:Envelope>
    ```
4. Last but not least, fill in `https://switchfully-countries-soap.herokuapp.com/ws` as the Endpoint / Request Url.

That's all. You have manually configured the SOAP-request to search for a country. Now, simply perform the request by pressing the **Send** button.
You should receive a SOAP-response back. 

In the SOAP-Response you got back, you'll find the `getCountryResponse` XML document containing the `country` element holding Poland's data.
```XML
<env:Envelope xmlns:env="http://www.w3.org/2003/05/soap-envelope">
    <env:Header/>
    <env:Body>
        <ns2:getCountryResponse xmlns:ns2="https://switchfully.com/ws/soap-web-service">
            <ns2:country>
                <ns2:name>Poland</ns2:name>
                <ns2:population>38186860</ns2:population>
                <ns2:capital>Warsaw</ns2:capital>
                <ns2:currency>PLN</ns2:currency>
            </ns2:country>
        </ns2:getCountryResponse>
    </env:Body>
</env:Envelope>
```

**A small remark:** It's good practice for a (SOAP) Web Service, to be as **forgiving** as possbile towards the client. Take this into account when creating or testing a web service.
- For example, if the request was made with `<name>poland</name` instead of `<name>Poland</name>` (mind the capitalized P), the web service should return a response containing Poland's data. However, currently, our web service will return an empty `country` element for this scenario, as it is case sensitive. Behavior like this is often not desired and too strict.
    - Try performing the request with value `poland` instead of `Poland`, you'll see for yourself.
    
## Bad SOAP-Request

According to the XSD, the XML element `getCountryRequest` must contain a `name` element (minOccurs has value 1 as its default value). 
It's not allowed to simply leave it out of the `getCountryRequest`. However, that's exactly what we're going to do now.

Repeat all the steps from the previous subchapter **SOAP-Request**, but as the HTTP body, provide the following SOAP Message:
```XML
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" 
	xmlns="https://switchfully.com/ws/soap-web-service">
   <soap:Header/>
   <soap:Body>
      <getCountryRequest>
         <!-- We're leaving out the name element... -->
      </getCountryRequest>
   </soap:Body>
</soap:Envelope>
```

Now, perform the request by pressing the **Send** button. You should receive a SOAP-response back, but a different one than before though.

## SOAP Fault element

The SOAP-response we get back contains a Fault element.

```XML
<env:Envelope xmlns:env="http://www.w3.org/2003/05/soap-envelope">
    <env:Header/>
    <env:Body>
        <env:Fault>
            <env:Code>
                <env:Value>env:Receiver</env:Value>
            </env:Code>
            <env:Reason>
                <env:Text xml:lang="en">The country's name must not be null</env:Text>
            </env:Reason>
        </env:Fault>
    </env:Body>
</env:Envelope>
```

The SOAP Web Service nicely constructed this Fault element to inform us, the client, of what went wrong. By reading the `Reason` element it should be clear for everyone what was/went wrong.
- Small remark: The Fault Code should have been **Client** instead of **Receiver**, as the fault was a mistake made by the client (us) and can be correct by the client.

## Additional requests
1. Make a request using `Spain` as the value for element `name`.
2. Make a request using `Belgium` as the value for element `name` (this country is not known to the web service > database). 
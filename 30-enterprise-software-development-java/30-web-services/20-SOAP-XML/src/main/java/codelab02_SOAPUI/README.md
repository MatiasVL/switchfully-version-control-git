# WSDL &amp; SOAP

- explore the Statistics public WSDL (browser)

http://www.webservicex.net/Statistics.asmx?wsdl

    1. explore the service part of the WSDL; what is the name of the service?
    2. explore the portType part of the WSDL; what operation(s) are available?
    3. explore the message part of the WSDL; which elements are defined in the input message?
    4. explore the message part of the WSDL; which elements are defined in the output message?
    5. explore the types part of the WSDL; what is the type of the elements defined in the input message?
    6. explore the types part of the WSDL; what is the type of the elements defined in the output message?


- Explore the Statistics public WSDL (SOAPUI)

Download and install SOAPUI

SoapUI is an open-source web service testing application for service-oriented architectures (SOA) and representational state transfers (REST). Its functionality covers web service inspection, invoking, development, simulation and mocking, functional testing, load and compliance testing.

We will use SOAPUI to explore and consume public available webservices.

    1. Create a new SOAP project
    2. Add the statistics WSDL to the project (http://www.webservicex.net/Statistics.asmx?wsdl)
    3. Explore the properties of the StatisticsSoap service (ignore StatisticsSoap12)
    4. Explore the properties of the GetStatistics Operation
    5. Explore the default request for this operation
    6. adjust the request message to get the statistics of array of 5 and 10
    7. explore the response message of the statistics of array of 5 and 10

    8. adjust the request message to get the statistics of array of 5 and "ten"
    9. explore the response message of the statistics of array of 5 and "ten"

    10. add a new correctly closed element "<newelement>-1</newelement>" somewhere in the body of the request message
    11. explore the response message of the adjusted message. which property of XMl and webservices did we just test?

 
- Explore the periodictable WSDL (SOAPUI)
    
http://www.webservicex.net/periodictable.asmx?WSDL

    1. Retrieve a list of all available atoms
    2. Retrieve the details of the atom Silver
    3. Retrieve the atomic weight of element with symbol Kr
     
- Explore the calculator WSDL (SOAPUI)

http://www.dneonline.com/calculator.asmx?WSDL

    1. Calculate the sum of 5 and 143
    2. Calculate the sum of 5 and 143.2    
    
- Explore the WSDemoService WSDL (SOAPUI)

_02_programming_advanced/_10_webservices/_03_xml_SOAP/_03_wsdl/hello.wsdl

    1. Create a new SOAP project
    2. Add the complete path of the following WSDL file in SOAPUI
    3. Explore the helloWorld operation and it's input
    4. Adjust the WSDL file to add a new operation "helloWorldExtended" 

    

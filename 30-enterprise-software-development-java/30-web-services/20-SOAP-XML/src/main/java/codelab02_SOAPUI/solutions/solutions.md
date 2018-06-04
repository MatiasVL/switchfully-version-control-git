# WSDL &amp; SOAP Solutions

- explore the Statistics public WSDL (browser)

http://www.webservicex.net/Statistics.asmx?wsdl

1. explore the service part of the WSDL; what is the name of the service? 
```
<wsdl:service name="Statistics">
```    
2. explore the portType part of the WSDL; what operation(s) are available?
```
<wsdl:operation name="GetStatistics">
```
3. explore the message part of the WSDL; which elements are defined in the input message?
```
<wsdl:message name="GetStatisticsSoapIn">
<wsdl:part name="parameters" element="tns:GetStatistics"/>
</wsdl:message>
```
4. explore the message part of the WSDL; which elements are defined in the output message?
```
<wsdl:message name="GetStatisticsSoapOut">
<wsdl:part name="parameters" element="tns:GetStatisticsResponse"/>
</wsdl:message>
```
5. explore the types part of the WSDL; what is the type of the elements defined in the input message?
```
<s:element name="GetStatistics">
<s:complexType>
<s:sequence>
<s:element minOccurs="0" maxOccurs="1" name="X" type="tns:ArrayOfDouble"/>
</s:sequence>
</s:complexType>
</s:element>
```
```
<s:complexType name="ArrayOfDouble">
<s:sequence>
<s:element minOccurs="0" maxOccurs="unbounded" name="double" type="s:double"/>
</s:sequence>
</s:complexType>
```
6. explore the types part of the WSDL; what is the type of the elements defined in the output message?
```
<s:element name="GetStatisticsResponse">
<s:complexType>
<s:sequence>
<s:element minOccurs="1" maxOccurs="1" name="Sums" type="s:double"/>
<s:element minOccurs="1" maxOccurs="1" name="Average" type="s:double"/>
<s:element minOccurs="1" maxOccurs="1" name="StandardDeviation" type="s:double"/>
<s:element minOccurs="1" maxOccurs="1" name="skewness" type="s:double"/>
<s:element minOccurs="1" maxOccurs="1" name="Kurtosis" type="s:double"/>
</s:sequence>
</s:complexType>
</s:element>
```

- Explore the Statistics public WSDL (SOAPUI)

Download and install SOAPUI

SoapUI is an open-source web service testing application for service-oriented architectures (SOA) and representational state transfers (REST). Its functionality covers web service inspection, invoking, development, simulation and mocking, functional testing, load and compliance testing.

We will use SOAPUI to explore and consume public available webservices.

1. Create a new SOAP project
```
File >> new Soap Project
```
2. Add the statistics WSDL to the project (http://www.webservicex.net/Statistics.asmx?wsdl)
```
Project >> Add WSDL
```
3. Explore the properties of the StatisticsSoap service (ignore StatisticsSoap12)
```
right click StatisticsSoap >> show interface viewer
```
4. Explore the properties of the GetStatistics Operation
```
click GetStatistics >> Operation properties panel
```
5. Explore the default request for this operation
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://www.webserviceX.NET">
   <soapenv:Header/>
   <soapenv:Body>
      <web:GetStatistics>
         <!--Optional:-->
         <web:X>
            <!--Zero or more repetitions:-->
            <web:double>?</web:double>
         </web:X>
      </web:GetStatistics>
   </soapenv:Body>
</soapenv:Envelope>
```
6. adjust the request message to get the statistics of array of 5 and 10
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://www.webserviceX.NET">
   <soapenv:Header/> 
   <soapenv:Body>
      <web:GetStatistics>
         <web:X>
            <web:double>5</web:double>
             <web:double>10</web:double>
         </web:X>
      </web:GetStatistics>
   </soapenv:Body>
</soapenv:Envelope>
```
7. explore the response message of the statistics of array of 5 and 10
```
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
   <soap:Body>
      <GetStatisticsResponse xmlns="http://www.webserviceX.NET">
         <Sums>15</Sums>
         <Average>7.5</Average>
         <StandardDeviation>2.5</StandardDeviation>
         <skewness>0.5</skewness>
         <Kurtosis>-2.5</Kurtosis>
      </GetStatisticsResponse>
   </soap:Body>
</soap:Envelope>
```
8. adjust the request message to get the statistics of array of 5 and "ten"
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://www.webserviceX.NET">
   <soapenv:Header/>
 
   <soapenv:Body>
      <web:GetStatistics>
         <web:X>
            <web:double>5</web:double>
             <web:double>ten</web:double>
         </web:X>
      </web:GetStatistics>
   </soapenv:Body>
</soapenv:Envelope>
```
9. explore the response message of the statistics of array of 5 and "ten"
```
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
   <soap:Body>
      <soap:Fault>
         <faultcode>soap:Client</faultcode>
         <faultstring>System.Web.Services.Protocols.SoapException: Server was unable to read request. ---> System.InvalidOperationException: There is an error in XML document (8, 42). ---> System.FormatException: Input string was not in a correct format.
   at System.Number.ParseDouble(String value, NumberStyles options, NumberFormatInfo numfmt)
   at System.Xml.XmlConvert.ToDouble(String s)
   at Microsoft.Xml.Serialization.GeneratedAssembly.XmlSerializationReader1.Read1_GetStatistics()
   at Microsoft.Xml.Serialization.GeneratedAssembly.ArrayOfObjectSerializer.Deserialize(XmlSerializationReader reader)
   at System.Xml.Serialization.XmlSerializer.Deserialize(XmlReader xmlReader, String encodingStyle, XmlDeserializationEvents events)
   --- End of inner exception stack trace ---
   at System.Xml.Serialization.XmlSerializer.Deserialize(XmlReader xmlReader, String encodingStyle, XmlDeserializationEvents events)
   at System.Web.Services.Protocols.SoapServerProtocol.ReadParameters()
   --- End of inner exception stack trace ---
   at System.Web.Services.Protocols.SoapServerProtocol.ReadParameters()
   at System.Web.Services.Protocols.WebServiceHandler.CoreProcessRequest()</faultstring>
         <detail/>
      </soap:Fault>
   </soap:Body>
</soap:Envelope>
```
10. add a new correctly closed element "<newelement>-1</newelement>" somewhere in the body of the request message
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://www.webserviceX.NET">
   <soapenv:Header/> 
   <soapenv:Body>
      <web:GetStatistics>
         <web:X>
            <web:double>5</web:double>
             <web:double>10</web:double>
         </web:X>
         <newelement>-1</newelement>
      </web:GetStatistics>
   </soapenv:Body>
</soapenv:Envelope>
```
11. explore the response message of the adjusted message. which property of XMl and webservices did we just test?
```
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
   <soap:Body>
      <GetStatisticsResponse xmlns="http://www.webserviceX.NET">
         <Sums>15</Sums>
         <Average>7.5</Average>
         <StandardDeviation>2.5</StandardDeviation>
         <skewness>0.5</skewness>
         <Kurtosis>-2.5</Kurtosis>
      </GetStatisticsResponse>
   </soap:Body>
</soap:Envelope>
```
*Extensibility*
 
- Explore the periodictable WSDL (SOAPUI)
    
http://www.webservicex.net/periodictable.asmx?WSDL

1. Retrieve a list of all available atoms
```
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:web="http://www.webserviceX.NET">
   <soap:Header/>
   <soap:Body>
      <web:GetAtoms/>
   </soap:Body>
</soap:Envelope>
```
2. Retrieve the details of the atom Silver
```
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:web="http://www.webserviceX.NET">
   <soap:Header/>
   <soap:Body>
      <web:GetAtomicNumber>
         <!--Optional:-->
         <web:ElementName>Silver</web:ElementName>
      </web:GetAtomicNumber>
   </soap:Body>
</soap:Envelope>
```
3. Retrieve the atomic weight of element with symbol Kr

*we are missing an operation to retrieve element name based on the ElementSymbol*
```
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:web="http://www.webserviceX.NET">
   <soap:Header/>
   <soap:Body>
      <web:GetAtomicWeight>
         <!--Optional:-->
         <web:ElementName>Krypton</web:ElementName>
      </web:GetAtomicWeight>
   </soap:Body>
</soap:Envelope>
```
     
- Explore the calculator WSDL (SOAPUI)

http://www.dneonline.com/calculator.asmx?WSDL

1. Calculate the sum of 5 and 143
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tem="http://tempuri.org/">
   <soapenv:Header/>
   <soapenv:Body>
      <tem:Add>
         <tem:intA>5</tem:intA>
         <tem:intB>143</tem:intB>
      </tem:Add>
   </soapenv:Body>
</soapenv:Envelope>

<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
   <soap:Body>
      <AddResponse xmlns="http://tempuri.org/">
         <AddResult>148</AddResult>
      </AddResponse>
   </soap:Body>
</soap:Envelope>
```
2. Calculate the sum of 5 and 143.2    
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tem="http://tempuri.org/">
   <soapenv:Header/>
   <soapenv:Body>
      <tem:Add>
         <tem:intA>5</tem:intA>
         <tem:intB>143.2</tem:intB>
      </tem:Add>
   </soapenv:Body>
</soapenv:Envelope>

<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
   <soap:Body>
      <soap:Fault>
         <faultcode>soap:Client</faultcode>
         <faultstring>System.Web.Services.Protocols.SoapException: Server was unable to read request. ---> System.InvalidOperationException: There is an error in XML document (6, 36). ---> System.FormatException: Input string was not in a correct format.
   at System.Number.StringToNumber(String str, NumberStyles options, NumberBuffer&amp; number, NumberFormatInfo info, Boolean parseDecimal)
   at System.Number.ParseInt32(String s, NumberStyles style, NumberFormatInfo info)
   at System.Xml.XmlConvert.ToInt32(String s)
   at Microsoft.Xml.Serialization.GeneratedAssembly.XmlSerializationReader1.Read1_Add()
   at Microsoft.Xml.Serialization.GeneratedAssembly.ArrayOfObjectSerializer.Deserialize(XmlSerializationReader reader)
   at System.Xml.Serialization.XmlSerializer.Deserialize(XmlReader xmlReader, String encodingStyle, XmlDeserializationEvents events)
   --- End of inner exception stack trace ---
   at System.Xml.Serialization.XmlSerializer.Deserialize(XmlReader xmlReader, String encodingStyle, XmlDeserializationEvents events)
   at System.Xml.Serialization.XmlSerializer.Deserialize(XmlReader xmlReader, String encodingStyle)
   at System.Web.Services.Protocols.SoapServerProtocol.ReadParameters()
   --- End of inner exception stack trace ---
   at System.Web.Services.Protocols.SoapServerProtocol.ReadParameters()
   at System.Web.Services.Protocols.WebServiceHandler.CoreProcessRequest()</faultstring>
         <detail/>
      </soap:Fault>
   </soap:Body>
</soap:Envelope>
```    
- Explore the WSDemoService WSDL (SOAPUI)

_02_programming_advanced/_10_webservices/_03_xml_SOAP/_03_wsdl/hello.wsdl

1. Create a new SOAP project
2. Add the complete path of the following WSDL file in SOAPUI
3. Explore the helloWorld operation and it's input

*remark this is only the WSDL file, there is no implementation for this webservice*

4. Adjust the WSDL file to add a new operation "helloWorldExtended", which requires firstName and lastName as input

```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Header/>
   <soapenv:Body>
      <helloWorldExtended>
         <firstName>?</firstName>
         <lastName>?</lastName>
      </helloWorldExtended>
   </soapenv:Body>
</soapenv:Envelope>
```

--> _02_programming_advanced/_10_webservices/_03_xml_SOAP/codelab02_SOAPUI/solutions/hello_extended.wsdl




    

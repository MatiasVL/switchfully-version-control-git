**Remote Calculations**

The goal of this exercice is to create a data structure of the Kurtosis of every possiblie combination of two numbers between 1 and 5. At the end of the processing, this structure has to be displayed on screen.

Kurtosis is a well know mathematical concept. As we don't want to learn what it is and implement it, we are going to use a remote WebService to calculate this for us. You can find in SOAPClientSAAJ a method that will build a SOAP request and send it to a server. This server will then answer us with an XML.

Your job here is for every combinations of number between 1 and 5 :
* Make a call to the WebService using the given SOAPClient
* Decode the response to retrieve the Kurtosis
* Create an object containning the input and the Kurtosis
* Store this object in a data structure

And then display the list at once!
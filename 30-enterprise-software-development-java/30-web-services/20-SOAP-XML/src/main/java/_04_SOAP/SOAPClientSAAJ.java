package _04_SOAP;

import javax.xml.soap.*;

public class SOAPClientSAAJ {

    private static String SOAP_END_POINT_URL = "http://www.webservicex.net/Statistics.asmx";
    private static String SOAP_ACTION = "http://www.webserviceX.NET/GetStatistics";
    private static String NAME_SPACE = "web";
    private static String NAME_SPACE_URI = "http://www.webserviceX.NET";

    public static SOAPMessage retrievesNumberCalculationByWebService(String firstNumber, String secondNumber) throws SOAPException {
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(SOAP_ACTION, firstNumber, secondNumber), SOAP_END_POINT_URL);
        soapConnection.close();

        return soapResponse;
    }

    private static SOAPMessage createSOAPRequest(String soapAction, String firstNumber, String secondNumber) throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        createSoapEnvelope(soapMessage, firstNumber, secondNumber);

        soapMessage
                .getMimeHeaders()
                .addHeader("SOAPAction", soapAction);
        soapMessage.saveChanges();
        return soapMessage;
    }

    private static void createSoapEnvelope(SOAPMessage soapMessage, String firstNumber, String secondNumber) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(NAME_SPACE, NAME_SPACE_URI);

        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("GetStatistics",NAME_SPACE);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("X", NAME_SPACE);

        SOAPElement soapBodyElem2 = soapBodyElem1.addChildElement("double", NAME_SPACE);
        soapBodyElem2.addTextNode(firstNumber);

        SOAPElement soapBodyElem3 = soapBodyElem1.addChildElement("double", NAME_SPACE);
        soapBodyElem3.addTextNode(secondNumber);
    }

}
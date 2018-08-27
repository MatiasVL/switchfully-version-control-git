package _04_SOAP;


import org.junit.jupiter.api.Test;

import javax.xml.soap.SOAPException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class SOAPClientSAAJIntegrationTest {

    private static final String ONE_AND_TWO_RESULT = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><GetStatisticsResponse xmlns=\"http://www.webserviceX.NET\"><Sums>3</Sums><Average>1.5</Average><StandardDeviation>0.5</StandardDeviation><skewness>0.5</skewness><Kurtosis>-2.5</Kurtosis></GetStatisticsResponse></soap:Body></soap:Envelope>";
    private static final String MICKEY_AND_DONALD_ERROR = "System.InvalidOperationException: There is an error in XML document";

    @Test
    public void retrievesNumberCalculationByWebService_with1And2_Gives3AndOthers() throws SOAPException, IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        SOAPClientSAAJ.retrievesNumberCalculationByWebService("1", "2").writeTo(outputStream);
        outputStream.flush();
        org.assertj.core.api.Assertions.assertThat(ONE_AND_TWO_RESULT).isEqualTo( outputStream.toString());
    }

    @Test
    public void retrievesNumberCalculationByWebService_withMickeyAndDonald_GivesError() throws SOAPException, IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        SOAPClientSAAJ.retrievesNumberCalculationByWebService("Mickey", "Donald").writeTo(outputStream);
        outputStream.flush();
        org.assertj.core.api.Assertions.assertThat(outputStream.toString()).contains(MICKEY_AND_DONALD_ERROR);
    }

}
package _01_parsing;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class XMLParsing {
    public static void main(String[] args) throws Exception {
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader("<company><id>1</id><name>Hotel coorporation UK</name></company>"));

        Document doc = (Document) db.parse(is);

        System.out.print("Company with id ");
        System.out.print(doc.getFirstChild().getFirstChild().getTextContent());

        System.out.print(" is named ");
        System.out.print(doc.getFirstChild().getLastChild().getTextContent());
    }
}


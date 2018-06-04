package _02_marshalling;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class JavaToXML {
    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Company.class);

        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "codelab03_marshalling/Company.xsd");

        Company object = new Company();
        object.setId(2);
        object.setName("The second company");

        m.marshal(object, System.out);

    }
}
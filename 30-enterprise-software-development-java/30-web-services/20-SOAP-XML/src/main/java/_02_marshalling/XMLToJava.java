package _02_marshalling;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLToJava {

    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Company.class);
            Unmarshaller u = jc.createUnmarshaller();

            File f = new File("C:\\Users\\reinouvb\\IdeaProjects\\switchfully-codelabs\\02-programming-advanced\\09-webservices\\02-soap-xml\\src\\main\\java\\_02_marshalling\\Company.xml");
            Company Company = (Company) u.unmarshal(f);

            System.out.println(Company.getId());
            System.out.println(Company.getName());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}


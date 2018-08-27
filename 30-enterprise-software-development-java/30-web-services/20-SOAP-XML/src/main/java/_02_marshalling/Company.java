package _02_marshalling;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Company {
    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

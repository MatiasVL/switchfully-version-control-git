package solid.codelab01_single_responsiblity_principle;

public class Car
{
    private final String id;
    private final String model;
    private final String brand;

    public Car(String id, String model, String brand)
    {
        this.id = id;
        this.model = model;
        this.brand = brand;
    }

    public String getId()
    {
        return this.id;
    }

    public String getModel()
    {
        return this.model;
    }

    public String getBrand()
    {
        return this.brand;
    }
}

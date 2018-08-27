package nested_classes.code_example08_static_nested_enum.v2_nested;

public class Wheel {

    private String brand;
    private Type type;

    public Wheel(String brand, Type type) {
        this.brand = brand;
        this.type = type;
    }

    public enum Type {

        HEAVY_TERRAIN,
        SUMMER,
        WINTER

    }

}

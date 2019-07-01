package code_example01_static_nested_class;

public enum Breed {

    BENGAL("Bengal"),
    MANX("Manx"),
    PERSIAN("Persian");

    private String label;

    Breed(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

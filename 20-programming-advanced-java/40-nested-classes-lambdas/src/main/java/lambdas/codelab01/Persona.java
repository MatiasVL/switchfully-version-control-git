package lambdas.codelab01;

/**
 * Read the README.md
 */
public class Persona {

    private String name;
    private int age;

    Persona(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        return age == persona.age && (name != null ? name.equals(persona.name) : persona.name == null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}

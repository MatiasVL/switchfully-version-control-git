package lambdas.code_example01_lambdas.lamba_sorting;

public class Horse {

    private final String name;
    private final int age;
    private final float speedKmh;

    public Horse(String name, int age, float speedKmh) {
        this.name = name;
        this.age = age;
        this.speedKmh = speedKmh;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getSpeedKmh() {
        return speedKmh;
    }

    @Override
    public String toString() {
        return getName() + "\t (age " + getAge() + ")\t" + getSpeedKmh() + " Kmh.";
    }
}

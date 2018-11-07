package solid.solution_codelab02_open_closed_principle.shapes;

public class Circle implements GeometryShape {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateShapeCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateShapeArea() {
        return Math.PI * radius * radius;
    }

}

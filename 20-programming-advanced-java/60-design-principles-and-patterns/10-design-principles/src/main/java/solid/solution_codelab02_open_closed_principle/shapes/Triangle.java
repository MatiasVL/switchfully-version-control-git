package solid.solution_codelab02_open_closed_principle.shapes;

public class Triangle implements GeometryShape {

    private final double baseSide, sideLeft, sideRight;
    private final double height;

    public Triangle(double baseSide, double sideLeft, double sideRight, double height) {
        this.baseSide = baseSide;
        this.sideLeft = sideLeft;
        this.sideRight = sideRight;
        this.height = height;
    }

    @Override
    public double calculateShapeCircumference() {
        return baseSide + sideLeft + sideRight;
    }

    @Override
    public double calculateShapeArea() {
        return baseSide * height / 2;
    }

}

package solid.solution_codelab02_open_closed_principle.shapes;

public class Rectangle implements GeometryShape {

    private final double height, width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculateShapeCircumference() {
        return 2 * (height + width);
    }

    @Override
    public double calculateShapeArea() {
        return height * width;
    }

}

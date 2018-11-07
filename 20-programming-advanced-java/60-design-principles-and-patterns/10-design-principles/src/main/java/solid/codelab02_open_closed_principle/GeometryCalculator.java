package solid.codelab02_open_closed_principle;

/**
 * This class definitely breaks the open/closed principle. For every new ShapeType, we will have to modify both
 * switch statements of this class. Other classes making use of ShapeType, will probably contain similar switch statements.
 * Furthermore, the arguments required to call both public methods are very unreadable.
 */
public class GeometryCalculator {
    
    public double calculateCircumference(ShapeType shapeType, double value1, double value2, double value3) {
        switch (shapeType) {
            case RECTANGLE:
                return circumferenceRectangle(value1, value2);
            case CIRCLE:
                return circumferenceCircle(value1);
            case TRIANGLE:
                return circumferenceTriangle(value1, value2, value3);
            default:
                return -1;
        }
    }

    public double calculateArea(ShapeType shapeType, double value1, double value2) {
        switch (shapeType) {
            case RECTANGLE:
                return areaRectangle(value1, value2);
            case CIRCLE:
                return areaCircle(value1);
            case TRIANGLE:
                return areaTriangle(value1, value2);
            default:
                return -1;
        }
    }


    private double circumferenceCircle(double radius) {
        return 2 * Math.PI * radius;
    }

    private double areaCircle(double radius) {
        return Math.PI * radius * radius;
    }
    private double circumferenceTriangle(double sideA, double sideB, double sideC) {
        return sideA + sideB + sideC;
    }

    private double areaTriangle(double base, double height) {
        return base * height / 2;
    }

    private double circumferenceRectangle(double height, double width) {
        return 2 * (height + width);
    }

    private double areaRectangle(double height, double width) {
        return height * width;
    }

}

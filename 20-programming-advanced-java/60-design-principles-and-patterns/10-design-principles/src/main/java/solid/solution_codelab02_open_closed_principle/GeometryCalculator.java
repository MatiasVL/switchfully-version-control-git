package solid.solution_codelab02_open_closed_principle;

import solid.solution_codelab02_open_closed_principle.shapes.GeometryShape;

public class GeometryCalculator {

    public double calculateCircumference(GeometryShape geometryShape) {
        return geometryShape.calculateShapeCircumference();
    }

    public double calculateArea(GeometryShape geometryShape) {
        return geometryShape.calculateShapeArea();
    }

}

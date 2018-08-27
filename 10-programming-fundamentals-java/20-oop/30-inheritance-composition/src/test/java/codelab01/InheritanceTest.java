package codelab01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InheritanceTest {

    @Test
    public void triangleShouldHavePolygonAsASuperclass() throws Exception {
        Triangle testedObject = new Triangle();

        Assertions.assertThat(testedObject).isInstanceOf(Polygon.class);
    }

    @Test
    public void quadrangleShouldHavePolygonAsASuperclass() throws Exception {
        Quadrangle testedObject = new Quadrangle();

        Assertions.assertThat(testedObject).isInstanceOf(Polygon.class);
    }

    @Test
    public void quadrangleShouldHaveRectangleAsASuperclass() throws Exception {
        Rectangle testedObject = new Rectangle();

        Assertions.assertThat(testedObject).isInstanceOf(Quadrangle.class);
    }

    @Test
    public void squareShouldHaveRectangleAsASuperclass() throws Exception {
        Square testedObject = new Square();

        Assertions.assertThat(testedObject).isInstanceOf(Rectangle.class);
    }

}
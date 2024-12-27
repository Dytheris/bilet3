import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    public void testValidTriangle() {
        assertDoesNotThrow(() -> {
            Triangle triangle = new Triangle(3, 4, 5);
            assertEquals(3, triangle.getSideA());
            assertEquals(4, triangle.getSideB());
            assertEquals(5, triangle.getSideC());
        });
    }

    @Test
    public void testInvalidTriangle() {
        Exception exception = assertThrows(IllegalTriangleException.class, () -> {
            new Triangle(1, 2, 10);
        });
        assertEquals("Сумма длин любых двух сторон должна быть больше длины третьей стороны.", exception.getMessage());
    }

    @Test
    public void testBoundaryValidTriangle() {
        assertDoesNotThrow(() -> {
            Triangle triangle = new Triangle(5, 5, 9.9);
            assertEquals(5, triangle.getSideA());
            assertEquals(5, triangle.getSideB());
            assertEquals(9.9, triangle.getSideC());
        });
    }

    @Test
    public void testBoundaryInvalidTriangle() {
        Exception exception = assertThrows(IllegalTriangleException.class, () -> {
            new Triangle(5, 5, 10);
        });
        assertEquals("Сумма длин любых двух сторон должна быть больше длины третьей стороны.", exception.getMessage());
    }
}

package pro.sky.java.course2.calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceImplTest {
    static CalculatorService out;

    @BeforeAll
    static void initTest() {
        out = new CalculatorServiceImpl();
    }
    @Test
    public void greetingsTest () {
        assertEquals("Добро пожаловать в калькулятор!", out.greetings());
    }
    @Test
    public void plusTest () {
        assertEquals(15, out.plus(7,8));
        assertEquals(-3, out.plus(1,-4));
    }

    @Test
    public void minusTest () {
        assertEquals(-1, out.minus(7,8));
        assertEquals(-6, out.minus(3,9));
    }

    @Test
    public void multiplyTest () {
        assertEquals(56, out.multiply(7,8));
        assertEquals(36, out.multiply(6,6));
    }

    @Test
    public void divideTest () {
        assertEquals(0.875, out.divide(7,8));
        assertEquals(-3.0, out.divide(6, -2));
    }

    @Test
    public void divideByNullTest () {
        assertThrows(IllegalArgumentException.class,() -> out.divide(7,0));
    }

}

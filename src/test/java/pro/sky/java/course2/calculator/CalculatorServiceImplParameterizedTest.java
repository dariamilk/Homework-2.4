package pro.sky.java.course2.calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceImplParameterizedTest {

    static CalculatorService out;

    @BeforeAll
    static void initTest() {
        out = new CalculatorServiceImpl();
    }

    @Test
    public void greetingsTest () {
        Assertions.assertEquals("Добро пожаловать в калькулятор!", out.greetings());
    }

    @ParameterizedTest
    @MethodSource("provideParamsForSumTest")
    public void shouldGenerateCorrectSum (Integer num1, Integer num2, String expected) {
        Assertions.assertEquals(expected, out.plus(num1, num2));
    }
    public static Stream<Arguments> provideParamsForSumTest () {
        return Stream.of (
                Arguments.of(7,8,"7 + 8 = 15"),
                Arguments.of(-1,-7,"-1 + -7 = -8"),
                Arguments.of(4, -9, "4 + -9 = -5")
        );
    }
    @ParameterizedTest
    @MethodSource("provideParamsForMinusTest")
    public void shouldGenerateCorrectDecrementing (Integer num1, Integer num2, String expected) {
        Assertions.assertEquals(expected, out.minus(num1, num2));
    }
    public static Stream<Arguments> provideParamsForMinusTest () {
        return Stream.of (
                Arguments.of(7,8,"7 - 8 = -1"),
                Arguments.of(-1,-7,"-1 - -7 = 6"),
                Arguments.of(4, -9, "4 - -9 = 13")
        );
    }
    @ParameterizedTest
    @MethodSource("provideParamsForMultiplyTest")
    public void shouldGenerateCorrectMultiplicity (Integer num1, Integer num2, String expected) {
        Assertions.assertEquals(expected, out.multiply(num1, num2));
    }
    public static Stream<Arguments> provideParamsForMultiplyTest () {
        return Stream.of (
                Arguments.of(7,8,"7 * 8 = 56"),
                Arguments.of(-1,-7,"-1 * -7 = 7"),
                Arguments.of(4, -9, "4 * -9 = -36")
        );
    }
    @ParameterizedTest
    @MethodSource("provideParamsForDivisionTest")
    public void shouldGenerateCorrectDivision (Integer num1, Integer num2, String expected) {
        Assertions.assertEquals(expected, out.divide(num1, num2));
    }
    public static Stream<Arguments> provideParamsForDivisionTest () {
        return Stream.of (
                Arguments.of(7,8,"7 / 8 = 0.875"),
                Arguments.of(-1,-5,"-1 / -5 = 0.2"),
                Arguments.of(4, -9, "4 / -9 = -0.4444444444444444")
        );
    }
    @Test
    public void divideByNullTest () {
        assertThrows(IllegalArgumentException.class,() -> out.divide(7,0));
    }
}

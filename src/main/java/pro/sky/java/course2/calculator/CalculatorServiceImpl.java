package pro.sky.java.course2.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String greetings() {
        return "Добро пожаловать в калькулятор!";
    }
    @Override
    public int plus(int num1, int num2) {
        return num1 + num2;
     }
    @Override
    public int minus(int num1, int num2) {
        return num1 - num2;
    }
    @Override
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }
    @Override
    public double divide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("На ноль делить нельзя");
        } else {
            return (double)num1 / (double)num2;
        }
    }
}

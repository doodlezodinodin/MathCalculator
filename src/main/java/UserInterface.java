import calculator.Calculator;
import calculator.CalculatorImpl;

public class UserInterface {
    public static void main(String[] args) {

        Calculator calculator = new CalculatorImpl();

        try {
            calculator.calculation(null);
        } catch (Exception e) {

        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String inStr = in.readLine().trim();
            String[] result = inStr.split("\\/|\\*|\\+|\\-");
            checkToDouble(result[0]);
            checkToDouble(result[1]);
            Double num1 = Double.parseDouble(result[0]);
            Double num2 = Double.parseDouble(result[1]);
            Character operator = inStr.replaceAll(result[0], "").charAt(0);
            System.out.println(result(operator, num1, num2));
        } catch (IOException ex) {
            throw new RuntimeException("dfsgdfg");
        }

    }

    public static Double checkToDouble(String val) {
        try {
            return Double.parseDouble(val);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Not a double" + e);
        }
    }

    public static Double result(Character ch, Double num1, Double num2) {
        switch (ch) {
            case '+':
                return (num1 + num2);
            case '-':
                return (num1 - num2);
            case '*':
                return (num1 * num2);
            case '/':
                if (num2 == 0.0) {
                    throw new RuntimeException("Can't divide by zero!");
                } else
                    return num1 / num2;
            default:
                throw new RuntimeException("Invalid operator");
        }
    }
}

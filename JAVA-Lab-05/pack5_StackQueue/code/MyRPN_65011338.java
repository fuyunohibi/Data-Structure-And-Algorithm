package code;
import java.util.StringTokenizer;
import java.util.regex.Pattern;


public class MyRPN_65011338 {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        return pattern.matcher(strNum).matches();
    }

    public static double computeRPN(String rpn) {
        MyStackA_65011338 stack = new MyStackA_65011338();
        StringTokenizer st = new StringTokenizer(rpn);
        
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = 0;

                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        if (operand2 != 0) {
                            result = operand1 / operand2;
                        } else {
                            System.out.println("Division by zero error!");
                            return -1;
                        }
                        break;
                    default:
                        System.out.println("Unknown operator: " + token);
                        return -1;
                }

                stack.push(result);
            }
        }

        return stack.pop();
    }
}
package SQ;

import java.util.StringTokenizer;

public class MyShuntingYard_65011338 {

    private static int order(String c) {
        return switch (c) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }

    public static String infixToPostfix(String infixString) {
        MyQueueL_65011338 queue = new MyQueueL_65011338();
        MyStackL stack = new MyStackL();
        String resultPostfixString = "";
        StringTokenizer st = new StringTokenizer(infixString);
        
        while (st.hasMoreTokens()) {
            String t = st.nextToken();

            if (MyRPN.isNumeric(t)) {
                queue.enqueue(t);
            } else if (t.equals("(")) {
                stack.push(t);
            } else if (t.equals(")")) {
                while (!stack.peek().equals("(")) {
                    queue.enqueue(stack.pop());
                }
                stack.pop(); // discard "("
            } else {
                // Operator handling
                while (!stack.isEmpty() && order(t) <= order(stack.peek())) {
                    queue.enqueue(stack.pop());
                }
                stack.push(t);
            }
            // println("current q = " + queue.dumpToString()); // uncomment for debugging
        }
        
        // Pop any remaining operators from the stack
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }

        resultPostfixString = queue.dumpToString();
        return resultPostfixString;
    }
}

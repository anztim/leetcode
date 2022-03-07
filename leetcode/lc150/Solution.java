package leetcode.lc150;

import java.util.Stack;

/**
 * @author anztim
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            try {
                Integer num = Integer.parseInt(token);
                stack.push(num);
            } catch (NumberFormatException e) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calculate(a, token, b));
            }
        }
        return stack.pop();
    }

    private int calculate(int a, String op, int b) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }
}

class Solution2 extends Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(calculate(a, token, b));
                    break;
                default:
                    Integer num = Integer.parseInt(token);
                    stack.push(num);
            }
        }
        return stack.pop();
    }

    private int calculate(int a, String op, int b) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }
}

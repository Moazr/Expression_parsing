package expression_parsing;


import java.util.Stack;
import javax.swing.JOptionPane;

public class Methods {

    public static int getPriority(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static boolean isOperator(char c) {
        return (!(c >= 'a' && c <= 'z')
                && !(c >= '0' && c <= '9')
                && !(c >= 'A' && c <= 'Z'));
    }

    // method that converts infix expression to postfix expression.
    public static String Postfix(String exp) {
        // initializing empty String for result 
        String result = new String("");

        // initializing empty stack 
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result += c;
            } // If the scanned character is an '(', push it to the stack. 
            else if (c == '(') {
                stack.push(c);
            } /* If the scanned character is an ')', pop and output from 
            the stack until an '(' is encountered. */ 
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression"; // invalid expression                 
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && getPriority(c) <= getPriority(stack.peek())) {
                    if (stack.peek() == '(') {
                        return "Invalid Expression";
                    }
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

// pop all the operators from the stack 
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            result += stack.pop();
        }
        return result;
    }

    // method that converts infix expression to prefix expression.
    public static String Prefix(String exp) {
        //  initializing empty stack for operators.
        Stack<Character> operators = new Stack<Character>();

        // initializing empty stack for operands.
        Stack<String> operands = new Stack<String>();

        for (int i = 1; i < exp.length(); i++) {

            /* If current character is an
             opening bracket, then
             push into the operators stack. */
            if (exp.charAt(i) == '(') {
                operators.push(exp.charAt(i));
            } /* If current character is a closing bracket, then pop from
             both stacks and push result in operands stack until
             matching opening bracket is not found. */ else if (exp.charAt(i) == ')') {
                while (!operators.empty()
                        && operators.peek() != '(') {

                    String operand1 = operands.pop();

                    String operand2 = operands.pop();

                    char operator = operators.pop();

                    /* Add operands and operator in form operator +
                     operand1 + operand2. */
                    String tmp = operator + operand2 + operand1;
                       operands.push(tmp);
                }

                // Pop opening bracket from stack.
                operators.pop();
            } /* If current character is an operand then push it into
             operands stack. */ else if (!isOperator(exp.charAt(i))) {
                operands.push(exp.charAt(i) + "");
            } /* If current character is an operator, then push it into 
            operators stack after popping high priority operators from
            operators stack and pushing result in operands stack. */ else {
                while (!operators.empty() && getPriority(exp.charAt(i))
                        <= getPriority(operators.peek())) {

                    String op1 = operands.pop();

                    String op2 = operands.pop();

                    char op = operators.pop();

                    String tmp = op + op2 + op2;
                    operands.push(tmp);
                }
                operators.push(exp.charAt(i));
            }
        }

        /* Pop operators from operators stack until it is empty and
         operation in add result of
         each pop operands stack. */
        while (!operators.empty()) {
            String op1 = operands.pop();

            String op2 = operands.pop();

            char op = operators.pop();

            String tmp = op + op2 + op1;
            operands.push(tmp);
        }

        // Final prefix expression is present in operands stack.
        return operands.peek();
    }
    
    // method that evaluate a postfix expression.
    static double evaluatePostfix(String exp) {

        try {
            // initializing empty stack for postfix
            Stack<Double> postFix = new Stack<>();
            int n = exp.length();

            for (int i = 0; i < n; i++) {
                if (isOperator(exp.charAt(i))) {
                    // pop top 2 operands.
                    double op1 = postFix.pop();
                    double op2 = postFix.pop();

                    // evaluate in reverse order, op2 operator op1.
                    switch (exp.charAt(i)) {
                        case '+':
                            postFix.push(op2 + op1);
                            break;

                        case '-':
                            postFix.push(op2 - op1);
                            break;

                        case '*':
                            postFix.push(op2 * op1);
                            break;

                        case '/':
                            postFix.push(op2 / op1);
                            break;
                    }

                } else {
                    // convert to double
                    double operand = exp.charAt(i) - '0';
                    postFix.push(operand);
                }
            }
            // Stack at End will contain result.
            return (postFix.pop());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You made an exception called " + e + "\n Please try again");
        }
        return 0;
    }

}

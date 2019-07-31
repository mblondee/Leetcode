package leetcode.leetcode141_160;

/*Evaluate the value of an arithmetic expression in Reverse Polish Notation.

        Valid operators are +, -, *, /. Each operand may be an integer or another expression.

        Note:

        Division between two integers should truncate toward zero.
        The given RPN expression is always valid.
        That means the expression would always evaluate to a result and
        there won't be any divide by zero operation.*/

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {
    public static int evalRPN(String[] tokens) {
        if(tokens.length == 0){
            return 0;
        }
        Stack<Integer> results = new Stack<>();

        for(int i = 0; i < tokens.length; i++){

            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int operator2 = results.pop();
                int operator1 = results.pop();
                if(tokens[i].equals("+")){
                    results.push(operator1 + operator2);
                }
                if(tokens[i].equals("-")){
                    results.push(operator1 - operator2);
                }
                if(tokens[i].equals("*")){
                    results.push(operator1 * operator2);
                }
                if(tokens[i].equals("/")){
                    results.push(operator1 / operator2);
                }
            }

            else{
                // parse the number
                int number = Integer.parseInt(tokens[i]);
                results.push(number);
            }
        }

        return results.pop();

    }
}

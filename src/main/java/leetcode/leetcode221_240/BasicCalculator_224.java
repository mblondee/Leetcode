package leetcode.leetcode221_240;

/*Implement a basic calculator to evaluate a simple expression string.

        The expression string may contain open ( and closing parentheses ),
        the plus + or minus sign -, non-negative integers and empty spaces .*/

import java.util.Stack;

public class BasicCalculator_224 {
    public static int calculate(String s) {
        int result = 0;
        int sign = 1; // next number should be added or subtracted

        Stack<Integer> st = new Stack<>();


        for(int i = 0; i <s.length(); i++){
            // next is number
            if('0' <= s.charAt(i) && s.charAt(i) <= '9'){
                int sum = s.charAt(i) - '0';
                // check for more numbers
                while(i+1 <s.length() && '0' <= s.charAt(i+1) && s.charAt(i+1) <= '9'){
                    sum = sum*10 + (s.charAt(i+1) - '0');
                    i++;
                }
                result += sum*sign;
            }

            else if(s.charAt(i) == '+'){
                sign = 1;
            }

            else if(s.charAt(i) == '-'){
                sign =-1;
            }
            else if(s.charAt(i) == '('){
                // push current result and sign on the stack
                // we reset result and sign -> so that we can find result in between the brackets
                // when we encounter closing bracket we update result => multiply with sign and add previous result
                st.push(result);
                st.push(sign);
                result = 0;
                sign =1;

            }
            else if(s.charAt(i) == ')'){
                // first popped is sign
                result = st.pop()*result + st.pop();

            }
            else if(s.charAt(i) == ' '){
                continue;
            }


        }

        return result;

    }
}

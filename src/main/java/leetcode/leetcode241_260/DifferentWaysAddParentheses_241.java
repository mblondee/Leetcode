package leetcode.leetcode241_260;

/*Given a string of numbers and operators, return all possible results
        from computing all the different possible ways to group numbers and operators.
        The valid operators are +, - and *.*/

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysAddParentheses_241 {

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();



        // try to find the first no number
        for(int i = 0; i < input.length(); i++){
            // can be +, -, * or a number
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                // we find what is before and what is after
                List<Integer> before = diffWaysToCompute(input.substring(0, i));
                List<Integer> after = diffWaysToCompute(input.substring(i+1));
                // both before and after are lists with different options of putting the brackets
                // we need to loop over all of them and added the new combinations to result
                for(int x : before){
                    for(int y : after){
                        if(c == '+'){
                            result.add(x+y);
                        }
                        else if(c== '-'){
                            result.add(x-y);
                        }
                        else{
                            result.add(x*y);
                        }
                    }
                }
            }

        }

        // if result is empty it is because the input only consisted of numbers
        if(result.size()==0){
            result.add(Integer.parseInt(input));
        }


        return result;

    }

}

package leetcode.leetcode281_300;

/*Given a string that contains only digits 0-9 and a target value,
        return all possibilities to add binary operators (not unary) +, -, or *
        between the digits so they evaluate to the target value.*/

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators_282 {
    public static List<String> addOperators(String num, int target) {

        List<String> result = new ArrayList<>();
        if(num == null || num.length() == 0){
            return result;
        }

        helper(result, new StringBuffer(), num, target, 0, 0,0);

        return result;
    }

    private static void helper(List<String> result, StringBuffer str, String num, int target, int index, long eval, long previous){

        // if we are at the end of the string num
        if(index == num.length()){
            // check is evaluation of str is equal to target
            // if so add to result
            if(eval == target){
                result.add(str.toString());
            }
            return;
        }


        // from current index we can choose to take 1 or more digits
        for(int i = index; i < num.length(); i++){
            // special case: we cannot have leading zeroes
            if(i > index && num.charAt(index) == '0'){
                break; // the starting index is not valid!
            }

            // get current length -> when coming out of recursion we have to reset str to what it was before
            int currentLength = str.length();
            // get number
            long currentNumber = Long.parseLong(num.substring(index, i+1));
            // add number to str
            // if i = 0, then no operator becomes before the number
            if(index == 0){
                helper(result, str.append(currentNumber), num, target, i+1, currentNumber, currentNumber);
                str.setLength(currentLength);
            }
            else{
                helper(result, str.append("+").append(currentNumber), num, target, i+1, eval+currentNumber, currentNumber);
                str.setLength(currentLength);
                helper(result, str.append("-").append(currentNumber), num, target, i+1, eval-currentNumber, -currentNumber);
                str.setLength(currentLength);

                // suppose we have arrived at eval = 1+2 and now we want to do *3
                // we don't want (1+2)*3 but 1+(2*3)
                // idea: (1+2) - 2 + 2*3 = eval - 2 + 2*3
                // -2 is reverse of last operation +2, so we save the add operation, so we can undo it
                helper(result, str.append("*").append(currentNumber), num, target, i+1,
                        eval - previous + previous*currentNumber,  previous*currentNumber);
                str.setLength(currentLength);
            }
        }
    }
}

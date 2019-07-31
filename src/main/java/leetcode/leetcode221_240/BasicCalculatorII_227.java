package leetcode.leetcode221_240;


/*Implement a basic calculator to evaluate a simple expression string.

        The expression string contains only non-negative integers, +, -, *, /
        operators and empty spaces . The integer division should truncate toward zero.*/


public class BasicCalculatorII_227 {
    public static int calculate(String s) {
        int result = 0;
        int currNum = 0; // current number we encounter
        int temp = 0; // to save a number if we cannot use it immediately (* and / have preference)
        int stillPlusOrMin = 1; // there still has to be done either + or - with temp, 1: +, -1: -
        int stillTimesOrDivide = 0; // there still to be done either * or / with temp, 1: *, -1: /


        // update result by result + stillPlusOrMin*temp
        // make sure after seeing a new number whether there still has to be made a * or / before putting it in temp

        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                continue;
            }
            // suppose next is a number
            if(c >= '0' && c <= '9'){
                currNum =  c-'0';
                while(i+1 < s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9'){
                    currNum = currNum*10 + s.charAt(i+1) - '0';
                    i++;
                }

                // now decide what to do with the number

                // eg 3+1*2
                // when we arrive at 2 we will have
                // result = 3, temp = 1, stillPlusOrMin = 1, stillTimesOrDivide = 1
                // times and divide have priority
                // after:
                // result = 3, temp = 2, stillPlusOrMin = 1, stillTimesOrDivide = 0

                if(stillTimesOrDivide == 1){
                    // times
                    temp *= currNum;
                    stillTimesOrDivide = 0;
                }
                else if(stillTimesOrDivide == -1){
                    // divide
                    if(currNum == 0){
                        temp = 0; //?
                    }
                    else {
                        temp /= currNum;
                        stillTimesOrDivide = 0;
                    }
                    stillTimesOrDivide = 0;
                }
                else{
                    // save it for further calculations
                    temp = currNum;
                }
            }

            // if c is not a number
            else if (c == '+') {
                result += stillPlusOrMin*temp;
                stillPlusOrMin = 1;
            }
            else if (c == '-') {
                result += stillPlusOrMin*temp;
                stillPlusOrMin = -1;
            }
            else if (c == '*') {
                stillTimesOrDivide = 1;
            }
            else if (c == '/') {
                stillTimesOrDivide = -1;
            }


        }
        return result + stillPlusOrMin*temp;

    }
}

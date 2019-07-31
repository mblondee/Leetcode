package leetcode;

import leetcode.leetcode141_160.EvaluateReversePolishNotation_150;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test_leetcode141_160 {

    @Test
    public void testEvaluateReversePolishNotation(){
        assertEquals(9, EvaluateReversePolishNotation_150.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(6, EvaluateReversePolishNotation_150.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        assertEquals(22, EvaluateReversePolishNotation_150.evalRPN(
                new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));

    }
}

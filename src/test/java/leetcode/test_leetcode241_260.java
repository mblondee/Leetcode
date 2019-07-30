package leetcode;

import leetcode.leetcode241_260.DifferentWaysAddParentheses_241;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class test_leetcode241_260 {

    @Test
    public void testDifferentWaysAddParenthese(){
        List<Integer> result = DifferentWaysAddParentheses_241.diffWaysToCompute("2-1-1");
        assertEquals(2, result.size());

        List<Integer> result1 = DifferentWaysAddParentheses_241.diffWaysToCompute("2*3-4*5");
        assertEquals(5, result1.size());
    }
}

package leetcode;

import leetcode.leetcode481_500.MaxConsecutiveOnes_485;
import leetcode.leetcode481_500.ReversePairs_493;
import leetcode.leetcode481_500.TargetSum_494;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test_leetcode481_500 {

    @Test
    public void testReversePairs(){
        assertEquals(2, ReversePairs_493.reversePairs(new int[]{1,3,2,3,1}));
        assertEquals(3, ReversePairs_493.reversePairs(new int[]{2,4,3,5,1}));
        ReversePairs_493.reversePairs(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
        Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE});
    }

    @Test
    public void testTargetSum(){
        assertEquals(5, TargetSum_494.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    @Test
    public void testMaxConsecutiveOnes(){
        assertEquals(3, MaxConsecutiveOnes_485.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        assertEquals(0, MaxConsecutiveOnes_485.findMaxConsecutiveOnes(new int[]{0,0,0,0,0,0}));
    }
}

package leetcode;

import leetcode.leetcode481_500.ReversePairs_493;
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
}

package leetcode;

import leetcode.Leetcode321_340.IncreasingTripletSubsequence_334;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class test_leetcode321_340 {

    @Test
    public void testIncreasingTripletSubsequence(){
        assertTrue(IncreasingTripletSubsequence_334.increasingTriplet(new int[]{1,2,3,4,5}));
        assertFalse(IncreasingTripletSubsequence_334.increasingTriplet(new int[]{1,2}));
        assertFalse(IncreasingTripletSubsequence_334.increasingTriplet(new int[]{1,2,1,2,1}));
        assertTrue(IncreasingTripletSubsequence_334.increasingTriplet(new int[]{5,1,5,5,2,5,4}));

    }
}

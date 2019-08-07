package leetcode;

import leetcode.leetcode321_340.CountOfRangeSum_327;
import leetcode.leetcode321_340.IncreasingTripletSubsequence_334;
import leetcode.leetcode321_340.VerifyPreorderSerializationBinaryTree_331;
import org.junit.Test;

import static org.junit.Assert.*;

public class test_leetcode321_340 {

    @Test
    public void testIncreasingTripletSubsequence(){
        assertTrue(IncreasingTripletSubsequence_334.increasingTriplet(new int[]{1,2,3,4,5}));
        assertFalse(IncreasingTripletSubsequence_334.increasingTriplet(new int[]{1,2}));
        assertFalse(IncreasingTripletSubsequence_334.increasingTriplet(new int[]{1,2,1,2,1}));
        assertTrue(IncreasingTripletSubsequence_334.increasingTriplet(new int[]{5,1,5,5,2,5,4}));
    }

    @Test
    public void testCountOfRange(){
        assertEquals(3, CountOfRangeSum_327.countRangeSum(new int[]{-2,5,-1}, -2,2));
        assertEquals(3, CountOfRangeSum_327.countRangeSum(new int[]{-2147483647,0,-2147483647,2147483647}, -564, 3864));
    }

    @Test
    public void testVerifySerializationBinaryTree(){
        VerifyPreorderSerializationBinaryTree_331 verify = new VerifyPreorderSerializationBinaryTree_331();
        assertTrue(verify.isValidSerialization("9,3,#,#,4,#,#"));
        assertTrue(verify.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        assertFalse(verify.isValidSerialization("1,#"));
        assertFalse(verify.isValidSerialization("9,#,#,1"));
        assertFalse(verify.isValidSerialization("#,7,6,9,#,#,#"));
        assertTrue(verify.isValidSerialization("#"));
        assertFalse(verify.isValidSerialization("7,2,#,2,#,#,#,6,#"));

    }
}

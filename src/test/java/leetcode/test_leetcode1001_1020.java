package leetcode;

import leetcode.leetcode1001_1020.MaxConsecutiveOnesIII_1004;

import leetcode.leetcode1001_1020.PairsSongsWithTotalDurations_1010;
import leetcode.leetcode1001_1020.PartitionArrayIntoThreePartsWithEqualSum_1013;
import org.junit.Test;

import static org.junit.Assert.*;

public class test_leetcode1001_1020 {

    @Test
    public void testMaxConsecutiveOnesIII(){
        assertEquals(6, MaxConsecutiveOnesIII_1004.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        assertEquals(10, MaxConsecutiveOnesIII_1004.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        assertEquals(4, MaxConsecutiveOnesIII_1004.longestOnes(new int[]{0,0,0,1}, 4));
    }

    @Test
    public void testPartitionArrayIntoThreePartsWithEqualSum(){
        assertTrue(PartitionArrayIntoThreePartsWithEqualSum_1013.canThreePartsEqualSum(new int[]{0,2,1,-6,6,-7,9,1,2,0,1}));
        assertFalse(PartitionArrayIntoThreePartsWithEqualSum_1013.canThreePartsEqualSum(new int[]{0,2,1,-6,6,7,9,-1,2,0,1}));
        assertTrue(PartitionArrayIntoThreePartsWithEqualSum_1013.canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4}));

    }

    @Test
    public void testPairsSongsWithTotalDurations(){
        PairsSongsWithTotalDurations_1010 pairs = new PairsSongsWithTotalDurations_1010();
        assertEquals(3, pairs.numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
        assertEquals(3, pairs.numPairsDivisibleBy60(new int[]{60,60,60}));
        assertEquals(1, pairs.numPairsDivisibleBy60(new int[]{15,63,451,213,37,209,343,319}));
    }
}

package leetcode;

import leetcode.leetcode841_860.HandOfStraights_846;
import leetcode.leetcode841_860.PeakIndexMountainArray_852;
import org.junit.Test;

import static org.junit.Assert.*;

public class test_leetcode841_860 {

    @Test
    public void testHandOfStraights(){
        assertTrue(HandOfStraights_846.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
        assertFalse(HandOfStraights_846.isNStraightHand(new int[]{1,2,3,4,5}, 4));
    }

    @Test
    public void testPeakMountainArray(){
        assertEquals(1, PeakIndexMountainArray_852.peakIndexInMountainArray(new int[]{0,1,0}));
        assertEquals(1, PeakIndexMountainArray_852.peakIndexInMountainArray(new int[]{0,2,1,0}));
        assertEquals(2, PeakIndexMountainArray_852.peakIndexInMountainArray(new int[]{3,4,5,1}));

    }
}

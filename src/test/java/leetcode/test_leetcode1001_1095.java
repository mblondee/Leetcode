package leetcode;

import leetcode.leetcode1001_1100.FindInMountainArray_1095;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test_leetcode1001_1095 {

    @Test
    public void testFindInMountainArray(){
        assertEquals(2, FindInMountainArray_1095.findInMountainArray(
                3, new MountainArray(new int[]{1,2,3,4,5,3,1})));
        assertEquals(-1, FindInMountainArray_1095.findInMountainArray(
                6, new MountainArray(new int[]{1,2,3,4,5,3,1})));
        assertEquals(-1, FindInMountainArray_1095.findInMountainArray(
                5, new MountainArray(new int[]{1,2,3,4,6,3,1})));
        assertEquals(-1, FindInMountainArray_1095.findInMountainArray(
                5, new MountainArray(new int[]{})));
        assertEquals(4, FindInMountainArray_1095.findInMountainArray(
                0, new MountainArray(new int[]{3,5,3,2,0})));
    }
}

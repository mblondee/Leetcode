package leetcode;

import leetcode.leetcode161_180.FindPeakElement_162;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class test_leetcode161_180 {

    @Test
    public void testFindPeakElement(){
        assertEquals(2, FindPeakElement_162.findPeakElement(new int[]{1,2,3,1}));
        int res = FindPeakElement_162.findPeakElement(new int[]{1,2,1,3,5,6,4});
        assertTrue(res == 1 || res == 5);
        assertEquals(-1, FindPeakElement_162.findPeakElement(new int[]{}));
        assertEquals(0, FindPeakElement_162.findPeakElement(new int[]{1}));
        assertEquals(1, FindPeakElement_162.findPeakElement(new int[]{0,1}));
    }
}

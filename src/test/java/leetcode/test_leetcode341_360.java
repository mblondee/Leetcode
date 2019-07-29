package leetcode;

import leetcode.leetcode341_360.SummaryRanges_352;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class test_leetcode341_360 {

    @Test
    public void testSummaryRanges(){
        SummaryRanges_352 sum = new SummaryRanges_352();
        assertArrayEquals(new int[][]{}, sum.getIntervals());
        sum.addNum(1);
        sum.addNum(3);
        sum.addNum(7);
        sum.addNum(2);
        sum.addNum(6);
        int[][] result = {{1,3}, {6,7}};
        assertArrayEquals(result, sum.getIntervals());

        SummaryRanges_352 sum1 = new SummaryRanges_352();
        sum1.addNum(1);
        assertArrayEquals(new int[][]{{1,1}}, sum1.getIntervals());
        sum1.addNum(0);
        assertArrayEquals(new int[][]{{0,1}}, sum1.getIntervals());
    }
}

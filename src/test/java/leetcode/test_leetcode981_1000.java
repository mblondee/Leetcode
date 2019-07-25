package leetcode;

import leetcode.leetcode981_1000.IntervalListIntersections_986;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class test_leetcode981_1000 {

    @Test
    public void testIntervalListIntersections(){
        int[][] A = {{0,2}, {5,10}, {13,23}, {24,25}};
        int[][] B = {{1,5}, {8,12}, {15,24}, {25,26}};
        assertArrayEquals(new int[][]{{1,2}, {5,5}, {8,10}, {15,23}, {24,24}, {25,25}},
                IntervalListIntersections_986.intervalIntersection(A,B));

        assertArrayEquals(new int[][]{}, IntervalListIntersections_986.intervalIntersection(
                new int[][]{{1,2}, {3,4}}, new int[][]{}
        ));

        assertArrayEquals(new int[][]{}, IntervalListIntersections_986.intervalIntersection(
                new int[][]{{1,2}, {3,4}}, new int[][]{{6,8}}
        ));

        assertArrayEquals(new int[][]{{2,3}, {4,5}}, IntervalListIntersections_986.intervalIntersection(
                new int[][]{{1,3}, {4,6}}, new int[][]{{2,5}}
        ));
    }
}

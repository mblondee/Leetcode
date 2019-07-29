package leetcode;

import leetcode.leetcode401_420.QueueReconstruction_406;
import org.junit.Test;


import static org.junit.Assert.assertArrayEquals;

public class test_leetcode401_410 {

    @Test
    public void testQueueReconstruction(){
        int[][] people1 = {{7,0}, {4,4}, {7,1},{5,0}, {6,1}, {5,2}};
        int[][] result1 = {{5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1}};
        assertArrayEquals(result1, QueueReconstruction_406.reconstructQueue(people1));

        int[][] people2 = {{8,2},{4,2},{4,5},{2,0},{7,2},{1,4},{9,1},{3,1},{9,0},{1,0}};
        QueueReconstruction_406.reconstructQueue(people2);
    }
}

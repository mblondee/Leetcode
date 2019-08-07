package leetcode;

import leetcode.leetcode561_580.ReshapeMatrix_566;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class test_leetcode561_580 {

    @Test
    public void testReshapeMatrix(){
        ReshapeMatrix_566 shape = new ReshapeMatrix_566();
        assertArrayEquals(new int[][]{{1,2,3,4}}, shape.matrixReshape(new int[][]{{1,2}, {3,4}}, 1, 4));
        assertArrayEquals(new int[][]{{1,2},{3,4}}, shape.matrixReshape(new int[][]{{1,2}, {3,4}}, 2, 4));
    }
}

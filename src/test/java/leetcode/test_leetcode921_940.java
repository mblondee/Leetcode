package leetcode;

import leetcode.Leetcode921_940.MinimumAreaRectangle_939;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test_leetcode921_940 {

    @Test
    public void testMinimumAreaRectangle(){
        int[][] matrix1 = {{1,1}, {1,3}, {3,1}, {3,3}, {2,2}};
        assertEquals(4, MinimumAreaRectangle_939.minAreaRect(matrix1));
        assertEquals(0, MinimumAreaRectangle_939.minAreaRect(new int[][]{}));
        int[][] matrix2 = {{1,1}, {1,3}, {3,1}, {3,3}, {4,1}, {4,3}};
        assertEquals(2, MinimumAreaRectangle_939.minAreaRect(matrix2));

    }
}

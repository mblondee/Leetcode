package leetcode;


import leetcode.leetcode821_840.FlippingAnImage_832;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class test_leetcode821_840 {

    @Test
    public void testFlippingAnImage(){
        int[][] matrix1 = {{1,1,0}, {1,0,1}, {0,0,0}};
        int[][] result1 = {{1,0,0}, {0,1,0}, {1,1,1}};
        assertArrayEquals(result1, FlippingAnImage_832.flipAndInvertImage(matrix1));

        int[][] matrix2 = {{1,1,0,0}, {1,0,0,1}, {0,1,1,1}, {1,0,1,0}};
        int[][] result2 = {{1,1, 0,0}, {0,1,1,0}, {0,0,0,1}, {1,0,1,0}};
        assertArrayEquals(result2, FlippingAnImage_832.flipAndInvertImage(matrix2));
    }
}

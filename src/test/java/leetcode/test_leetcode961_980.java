package leetcode;

import leetcode.leetcode961_980.SquaresSortedArray_977;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class test_leetcode961_980 {

    @Test
    public void testSquaresSortedArray(){
        int[] input1 = new int[]{-4,-1,0,3,10};
        assertArrayEquals(new int[]{0,1,9,16,100}, SquaresSortedArray_977.sortedSquares(input1));
        assertArrayEquals(new int[]{9,16,25}, SquaresSortedArray_977.sortedSquares(new int[]{3,4,5}));
        assertArrayEquals(new int[]{}, SquaresSortedArray_977.sortedSquares(new int[]{}));
        assertArrayEquals(new int[]{9,16,25}, SquaresSortedArray_977.sortedSquares(new int[]{-5,-4,-3}));
    }
}

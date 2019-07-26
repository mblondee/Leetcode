package leetcode;

import leetcode.leetcode301_320.CountSmallerNumbersAfterSelf_315;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class test_leetcode301_320 {
    @Test
    public void testCounterSmallerNumbersAfterSelf(){
        List<Integer> counts = CountSmallerNumbersAfterSelf_315.countSmaller(new int[]{5,2,6,1});
        assertEquals(4, counts.size());
        Integer[] result = {2,1,1,0};
        for(int i = 0; i < result.length; i++){
            assertEquals(result[i], counts.get(i));
        }
    }
}

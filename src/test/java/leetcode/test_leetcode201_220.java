package leetcode;

import leetcode.leetcode201_220.ContainsDuplicateIII_220;
import leetcode.leetcode201_220.ContainsDuplicateII_219;
import leetcode.leetcode201_220.ContainsDuplicate_217;
import leetcode.leetcode201_220.IsomorphicStrings_205;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class test_leetcode201_220 {

    @Test
    public void testIsomorphicStrings(){
/*        char[] test = new char[256];
        test[0] = 'a';
        test['a'] = '0';
        System.out.println(test['a'] == '0');
        System.out.println(test['b'] == '0');
        System.out.println(test['b'] == 0);*/

        assertTrue(IsomorphicStrings_205.isIsomorphic("egg", "add"));
        assertFalse(IsomorphicStrings_205.isIsomorphic("foo", "bar"));
        assertTrue(IsomorphicStrings_205.isIsomorphic("paper", "title"));
        assertTrue(IsomorphicStrings_205.isIsomorphic("", ""));
        assertFalse(IsomorphicStrings_205.isIsomorphic("acccccccb", "addddddda"));
    }

    @Test
    public void testContainsDuplicate(){
        assertTrue(ContainsDuplicate_217.containsDuplicate(new int[]{1,2,3,1}));
        assertFalse(ContainsDuplicate_217.containsDuplicate(new int[]{1,2,3,4}));
        assertFalse(ContainsDuplicate_217.containsDuplicate(new int[]{}));
        assertTrue(ContainsDuplicate_217.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    @Test
    public void testContainsDuplicateII(){
        assertTrue(ContainsDuplicateII_219.containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        assertTrue(ContainsDuplicateII_219.containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        assertFalse(ContainsDuplicateII_219.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

    @Test
    public void testContainsDuplicateIII(){
        assertTrue(ContainsDuplicateIII_220.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
        assertTrue(ContainsDuplicateIII_220.containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2));
        assertFalse(ContainsDuplicateIII_220.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
        assertFalse(ContainsDuplicateIII_220.containsNearbyAlmostDuplicate(new int[]{-1,-5,-9,-1,-5,-9}, 2, 3));
        assertTrue(ContainsDuplicateIII_220.containsNearbyAlmostDuplicate(new int[]{-1,0,-1,-1}, 1, 2));
        assertFalse(ContainsDuplicateIII_220.containsNearbyAlmostDuplicate(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE+1},
        1, Integer.MAX_VALUE));
        assertFalse(ContainsDuplicateIII_220.containsNearbyAlmostDuplicate(new int[]{2147483647, -2147483645},
                1, 5));
    }
}

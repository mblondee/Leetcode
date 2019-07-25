package leetcode;

import leetcode.Leetcode381_400.RandomizedCollection_381;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class test_leetcode381_400 {

    @Test
    public void testRandomizedCollection(){
        RandomizedCollection_381 coll = new RandomizedCollection_381();
        assertTrue(coll.insert(1));
        assertFalse(coll.insert(1));
        assertTrue(coll.insert(2));
        assertFalse(coll.remove(3));
        assertTrue(coll.remove(1));
        assertTrue(coll.remove(1));
        assertTrue(coll.remove(2));

    }
}

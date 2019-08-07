package leetcode;

import leetcode.leetcode161_180.BSTIterator_173;
import leetcode.leetcode161_180.FindPeakElement_162;
import org.junit.Test;

import static org.junit.Assert.*;

public class test_leetcode161_180 {

    @Test
    public void testFindPeakElement(){
        assertEquals(2, FindPeakElement_162.findPeakElement(new int[]{1,2,3,1}));
        int res = FindPeakElement_162.findPeakElement(new int[]{1,2,1,3,5,6,4});
        assertTrue(res == 1 || res == 5);
        assertEquals(-1, FindPeakElement_162.findPeakElement(new int[]{}));
        assertEquals(0, FindPeakElement_162.findPeakElement(new int[]{1}));
        assertEquals(1, FindPeakElement_162.findPeakElement(new int[]{0,1}));
    }

    @Test
    public void testBinarySearchTreeIterator(){
        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(3);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(20);
        BSTIterator_173 iterator = new BSTIterator_173(node);
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(7, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(9, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(15, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(20, iterator.next());
        assertFalse(iterator.hasNext());

    }
}

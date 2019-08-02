package leetcode;

/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

        (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

        You are given a target value to search. If found in the array return true, otherwise return false.*/

import leetcode.leetcode121_140.BinaryTreeMaximumPathSum_124;
import leetcode.leetcode121_140.SumRootToLeafNumbers_129;
import leetcode.leetcode81_100.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class test_leetcode121_140 {

    @Test
    public void testSearchRotatedSortedArray(){
        assertTrue(SearchRotatedSortedArray_81.search(new int[]{2,5,6,0,0,1,2}, 0));
        assertTrue(SearchRotatedSortedArray_81.search(new int[]{2,5,6,0,0,1,2}, 1));
        assertTrue(SearchRotatedSortedArray_81.search(new int[]{2,5,6,0,0,1,2}, 2));
        assertTrue(SearchRotatedSortedArray_81.search(new int[]{2,5,6,0,0,1,2}, 5));
        assertTrue(SearchRotatedSortedArray_81.search(new int[]{2,5,6,0,0,1,2}, 6));
        assertFalse(SearchRotatedSortedArray_81.search(new int[]{2,5,6,0,0,1,2}, 3));
        assertFalse(SearchRotatedSortedArray_81.search(new int[]{2,5,6,0,0,1,2}, -3));
        assertFalse(SearchRotatedSortedArray_81.search(new int[]{2,5,6,0,0,1,2}, 4));
        assertFalse(SearchRotatedSortedArray_81.search(new int[]{2,5,6,0,0,1,2}, 7));

        assertFalse(SearchRotatedSortedArray_81.search(new int[]{2}, 3));
        assertTrue(SearchRotatedSortedArray_81.search(new int[]{2}, 2));

        assertTrue(SearchRotatedSortedArray_81.search(new int[]{1,1,3,1}, 3));
        assertTrue(SearchRotatedSortedArray_81.search(new int[]{3,1}, 1));
    }

    @Test
    public void testRemoveDuplicatesSortedList(){
        ListNode ex1 = new ListNode(1);
        ex1.next = new ListNode(1);
        ex1.next.next = new ListNode(1);
        ex1.next.next.next = new ListNode(2);
        ex1.next.next.next.next = new ListNode(2);
        ex1.next.next.next.next.next = new ListNode(2);
        ex1.next.next.next.next.next.next = new ListNode(3);

        ListNode res1 = RemoveDuplicatesSortedList_83.deleteDuplicates(ex1);
        assertEquals(1, res1.val);
        assertEquals(2, res1.next.val);
        assertEquals(3, res1.next.next.val);
        assertEquals(null, res1.next.next.next);
    }

    @Test
    public void testRemoveDuplicatesSortedListII(){
        ListNode ex1 = new ListNode(1);
        ex1.next = new ListNode(1);
        ex1.next.next = new ListNode(1);
        ex1.next.next.next = new ListNode(2);
        ex1.next.next.next.next = new ListNode(2);
        ex1.next.next.next.next.next = new ListNode(2);
        ex1.next.next.next.next.next.next = new ListNode(3);

        ListNode res1 = RemoveDuplicatesSortedListII_82.deleteDuplicates(ex1);
        assertEquals(3, res1.val);
        assertEquals(null, res1.next);


        ListNode ex2 = new ListNode(1);
        ex2.next = new ListNode(2);
        ex2.next.next = new ListNode(3);
        ListNode res2 = RemoveDuplicatesSortedListII_82.deleteDuplicates(ex2);
        assertEquals(1, res2.val);
        assertEquals(2, res2.next.val);
        assertEquals(3, res2.next.next.val);
        assertEquals(null, res2.next.next.next);
    }

    @Test
    public void testLargestRectangleHistogram(){
        int[] hist1 = new int[]{2,1,5,6,2,3};
        assertEquals(10, LargestRectangleHistogram_84.largestRectangleArea(hist1));

        int[] hist2 = new int[]{};
        assertEquals(0, LargestRectangleHistogram_84.largestRectangleArea(hist2));
    }

    @Test
    public void testMaximalRectangle(){
        char[][] matrix1 = {{'0','1','1','0'}, {'1','1','1','0'}, {'1','0','0','1'}, {'1','1','1','1'}};
        assertEquals(4, MaximalRectangle_85.maximalRectangle(matrix1));

        char[][] matrix2 = new char[][]{};
        assertEquals(0, MaximalRectangle_85.maximalRectangle(matrix2));
    }

    @Test
    public void testPartitionList(){
        int[] array1 = {1,4,3,2,5,2};
        ListNode head1 = new ListNode(array1[0]);
        ListNode pointer1 = head1;
        for(int i = 1; i < array1.length; i++){
            pointer1.next = new ListNode(array1[i]);
            pointer1 = pointer1.next;
        }

        PartitionList_86.partition(head1, 3);

    }

    @Test
    public void testBinaryTreeMaximumPathSum(){
        TreeNode node = new TreeNode(-10);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        BinaryTreeMaximumPathSum_124 path = new BinaryTreeMaximumPathSum_124();
        assertEquals(42, path.maxPathSum(node));

        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);

        assertEquals(6, path.maxPathSum(node1));

        TreeNode node2 = new TreeNode(-3);
        assertEquals(-3, path.maxPathSum(node2));

        TreeNode node3 = new TreeNode(2);
        node3.left = new TreeNode(-1);
        node3.right = new TreeNode(-2);

        assertEquals(2, path.maxPathSum(node3));

    }

    @Test
    public void testSumRootToLeafNumbers(){
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        SumRootToLeafNumbers_129 sum = new SumRootToLeafNumbers_129();
        assertEquals(25, sum.sumNumbers(node));

        TreeNode node1 = new TreeNode(4);
        node1.left = new TreeNode(9);
        node1.right = new TreeNode(0);
        node1.left.left = new TreeNode(5);
        node1.left.right = new TreeNode(1);
        assertEquals(1026, sum.sumNumbers(node1));
    }
}

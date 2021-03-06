package leetcode;

import leetcode.leetcode81_100.*;
import org.junit.Test;
import leetcode.leetcode61_80.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class test_leetcode81_100 {

    @Test
    public void RotateListTest(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(4);

        ListNode result1 = RotateList_61.rotateRight(head,1);
        ListNode p1 = head1;
        ListNode pp1  = result1;
        while(pp1 != null){
            assertEquals(pp1.val, p1.val);
            pp1 = pp1.next;
            p1 = p1.next;
        }

        ListNode head11 = new ListNode(1);
        head11.next = new ListNode(2);
        head11.next.next = new ListNode(3);
        head11.next.next.next = new ListNode(4);
        head11.next.next.next.next = new ListNode(5);
        ListNode result6 = RotateList_61.rotateRight(head11,6);
        ListNode p6 = head1;
        ListNode pp6  = result6;
        while(pp6 != null){
            assertEquals(pp6.val, p6.val);
            pp6 = pp6.next;
            p6 = p6.next;
        }


    }

    @Test
    public void testUniquePaths(){
        assertEquals(3, UniquePaths_62.uniquePaths(3,2));
        assertEquals(28, UniquePaths_62.uniquePaths(7,3));
    }

    @Test
    public void testUniquePathsII(){
        int[][] input1 = {{0,0,0}, {0,1,0}, {0,0,0}};
        assertEquals(2, UniquePathsII_63.uniquePathsWithObstacles(input1));
    }

    @Test
    public void testMinimumPath(){
        int[][] input1 = {{1,3,1}, {1,5,1}, {4,2,1}};
        assertEquals(7, MinimumPathSum_64.minPathSum(input1));
    }

    @Test
    public void testValidNumber(){
        assertTrue(ValidNumber_65.isNumber("0"));
        assertTrue(ValidNumber_65.isNumber(" 0.1"));
        assertFalse(ValidNumber_65.isNumber("abc"));
        assertFalse(ValidNumber_65.isNumber("1 a"));
        assertTrue(ValidNumber_65.isNumber("2e10"));
        assertTrue(ValidNumber_65.isNumber(" -90e3  "));
        assertFalse(ValidNumber_65.isNumber(" 1e"));
        assertTrue(ValidNumber_65.isNumber(" 6e-1 "));
        assertFalse(ValidNumber_65.isNumber(" 99e2.5  "));
        assertTrue(ValidNumber_65.isNumber("53.5e93"));
        assertFalse(ValidNumber_65.isNumber(" --6"));
        assertFalse(ValidNumber_65.isNumber("-+3"));
        assertFalse(ValidNumber_65.isNumber("95a54e53"));
        assertFalse(ValidNumber_65.isNumber(" "));
        assertFalse(ValidNumber_65.isNumber(" ."));
        assertTrue(ValidNumber_65.isNumber("3."));
        assertTrue(ValidNumber_65.isNumber("-1"));
        assertTrue(ValidNumber_65.isNumber("+.8"));
    }

    @Test
    public void testPlusOne(){
        assertArrayEquals(new int[]{1,2,4}, PlusOne_66.plusOne(new int[]{1,2,3}));
        assertArrayEquals(new int[]{1,3,0}, PlusOne_66.plusOne(new int[]{1,2,9}));
        assertArrayEquals(new int[]{1,0,0,0}, PlusOne_66.plusOne(new int[]{9,9,9}));
    }

    @Test
    public void testAddBinary(){
        assertEquals("1010", AddBinary_67.addBinary("111", "11"));
        assertEquals("1", AddBinary_67.addBinary("1", "0"));

    }

    @Test
    public void testTextJustification(){
        List<String> test1 = new ArrayList<>();
        String str1 = "hello ik ben m    ";
        String[] words1 = {"hello", "ik", "ben", "m"};
        assertEquals(18, str1.length());
        test1.add("hello ik ben m    ");
        List<String> result1 = TextJustification_68.fullJustify(words1, 18);
        assertEquals(1, result1.size());
        assertEquals(test1.get(0).length(), result1.get(0).length());
        assertEquals(test1.get(0), result1.get(0));


        List<String> test2 = new ArrayList<>();
        String str21 = "This    is    an";
        assertEquals(16, str21.length());
        String str22 = "example  of text";
        assertEquals(16, str22.length());
        String str23 = "justification.  ";
        assertEquals(16, str23.length());
        test2.add(str21);
        test2.add(str22);
        test2.add(str23);
        String[] words2 = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> result2 = TextJustification_68.fullJustify(words2, 16);
        assertEquals(3, result2.size());
        assertEquals(16, result2.get(0).length());
        assertEquals(16, result2.get(1).length());
        assertEquals(16, result2.get(2).length());
        assertEquals(str21, result2.get(0));
        assertEquals(str22, result2.get(1));
        assertEquals(str23, result2.get(2));

        String[] words3 = {"What","must","be","acknowledgment","shall","be"};
        List<String> result3 = TextJustification_68.fullJustify(words3, 16);
        assertEquals(3, result3.size());
        assertEquals(16, result3.get(0).length());
        assertEquals(16, result3.get(1).length());
        assertEquals(16, result3.get(2).length());
        assertEquals("What   must   be", result3.get(0));
        assertEquals("acknowledgment  ", result3.get(1));
        assertEquals("shall be        ", result3.get(2));

    }

    @Test
    public void testSqrt(){
        assertEquals(2, Sqrt_69.mySqrt(4));
        assertEquals(2, Sqrt_69.mySqrt(8));
    }

    @Test
    public void testClimbingStairs(){
        assertEquals(2, ClimbingStairs_70.climbStairs(2));
        assertEquals(3, ClimbingStairs_70.climbStairs(3));
    }

    @Test
    public void testSimplifyPath(){
        assertEquals("/home",SimplifyPath_71.simplifyPath("/home/"));
        assertEquals("/",SimplifyPath_71.simplifyPath("/../"));
        assertEquals("/home/foo",SimplifyPath_71.simplifyPath("/home//foo/"));
        assertEquals("/c",SimplifyPath_71.simplifyPath("/a/./b/../../c/"));
        assertEquals("/c",SimplifyPath_71.simplifyPath("/a/../../b/../c//.//"));
        assertEquals("/a/b/c",SimplifyPath_71.simplifyPath("/a//b////c/d//././/.."));
    }

    @Test
    public void testHardDistance(){
        assertEquals(3, HardDistance_72.minDistance("horse", "ros"));
        assertEquals(5, HardDistance_72.minDistance("intention", "execution"));
    }

    @Test
    public void testSetMatrixZeroes(){
        int[][] matrix1 = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        int[][] result1 = {{0,0,0,0}, {0,4,5,0}, {0,3,1,0}};
        SetMatrixZeroes_73.setZeroes(matrix1);
        for(int i = 0; i < matrix1.length; i++){
            assertArrayEquals(result1[i], matrix1[i]);
        }

        int[][] matrix2 = {{1,0}};
        int[][] result2 = {{0,0}};
        SetMatrixZeroes_73.setZeroes(matrix2);
    }

    @Test
    public void testSearch2DMatrix(){
        int[][] matrix = new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,50}};
        assertTrue( Search2DMatrix_74.searchMatrix(matrix, 1));
        assertTrue( Search2DMatrix_74.searchMatrix(matrix, 3));
        assertTrue( Search2DMatrix_74.searchMatrix(matrix, 5));
        assertTrue( Search2DMatrix_74.searchMatrix(matrix, 7));
        assertTrue( Search2DMatrix_74.searchMatrix(matrix, 10));
        assertTrue( Search2DMatrix_74.searchMatrix(matrix, 11));
        assertTrue( Search2DMatrix_74.searchMatrix(matrix, 16));
        assertTrue( Search2DMatrix_74.searchMatrix(matrix, 20));
        assertTrue( Search2DMatrix_74.searchMatrix(matrix, 23));
        assertTrue( Search2DMatrix_74.searchMatrix(matrix, 30));
        assertTrue( Search2DMatrix_74.searchMatrix(matrix, 34));
        assertTrue( Search2DMatrix_74.searchMatrix(matrix, 50));

        assertFalse(Search2DMatrix_74.searchMatrix(matrix, 2));
        assertFalse(Search2DMatrix_74.searchMatrix(matrix, 8));
        assertFalse(Search2DMatrix_74.searchMatrix(matrix, 15));
        assertFalse(Search2DMatrix_74.searchMatrix(matrix, 21));
        assertFalse(Search2DMatrix_74.searchMatrix(matrix, 33));
        assertFalse(Search2DMatrix_74.searchMatrix(matrix, 100));

        int[][] matrix1 = new int[][]{{1,5,8,9}};
        assertTrue(Search2DMatrix_74.searchMatrix(matrix1, 5));
        assertFalse(Search2DMatrix_74.searchMatrix(matrix1, 10));
        assertFalse(Search2DMatrix_74.searchMatrix(matrix1, 7));

        int[][] matrix3 = new int[][]{{1}, {5}, {9}};
        assertTrue(Search2DMatrix_74.searchMatrix(matrix3, 1));
        assertTrue(Search2DMatrix_74.searchMatrix(matrix3, 5));
        assertTrue(Search2DMatrix_74.searchMatrix(matrix3, 9));

        int[][] matrix2 = {{}};
        assertFalse(Search2DMatrix_74.searchMatrix(matrix2, 1));
    }

    @Test
    public void testSortColors(){
        int[] matrix = new int[]{2,0,2,1,1,0};
        SortColors_75.sortColors(matrix);
        assertArrayEquals(new int[]{0,0,1,1,2,2}, matrix);
    }

    @Test
    public void testMinimumWindowSubstring(){
        assertEquals("BANC", MinimumWindowSubstring_76.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("A", MinimumWindowSubstring_76.minWindow("ABAAA", "A"));
        assertEquals("AA", MinimumWindowSubstring_76.minWindow("AA", "AA"));
        assertEquals("B", MinimumWindowSubstring_76.minWindow("AB", "B"));
        assertEquals("BA", MinimumWindowSubstring_76.minWindow("BBA", "AB"));
    }

    @Test
    public void testCombinations(){
        List<List<Integer>> result1 = Combinations_77.combine(4,2);
        assertEquals(6, result1.size());
    }

    @Test
    public void testSubsets(){
        assertEquals(8, 1<<3);
        assertEquals(1, 1<<0 & 5);

        assertEquals(8, Subsets_78.subsets(new int[]{1,2,3}).size());
        assertEquals(0, Subsets_78.subsets(new int[]{}).size());
        assertEquals(2, Subsets_78.subsets(new int[]{0}).size());
    }

    @Test
    public void testWordSearch(){
        char[][] board1 = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        assertTrue(WordSearch_79.exist(board1,"SEE"));
        assertTrue(WordSearch_79.exist(board1,"ABCCED"));
        assertFalse(WordSearch_79.exist(board1, "ABCB"));
        assertFalse(WordSearch_79.exist(board1, ""));
    }

    @Test
    public void testRemoveDuplicatesII(){
        assertEquals(5, RemoveDuplicatesSortedArrayII_80.removeDuplicates(new int[]{1,1,1,2,2,3}));
        assertEquals(5, RemoveDuplicatesSortedArrayII_80.removeDuplicates(new int[]{1,1,2,2,3}));
        assertEquals(0, RemoveDuplicatesSortedArrayII_80.removeDuplicates(new int[]{}));
        assertEquals(7, RemoveDuplicatesSortedArrayII_80.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }

    @Test
    public void testScrambleString(){
        assertTrue(ScrambleString_87.isScramble("rgeat", "great"));
        assertFalse(ScrambleString_87.isScramble("abcde", "caebd"));
        assertTrue(ScrambleString_87.isScramble("abb", "bba"));
    }

    @Test
    public void testMergeSortedArrays(){
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        MergeSortedArrays_88.merge(nums1, 3, nums2,3);

        assertArrayEquals(new int[]{1,2,2,3,5,6},nums1);

        nums1 = new int[]{1,2,3,0,0,0};
        int[] nums3 = new int[]{};
        MergeSortedArrays_88.merge(nums1, 3, nums3,0);
        assertArrayEquals(new int[]{1,2,3,0,0,0}, nums1);
    }

    @Test
    public void testGrayCode(){
       GrayCode_89.grayCode(2);
    }

    @Test
    public void testBinaryTreeInorderTraversal(){
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(6);
        node.right = new TreeNode(3);


        List<Integer> result = new ArrayList<>();
        result.add(5);
        result.add(2);
        result.add(6);
        result.add(1);
        result.add(3);
        List<Integer> inOrder = BinaryTreeInorderTraversal_94.inorderTraversal(node);
        assertEquals(result.size(), inOrder.size());
        for(int i = 0; i < result.size(); i++){
            assertEquals(result.get(i), inOrder.get(i));
        }

        assertEquals(0, BinaryTreeInorderTraversal_94.inorderTraversal(null).size());
    }

    @Test
    public void testUniqueBinarySearchTreesII(){
        assertEquals(5, UniqueBinarySearchTreesII_95.generateTrees(3).size());
        assertEquals(1, UniqueBinarySearchTreesII_95.generateTrees(1).size());
        assertEquals(0, UniqueBinarySearchTreesII_95.generateTrees(0).size());
    }

    @Test
    public void testUniqueBinarySearchTrees(){
        assertEquals(5, UniqueBinarySearchTrees_96.numTrees(3));
        assertEquals(1, UniqueBinarySearchTrees_96.numTrees(1));
        assertEquals(0, UniqueBinarySearchTrees_96.numTrees(0));
    }

    @Test
    public void testIsValidBinarySearchTree(){

        ValidateBinarySearchTree_98 bin = new ValidateBinarySearchTree_98();


        TreeNode node = new TreeNode(2);
        assertTrue(bin.isValidBST(node));
        node.left = new TreeNode(1);


        assertTrue(bin.isValidBST(node));

        node.right = new TreeNode(3);
        assertTrue(bin.isValidBST(node));

        TreeNode node1 = new TreeNode(5);
        node1.left = new TreeNode(1);
        assertTrue(bin.isValidBST(node1));
        node1.right = new TreeNode(4);
        node1.right.left = new TreeNode(3);
        node1.right.right = new TreeNode(6);
        assertFalse(bin.isValidBST(node1));

        TreeNode node2 = new TreeNode(10);
        node2.left = new TreeNode(5);
        node2.right = new TreeNode(15);
        node2.right.left = new TreeNode(6);
        node2.right.right = new TreeNode(20);
        assertFalse(bin.isValidBST(node2));

        TreeNode node3 = new TreeNode(Integer.MIN_VALUE);
        assertTrue(bin.isValidBST(node3));

    }

    @Test
    public void testSubsetII(){
        SubsetsII_90 subset = new SubsetsII_90();
        List<List<Integer>> result = subset.subsetsWithDup(new int[]{2,1,1});
        assertEquals(6, result.size());
    }

    @Test
    public void testDecodeWays(){
        DecodeWays_91 decode = new DecodeWays_91();
        assertEquals(2, decode.numDecodings("12"));
        assertEquals(1, decode.numDecodings("29"));
        assertEquals(1, decode.numDecodings("92"));
        assertEquals(3, decode.numDecodings("226"));
        assertEquals(0, decode.numDecodings("0"));
        assertEquals(1, decode.numDecodings("10"));
        assertEquals(0, decode.numDecodings("100"));
        assertEquals(0, decode.numDecodings("012"));
        assertEquals(5, decode.numDecodings("1212"));
    }

    @Test
    public void testLinkedList(){
        ReverseLinkedListII_92 reverse = new ReverseLinkedListII_92();
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        test.next.next.next.next = new ListNode(5);


        ListNode res1 = reverse.reverseBetween(test, 2, 4);
        assertEquals(1, res1.val);
        assertEquals(4, res1.next.val);
        assertEquals(3, res1.next.next.val);
        assertEquals(2, res1.next.next.next.val);
        assertEquals(5, res1.next.next.next.next.val);
        assertEquals(null, res1.next.next.next.next.next);


        test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        test.next.next.next.next = new ListNode(5);
        res1 = reverse.reverseBetween(test, 1, 4);
        assertEquals(4, res1.val);
        assertEquals(3, res1.next.val);
        assertEquals(2, res1.next.next.val);
        assertEquals(1, res1.next.next.next.val);
        assertEquals(5, res1.next.next.next.next.val);
        assertEquals(null, res1.next.next.next.next.next);


        test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        test.next.next.next.next = new ListNode(5);
        res1 = reverse.reverseBetween(test, 1, 5);
        assertEquals(5, res1.val);
        assertEquals(4, res1.next.val);
        assertEquals(3, res1.next.next.val);
        assertEquals(2, res1.next.next.next.val);
        assertEquals(1, res1.next.next.next.next.val);
        assertEquals(null, res1.next.next.next.next.next);

    }

    @Test
    public void testSameTree(){
        SameTree_100 tree = new SameTree_100();
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);

        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        node2.right = new TreeNode(3);

        assertTrue(tree.isSameTree(node1, node2));

        node2.right.val = 4;
        assertFalse(tree.isSameTree(node1, node2));

        TreeNode node3 = new TreeNode(1);
        node3.left = new TreeNode(2);

        TreeNode node4 = new TreeNode(1);
        node4.right = new TreeNode(2);
        assertFalse(tree.isSameTree(node3, node4));

        node3.right = new TreeNode(1);
        node4.left = new TreeNode(1);
        assertFalse(tree.isSameTree(node3, node4));
    }


}

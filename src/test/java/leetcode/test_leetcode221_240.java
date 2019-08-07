package leetcode;

import leetcode.leetcode221_240.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test_leetcode221_240 {

    @Test
    public void testCountCompleteTreeNodes(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        assertEquals(6, CountCompleteTreeNodes_222.countNodes(root));
        assertEquals(2, CountCompleteTreeNodes_222.countNodes(root.right));
        assertEquals(1, CountCompleteTreeNodes_222.countNodes(root.right.left));
    }

    @Test
    public void testInvertBinaryTree(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        InvertBinaryTree_226.invertTree(root);

        assertEquals(4, root.val);
        assertEquals(7, root.left.val);
        assertEquals(9, root.left.left.val);
        assertEquals(6, root.left.right.val);
        assertEquals(2, root.right.val);
        assertEquals(3, root.right.left.val);
        assertEquals(1, root.right.right.val);

    }

    @Test
    public void testBasicCalculator(){
        assertEquals(22, BasicCalculator_224.calculate("11+11"));
        assertEquals(100, BasicCalculator_224.calculate("134 - 34"));
        assertEquals(11, BasicCalculator_224.calculate("11"));
        assertEquals(-11, BasicCalculator_224.calculate("-11"));
        assertEquals(3, BasicCalculator_224.calculate("2-1+2"));

        assertEquals(110, BasicCalculator_224.calculate("10+(134 - 34)"));
        assertEquals(23, BasicCalculator_224.calculate("(1+(4+5+2)-3)+(6+8)"));

        assertEquals(-4, BasicCalculator_224.calculate("1-(5)"));
    }

    @Test
    public void testBasicCalculatorII(){
        assertEquals(8, BasicCalculatorII_227.calculate("1+3+4"));

        assertEquals(7, BasicCalculatorII_227.calculate("3+2*2"));
        assertEquals(1, BasicCalculatorII_227.calculate("3/2"));
        assertEquals(1, BasicCalculatorII_227.calculate(" 3/ 2"));
        assertEquals(5, BasicCalculatorII_227.calculate(" 3+5/2"));
    }

    @Test
    public void testSummaryRanges(){
        SummaryRanges_228 range = new SummaryRanges_228();
        assertEquals(3, range.summaryRanges(new int[]{0,1,2,4,5,7}).size());
        assertEquals(4, range.summaryRanges(new int[]{0,2,3,4,6,8,9}).size());
        assertEquals(0, range.summaryRanges(new int[]{}).size());
        assertEquals(1, range.summaryRanges(new int[]{1}).size());
    }

    @Test
    public void testkThSmallestElementBST(){
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.left.left.left = new TreeNode(1);
        KThSmallestElementBST_230 kth = new KThSmallestElementBST_230();
        assertEquals(1, kth.kthSmallest(node, 1));
        assertEquals(2, kth.kthSmallest(node, 2));
        assertEquals(3, kth.kthSmallest(node, 3));
        assertEquals(4, kth.kthSmallest(node, 4));
        assertEquals(5, kth.kthSmallest(node, 5));
        assertEquals(6, kth.kthSmallest(node, 6));

    }
}

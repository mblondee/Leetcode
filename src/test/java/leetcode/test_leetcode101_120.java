package leetcode;

import leetcode.leetcode101_120.BinaryTreeLevelOrderTraversal_102;
import leetcode.leetcode101_120.BinaryTreeZigZagLevelOrderTraversal_103;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class test_leetcode101_120 {

    @Test
    public void testBinaryTreeLevelOrderTraversal(){
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        List<List<Integer>> result = BinaryTreeLevelOrderTraversal_102.levelOrder(node);
        assertEquals(3, result.size());
    }

    @Test
    public void testBinaryTreeZigzagLevelOrderTraversal(){
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        List<List<Integer>> result = BinaryTreeZigZagLevelOrderTraversal_103.zigzagLevelOrder(node);
        assertEquals(3, result.size());


        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);
        node1.right.right = new TreeNode(5);

        List<List<Integer>> result1 = BinaryTreeZigZagLevelOrderTraversal_103.zigzagLevelOrder(node1);
        assertEquals(3, result1.size());
    }


}

package leetcode;

import leetcode.leetcode101_120.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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

    @Test
    public void testPathSum(){
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);

        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);

        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);

        node.right.right.right = new TreeNode(1);

        PathSum_112 path = new PathSum_112();
        assertTrue(path.hasPathSum(node, 22));
    }

    @Test
    public void testPathSumII(){
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);

        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);

        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);

        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(1);

        PathSumII_113 path = new PathSumII_113();
        assertEquals(2, path.pathSum(node,22 ).size());

    }

    @Test
    public void testSymmetricTree(){
        SymmetricTree_101 symm = new SymmetricTree_101();

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);

        assertTrue(symm.isSymmetric(node));

        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(2);
        node1.left.left = new TreeNode(3);
        node1.right.left = new TreeNode(3);

        assertFalse(symm.isSymmetric(node1));

        assertTrue(symm.symm(node));
        assertFalse(symm.symm(node1));

        node1 = new TreeNode(1);
        assertTrue(symm.symm(node1));
        node1.right = new TreeNode(2);
        assertFalse(symm.symm(node1));


        node1.left = new TreeNode(2);
        node1.left.left = new TreeNode(2);
        node1.right.left = new TreeNode(2);
        assertFalse(symm.symm(node1));

    }


}

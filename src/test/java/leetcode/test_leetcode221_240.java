package leetcode;

import leetcode.leetcode221_240.CountCompleteTreeNodes_222;
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
}

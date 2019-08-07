package leetcode;

import leetcode.leetcode781_800.MinimumDistanceBetweenBSTNodes_783;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test_leetcode781_800 {

    @Test
    public void testMinDistanceBetweenBSTNodes(){
        MinimumDistanceBetweenBSTNodes_783 minDist = new MinimumDistanceBetweenBSTNodes_783();
        TreeNode node = new TreeNode(4);
        assertEquals(0, minDist.minDiffInBST(node));
        node.left = new TreeNode(2);
        node.right = new TreeNode(6);
        assertEquals(2, minDist.minDiffInBST(node));
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        assertEquals(1, minDist.minDiffInBST(node));

        TreeNode node1 = new TreeNode(27);
        node1.right = new TreeNode(34);
        node1.right.right = new TreeNode(58);
        node1.right.right.left = new TreeNode(50);
        node1.right.right.left.left = new TreeNode(44);
        assertEquals(6, minDist.minDiffInBST(node1));
    }
}

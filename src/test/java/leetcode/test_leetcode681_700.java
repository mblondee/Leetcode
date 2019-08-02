package leetcode;

import leetcode.leetcode681_700.LongestUnivaluePath_687;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test_leetcode681_700 {

    @Test
    public void testLongestUnivaluePath(){
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);

        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(1);

        node.right.right = new TreeNode(5);

        LongestUnivaluePath_687 path = new LongestUnivaluePath_687();
        assertEquals(2, path.longestUnivaluePath(node));

        node.val = 1;
        node.left.left.val = 4;
        node.left.right.val = 4;

        assertEquals(1, path.longestUnivaluePath(node));

    }
}

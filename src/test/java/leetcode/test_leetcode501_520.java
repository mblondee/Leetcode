package leetcode;

import leetcode.leetcode501_520.FindBottomLeftTreeValue_513;
import leetcode.leetcode501_520.FindModeInBinarySearchTree_501;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class test_leetcode501_520 {

    @Test
    public void testFindBottomLeftTreeValue(){
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        FindBottomLeftTreeValue_513 find = new FindBottomLeftTreeValue_513();
        assertEquals(1, find.findBottomLeftValue(node));


        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);
        node1.right.left = new TreeNode(5);
        node1.right.right = new TreeNode(6);
        node1.right.left.left = new TreeNode(7);


        FindBottomLeftTreeValue_513 find1 = new FindBottomLeftTreeValue_513();
        assertEquals(7, find1.findBottomLeftValue(node1));

        TreeNode node2 = new TreeNode(0);
        node2.right = new TreeNode(-1);

        FindBottomLeftTreeValue_513 find2 = new FindBottomLeftTreeValue_513();
        assertEquals(-1, find2.findBottomLeftValue(node2));
    }

    @Test
    public void testFindModeInBinarySearchTree(){
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(3);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(3);
        node.left.left.left = new TreeNode(2);
        node.left.left.right = new TreeNode(3);

        FindModeInBinarySearchTree_501 find = new FindModeInBinarySearchTree_501();
        int[] res = find.findMode(node);
        assertEquals(1, res.length);
        assertEquals(3, res[0]);
    }
}

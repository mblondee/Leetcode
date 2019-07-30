package leetcode.leetcode221_240;

/*Invert a binary tree.*/

import leetcode.TreeNode;

public class InvertBinaryTree_226 {
    public static TreeNode invertTree(TreeNode root) {
        // lazy or
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }

        TreeNode newLeft = invertTree(root.right);
        TreeNode newRight = invertTree(root.left);

        root.left = newLeft;
        root.right = newRight;



        return root;

    }
}

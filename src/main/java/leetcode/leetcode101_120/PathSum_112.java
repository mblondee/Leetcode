package leetcode.leetcode101_120;

/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf
        path such that adding up all the values along the path equals the given sum.

        Note: A leaf is a node with no children.
*/

import leetcode.TreeNode;

public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(0, root, sum);
    }

    private boolean helper(int currentSum, TreeNode node, int sum){
        if(node == null){
            return false;
        }
        if(node.left == null && node.right == null){
            // leaf node
            return currentSum + node.val == sum;
        }

        if(helper(currentSum + node.val, node.left, sum)){
            return true;
        }
        else {
            return helper(currentSum + node.val, node.right, sum);
        }

    }
}

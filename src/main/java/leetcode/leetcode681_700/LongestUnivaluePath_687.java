package leetcode.leetcode681_700;

/*Given a binary tree, find the length of the longest path where each node in the path
        has the same value. This path may or may not pass through the root.

        The length of path between two nodes is represented by the number of edges between them.*/

import leetcode.TreeNode;

public class LongestUnivaluePath_687 {

    int longestLength;

    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        longestLength = 0;
        longestPathFrom(root);
        return longestLength;
    }

    // returns the longest path that starts at node
    // everytime we update longestlength when necessary,
    // when updating we also take into consideration going across over the node left-node-right
    private int longestPathFrom(TreeNode node){
        // longest path starting from node.left
        int leftTree = node.left == null ? 0 : longestPathFrom(node.left);
        // longest path starting from node.right
        int rightTree = node.right == null ? 0 : longestPathFrom(node.right);
        // longest path starting from node going left
        int leftFromNode = node.left != null && node.left.val == node.val ? 1 + leftTree : 0;
        // longest path starting from node going right
        int rightFromNode = node.right != null && node.right.val == node.val ? 1 + rightTree : 0;
        // longest path across node
        longestLength = Math.max(longestLength, leftFromNode + rightFromNode);
        return Math.max(leftFromNode,rightFromNode);
    }
}

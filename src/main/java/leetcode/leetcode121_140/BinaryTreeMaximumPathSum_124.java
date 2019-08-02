package leetcode.leetcode121_140;

/*Given a non-empty binary tree, find the maximum path sum.

        For this problem, a path is defined as any sequence of nodes
        from some starting node to any node in the tree along the parent-child connections.
        The path must contain at least one node and does not need to go through the root.*/

import leetcode.TreeNode;

public class BinaryTreeMaximumPathSum_124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        maxSum = Integer.MIN_VALUE;
        maxInPath(root);
        return maxSum;
    }

    // find max in the subtree starting at node
    // we update maxSum whenever we find a larger sum
    private int maxInPath(TreeNode node){
        // max in left sub tree
        int leftTree = node.left != null ? maxInPath(node.left) + node.val : node.val;
        // max in right sub tree
        int rightTree = node.right != null ? maxInPath(node.right) + node.val : node.val;
        // max is either
        // only node
        // left sub tree,
        // right sub tree or
        // across from node
        int maxStarting = Math.max(node.val, Math.max(leftTree, rightTree));
        int max = Math.max(maxStarting, leftTree + rightTree - node.val); // across -> have to subtract once node.val
        // because it has been counted twice in leftTree and rightTree
        maxSum = Math.max(maxSum, max);
        // we return max starting at node (so not across)
        return maxStarting;
    }

}

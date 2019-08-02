package leetcode.leetcode121_140;

/*Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

        An example is the root-to-leaf path 1->2->3 which represents the number 123.

        Find the total sum of all root-to-leaf numbers.

        Note: A leaf is a node with no children.*/

import leetcode.TreeNode;

public class SumRootToLeafNumbers_129 {
    int sum;

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        sum = 0;
        helper(root, 0);
        return sum;
    }


    // returns sum of all paths in subtree starting in node
    private void helper(TreeNode node, int currentSum){
        if(node == null){
            return;
        }

        // we have encountered a leaf
        if(node.left == null && node.right == null){
            sum+= 10*currentSum + node.val;
            return;
        }

        // try left and add current val at the end of the currentSum
        helper(node.left, 10*currentSum + node.val);
        // try right and add current val at the end of the currentSum
        helper(node.right, 10*currentSum + node.val);

    }
}

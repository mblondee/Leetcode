package leetcode.leetcode781_800;

/*Given a Binary Search Tree (BST) with the root node root,
        return the minimum difference between the values of any two different nodes in the tree.*/

import leetcode.TreeNode;

import java.util.Stack;

public class MinimumDistanceBetweenBSTNodes_783 {
    public int minDiffInBST(TreeNode root) {
        // inorder traversal

        Integer prevVal = null;
        int minDistance = Integer.MAX_VALUE;

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        while(current != null || !stack.empty()){
            // go as far left as possible
            while(current != null){
                stack.push(current);
                current = current.left;
            }

            // current is now null
            // smallest value is now on top of stack
            current = stack.pop();

            // initialize prevVal
            if(prevVal == null){
                prevVal = current.val;
            }
            //update minDistance
            else if(current.val - prevVal < minDistance){
                minDistance = current.val - prevVal;
            }

            prevVal = current.val;
            current = current.right;
        }

        // only one node
        if(minDistance == Integer.MAX_VALUE){
            return 0;
        }
        return minDistance;

    }
}

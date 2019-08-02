package leetcode.leetcode81_100;

/*Given a binary tree, determine if it is a valid binary search tree (BST).

        Assume a BST is defined as follows:

        The left subtree of a node contains only nodes with keys less than the node's key.
        The right subtree of a node contains only nodes with keys greater than the node's key.
        Both the left and right subtrees must also be binary search trees.*/

import leetcode.TreeNode;

import java.util.Stack;

public class ValidateBinarySearchTree_98 {
    public boolean isValidBST(TreeNode root) {
        // in order traversal should be ordered from smaller to greater
        // in order: left-root-right

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        // the in order traversal should start with the smallest
        Integer previousVal = null;

        while(current != null || !stack.empty()){

            // go to the left as far as possible
            while(current!= null) {
                stack.push(current);
                current = current.left;
            }

            // current is now null (left of leftmost node)
            // we go back up by popping the stack
            // this is current left most element

            current = stack.pop();

            // it should be greater than last value that we checked
            int currentVal = current.val;
            if(previousVal == null){
                previousVal = currentVal;
            }
            else if(currentVal <= previousVal){
                return false;
            }
            else{
                previousVal = currentVal;
            }
            // we go to the right (right of leftmost node)
            current = current.right;


        }
        return true;


    }
}

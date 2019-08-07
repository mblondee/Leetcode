package leetcode.leetcode221_240;

/*Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

        Note:
        You may assume k is always valid, 1 ≤ k ≤ BST's total elements.*/

import leetcode.TreeNode;

import java.util.Stack;

public class KThSmallestElementBST_230 {
    public int kthSmallest(TreeNode root, int k) {

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;


        while(current != null || ! stack.empty()){

            while(current!= null) {
                // go as far left as possible
                stack.push(current);
                current = current.left;
            }

            // current is now null, the current smallest element is on top of the stack
            current = stack.pop();
            if(++count == k){
                return current.val;
            }

            current = current.right;
        }

        return -1;

    }
}

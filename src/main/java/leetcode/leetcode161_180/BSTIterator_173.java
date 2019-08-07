package leetcode.leetcode161_180;

/*Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

        Calling next() will return the next smallest number in the BST.*/

import leetcode.TreeNode;

import java.util.Stack;

public class BSTIterator_173 {

    private Stack<TreeNode> stack;
    private TreeNode current;

    public BSTIterator_173(TreeNode root) {
        this.current = root;
        this.stack = new Stack<>();

    }

    /** @return the next smallest number */
    public int next() {
        // go as left most as possible
        while(current != null){
            stack.push(current);
            current = current.left;
        }

        // current should now be null
        // we go back to middle node
        current = stack.pop();
        int next = current.val;

        // next is right node
        current = current.right;





        return next;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

        return current != null || ! stack.empty();
    }
}

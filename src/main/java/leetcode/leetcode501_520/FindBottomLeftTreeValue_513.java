package leetcode.leetcode501_520;

/*Given a binary tree, find the leftmost value in the last row of the tree.*/

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue_513 {

    public int findBottomLeftValue(TreeNode root) {
        // idea: add all nodes to a queue (first right child, then left child)
        // last node in the queue will be the most left
        if(root == null){
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode current = null;
        while(! queue.isEmpty()){
            current = queue.remove();
            if(current.right != null){
                queue.add(current.right);
            }
            if(current.left != null){
                queue.add(current.left);
            }
        }
        return current.val;
    }

/*    private int currentMaxLevel;
    private int currentLeftMost;

    public int findBottomLeftValue(TreeNode root) {
        if(root == null){ // will not happen in question
            return -1;
        }

        currentLeftMost = root.val;
        currentMaxLevel = 0;

        if(root.left != null || root.right != null) {
            helper(root, 1);
        }

        return currentLeftMost;
    }

    private void helper(TreeNode prevNode, int nextLevel){
        if(prevNode.left != null && nextLevel > currentMaxLevel){
            currentLeftMost = prevNode.left.val;
            currentMaxLevel = nextLevel;
        }

        if(prevNode.left != null){
            helper(prevNode.left, nextLevel+1);
        }

        if(prevNode.right != null){
            helper(prevNode.right, nextLevel+1);
        }
    }*/
}

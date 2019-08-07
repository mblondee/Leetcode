package leetcode.leetcode141_160;

/*Given a binary tree, return the preorder traversal of its nodes' values.*/

// root - left - right

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal_144 {

    // iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        stack.push(current);

        while(!stack.empty()){
            current = stack.pop();
            result.add(current.val);
            // right needs to be done at the end
            if(current.right != null){
                stack.push(current.right);
            }
            if(current.left != null){
                stack.push(current.left);
            }

        }

        return result;

    }

    // recursive
    public List<Integer> preorderTraversalrec(TreeNode root) {
        return helper(root);
    }

    private List<Integer> helper(TreeNode node){
        if(node == null){
            return new ArrayList<>();
        }

        List<Integer> left = helper(node.left);
        List<Integer> right = helper(node.right);
        List<Integer> result = new ArrayList<>();
        result.add(node.val);
        for(int l : left){
            result.add(l);
        }
        for(int r : right){
            result.add(r);
        }

        return result;
    }
}

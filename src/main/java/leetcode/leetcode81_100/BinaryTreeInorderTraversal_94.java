package leetcode.leetcode81_100;

/*Given a binary tree, return the inorder traversal of its nodes' values.*/

//left - root - right

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {

    //iterative solution
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while(current != null || !stack.empty()){

            // try to go to the left as far as possible
            while(current != null){
                stack.push(current);
                current = current.left;
            }

            // there are no more left -> we go back up (pop stack)
            // and then we go right
            // and start again
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }


        return result;

    }


    // recursive solution
    public static List<Integer> inorderTraversal_rec(TreeNode root) {

        return helper(root);

    }

    private static List<Integer> helper(TreeNode node){
        if(node == null){
            return new ArrayList();
        }

        List<Integer> left = helper(node.left);
        List<Integer> right = helper(node.right);

        List<Integer> result = new ArrayList<>();
        for(int i: left){
            result.add(i);
        }
        result.add(node.val);
        for(int i: right){
            result.add(i);
        }
        return result;
    }
}

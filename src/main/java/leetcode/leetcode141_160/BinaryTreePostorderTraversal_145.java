package leetcode.leetcode141_160;

/*Given a binary tree, return the postorder traversal of its nodes' values.*/
// left right root

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal_145 {

    // iterative version
    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();

        if(root == null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);


        while(! stack.empty()){
            TreeNode current = stack.pop();


            if(current.left != null) {
                stack.push(current.left);
            }
            if(current.right != null) {
                stack.push(current.right);
            }

            // current.val has to be after left and right in the result
            // we always add values at the beginning: so before we add first left and then right to the stack
            // then right.val will be added, and then left.val will be added before right.val
            // so left - right - middle
            result.addFirst(current.val);

        }







        return result;
    }

    // recursive version
    public static List<Integer> postorderTraversalrec(TreeNode root) {
        return helper(root);

    }

    private static List<Integer> helper(TreeNode node){
        if(node == null){
            return new ArrayList<>();
        }
        List<Integer> left = helper(node.left);
        List<Integer> right = helper(node.right);
        List<Integer> result = new ArrayList<>();
        for(int leftval : left){
            result.add(leftval);
        }
        for(int rightval : right){
            result.add(rightval);
        }
        result.add(node.val);

        return result;

    }
}

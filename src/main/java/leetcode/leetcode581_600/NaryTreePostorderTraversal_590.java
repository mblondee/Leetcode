package leetcode.leetcode581_600;

/*Given an n-ary tree, return the postorder traversal of its nodes' values.*/

// left right node

import leetcode.Node;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NaryTreePostorderTraversal_590 {

    public static List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null){
            return result;
        }

        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while(! stack.empty()){
            Node current = stack.pop();

            if(current.children != null){
                for(Node child : current.children){
                    stack.push(child);
                }
            }

            result.addFirst(current.val);
        }
        return result;




    }
}

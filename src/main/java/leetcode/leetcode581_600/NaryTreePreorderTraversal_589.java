package leetcode.leetcode581_600;

/*Given an n-ary tree, return the preorder traversal of its nodes' values.*/

// node - left child - right child

import leetcode.Node;

import java.util.*;

public class NaryTreePreorderTraversal_589 {
    public static List<Integer> preorder(Node root) {

        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);


        while(! stack.isEmpty()){
            Node current = stack.pop();

            if(current.children != null){
                // add in reverse order
                for(int i = current.children.size() -1; i >=0; i--){
                    stack.push(current.children.get(i));
                }
            }
            result.add(current.val);
        }
        return result;

    }
}

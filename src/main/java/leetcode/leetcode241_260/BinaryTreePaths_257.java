package leetcode.leetcode241_260;
/*
Given a binary tree, return all root-to-leaf paths.

        Note: A leaf is a node with no children.*/

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        helper(result, root, new ArrayList<>());

        return result;

    }

    private void helper(List<String> result, TreeNode node, List<Integer> temp){
        if(node.left == null && node.right == null){
            temp.add(node.val);
            result.add(listToString(temp));
            return;
        }


        //node has at least one child
        temp.add(node.val);

        if(node.left != null) {
            helper(result, node.left, temp);
            temp.remove(temp.size()-1);
        }

        if(node.right != null){
            helper(result, node.right, temp);
            temp.remove(temp.size()-1);
        }


    }

    private String listToString(List<Integer> temp){
        StringBuffer str = new StringBuffer();

        int i = 0;

        while(i < temp.size() -1){
            str.append(temp.get(i));
            str.append("->");
            i++;
        }

        str.append(temp.get(temp.size()-1));

        return str.toString();
    }
}

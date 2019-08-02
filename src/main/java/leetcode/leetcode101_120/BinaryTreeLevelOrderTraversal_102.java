package leetcode.leetcode101_120;

/*Given a binary tree, return the level order traversal of its nodes' values.
        (ie, from left to right, level by level).*/


import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }

    private static void helper(TreeNode node, int level, List<List<Integer>> result){
        if(node == null){
            return;
        }
        // have we encountered this level already?
        List<Integer> thisLevel;
        if(result.size() == level){
            thisLevel = new ArrayList<>();
            result.add(thisLevel);
        }
        else{
            thisLevel = result.get(level);
        }

        thisLevel.add(node.val);

        helper(node.left, level+1, result);
        helper(node.right, level+1, result);

    }
}

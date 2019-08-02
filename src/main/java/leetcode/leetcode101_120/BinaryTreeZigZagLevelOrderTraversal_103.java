package leetcode.leetcode101_120;

/*Given a binary tree, return the zigzag level order traversal of its nodes' values.
        (ie, from left to right, then right to left for the next level and
        alternate between).*/

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreeZigZagLevelOrderTraversal_103 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        helper(result, root, false, 0);


        return result;
    }

    private static void helper(List<List<Integer>> result, TreeNode node, boolean leftToRight, int level){
        if(node == null){
            return;
        }

        LinkedList<Integer> thisLevel;
        // have we visited the level already?
        if(result.size() == level){
            thisLevel = new LinkedList<>();
            result.add(thisLevel);
        }
        else{
            thisLevel = (LinkedList) result.get(level);
        }

        if(leftToRight) {
            thisLevel.addFirst(node.val);
        }
        else{
            thisLevel.add(node.val);
        }


        helper(result, node.left, !leftToRight, level+1);
        helper(result, node.right, !leftToRight, level+1);

    }


}

package leetcode.leetcode421_440;
/*
Given an n-ary tree, return the level order traversal of
        its nodes' values. (ie, from left to right, level by level).*/

import leetcode.Node;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeLevelOrderTraversal_429 {
    public static List<List<Integer>> levelOrder(Node root) {
        return helper(root, 0, new ArrayList<>());


    }

    private static List<List<Integer>> helper(Node node, int level, List<List<Integer>> result){
        if(node == null){
            return result;
        }
        // list that contains the nodes on this level
        List<Integer> thisLevel;
        // if we haven't visited any node yet on this level
        if(result.size() == level){
            thisLevel = new ArrayList<>();
            result.add(thisLevel);
        }
        else{
            thisLevel = result.get(level);
        }

        thisLevel.add(node.val);
        for(Node child: node.children){
            helper(child, level+1, result);
        }

        return result;


    }
}

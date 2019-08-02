package leetcode.leetcode101_120;

/*Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

        Note: A leaf is a node with no children.*/

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, new ArrayList(), sum, 0);
        return result;
    }
    private void helper(TreeNode node, List<List<Integer>> result, List<Integer> temp, int sum, int tempSum){
        if(node == null){
            return;
        }

        // add value of current node
        temp.add(node.val);

        if(node.left == null && node.right == null){
            if(tempSum + node.val == sum) {
                result.add(new ArrayList<>(temp));
            }
            temp.remove(temp.size()-1);
            return;
        }


        helper(node.left, result, temp, sum, tempSum + node.val);
        helper(node.right, result, temp, sum, tempSum + node.val);
        temp.remove(temp.size()-1);

    }
}

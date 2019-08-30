package leetcode.leetcode501_520;

/*Given a binary search tree (BST) with duplicates,
        find all the mode(s) (the most frequently occurred element) in the given BST.

        Assume a BST is defined as follows:

        The left subtree of a node contains only nodes with keys less than or equal to the node's key.
        The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
        Both the left and right subtrees must also be binary search trees.*/

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class FindModeInBinarySearchTree_501{

    private int max = 0;
    private Integer previous = null;
    private int count = 0;

    public int[] findMode(TreeNode root) {
        if(root == null){
            return new int[0];
        }

        max = 0;
        List<Integer> lst = new ArrayList<>();
        helper(root, lst);

        int[] result = new int[lst.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = lst.get(i);
        }
        return result;
    }

    private void helper(TreeNode node, List<Integer> lst){

        // we go as far left as possible and put previous equal to node value
        // then we go back up and check if it is still the same value
        // and the we go right to check if it is still the same value and repeat the same process
        // because it is a BST same values will be together
        if(node.left != null){
            helper(node.left, lst);
        }
        if(previous != null && node.val == previous){
            count++; // we see the same value as previous one
        }
        else{
            count = 1; // we see a new value
        }

        //update max
        if(max < count){
            max = count;
            // remove old elements in lst
            lst.clear();
            lst.add(node.val);
        }
        else if(max == count){
            lst.add(node.val);
        }

        // maybe necessary to update previous
        previous = node.val;

        if(node.right != null){
            helper(node.right, lst);
        }




    }
}

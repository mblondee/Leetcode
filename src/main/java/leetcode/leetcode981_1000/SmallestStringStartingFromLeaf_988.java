package leetcode.leetcode981_1000;

/*
Given the root of a binary tree, each node has a value from 0 to 25 representing
        the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.

        Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

        (As a reminder, any shorter prefix of a string is lexicographically smaller:
        for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)*/

import leetcode.TreeNode;

public class SmallestStringStartingFromLeaf_988 {
    private String minString;

    public String smallestFromLeaf(TreeNode root) {
        minString = null;
        if(root == null){
            return "";
        }

        smallestHelper(root, new StringBuilder());

        return minString;

    }

    private void smallestHelper(TreeNode node, StringBuilder current){
        if(node.left == null && node.right == null){
            // node is a leaf
            // there is only one path available
            char currentchar = (char) (node.val + 'a');
            current.insert(0,currentchar);
            if(minString == null || current.toString().compareTo(minString) < 0){
                minString = current.toString();
            }
            return;
        }

        char currentchar = (char) (node.val + 'a');
        current.insert(0,currentchar);

        if(node.left != null){
            smallestHelper(node.left, current);
            current.deleteCharAt(0);
        }

        if(node.right != null){
            smallestHelper(node.right,current);
            current.deleteCharAt(0);
        }
    }
}

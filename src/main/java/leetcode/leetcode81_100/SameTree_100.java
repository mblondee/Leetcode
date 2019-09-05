package leetcode.leetcode81_100;

/*Given two binary trees, write a function to check if they are the same or not.

        Two binary trees are considered the same if they are structurally identical
        and the nodes have the same value.*/

import leetcode.TreeNode;

public class SameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        else if(p == null || q == null){
            return false;
        }
        else if(p.val != q.val){
            return false;
        }
        else{
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}

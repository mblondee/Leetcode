package leetcode.leetcode221_240;

/*Given a complete binary tree, count the number of nodes.
*
* In a complete binary tree every level, except possibly the last,
* is completely filled, and all nodes in the last level are as far left as possible.
* It can have between 1 and 2h nodes inclusive at the last level h.*/

// since it is a complete binary tree, the space complexity will be at most O(log n)
// since height is log n

import leetcode.TreeNode;

public class CountCompleteTreeNodes_222 {

    public static int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }

    }
}

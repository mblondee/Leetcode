package leetcode.leetcode421_440;

/*

You are given a binary tree in which each node contains an integer value.

        Find the number of paths that sum to a given value.

        The path does not need to start or end at the root or a leaf,
        but it must go downwards (traveling only from parent nodes to child nodes).

        The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
*/

// for every node pathSumFrom checks all nodes below it, aka O(height)
// worst case O(n*n), height O(n)
// best case O(n log n), height O(log n)

import leetcode.TreeNode;

public class PathSumIII_437 {
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        // #valid paths = #(valid paths containing root) + #(valid paths not containing root)
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);

    }

    // all paths summing to sum starting from and including a certain node
    private int pathSumFrom(TreeNode node, int sum){
        if(node == null){
            return 0;
        }
        if(node.val == sum){
            // if the val in node is equal to sum we have found a path (node only)
            // and we check if we can add more nodes to the left and the right
            return 1 + pathSumFrom(node.left, sum-node.val) + pathSumFrom(node.right, sum-node.val);
        }
        else{
            return pathSumFrom(node.left, sum-node.val) + pathSumFrom(node.right, sum-node.val);
        }
    }
}

package leetcode.leetcode81_100;

/*Given n, how many structurally unique BST's
        (binary search trees) that store values 1 ... n?*/

public class UniqueBinarySearchTrees_96 {


    // dynamic programming version
    public static int numTrees(int n) {
        if(n == 0){
            return 0;
        }
        // orderedNode[i] is the number of the trees that can be formed by using i nodes
        // for which the values are ordered and consecutively
        // eg 1,2,3 or 2,3,4 or 6,7,8 would essentially all form the same trees
        int[] orderedNode = new int[n+1];

        orderedNode[0] = 1; // null
        orderedNode[1] = 1; // one node with left and right null

        // consider orderedNode[i][k]
        // this the number of trees that have i as root and k ordered nodes in total
        // then orderedNode[k] = orderedNode[1][k] + orderedNode[2][k] + ... + orderedNode[k][k]
        // now to calculate orderedNode[i][k]
        // a tree with root node i, can have all possible combinations of left and right subtrees
        // left subtrees with root i: has all values 1 -> i-1: this is orderedNode[i-1]
        // right subtrees with root i: has all values i+1 -> k: this is orderedNode[k-i]
        // hence orderedNode[k] = sum_{i=1}^k orderedNode[i-1]*orderedNode[k-i]

        for(int k = 2; k <= n; k++){
            for(int i = 1; i <= k; i++){
                orderedNode[k] += orderedNode[i-1]*orderedNode[k-i];
            }
        }
        return orderedNode[n];
    }


    // slow recursive version
    public static int numTrees_rec(int n) {
        if(n==0){
            return 0;
        }
        return numTrees(1,n);
    }

    // number of binary search trees containing node values
    // start <= val <= end
    private static int numTrees(int start, int end){
        if(end < start){
            return 1; // null
        }
        else if(start == end){
            return 1; // left and right null
        }
        else{
            int total = 0;
            // find all trees with value i as root
            // and this for all start <= i <= end
            // left tree with root i: has all values start->i-1
            // right tree with root i: has all values i+1 -> end
            // # combinations is multiplication of both numbers
            for(int i = start ; i <= end; i++){
                total += numTrees(start, i-1)*numTrees(i+1, end);
            }
            return total;
        }
    }
}

package leetcode.leetcode81_100;

/*Given an integer n, generate all structurally unique BST's
        (binary search trees) that store values 1 ... n.*/

import apple.laf.JRSUIUtils;
import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII_95 {
    public static List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        return generateTrees(1,n);
    }

    // generate all trees with node values start <= val <= end
    private static List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> result = new ArrayList<>();

        //(*) see below when this case can occur
        if(start > end){
            result.add(null);
            return result;
        }
        else if(start == end){
            result.add(new TreeNode(start));
            return result;
        }

        else{
            // we try to make trees with root val all values between start and end
            for(int i = start; i <= end; i++){
                // left tree should have all node values start--(i-1)
                // right tree should have all node values (i+1)--end
                // it is possible that i-1 < start or end < i+1 -> that's why we add (*)
                List<TreeNode> left = generateTrees(start, i-1);
                List<TreeNode> right = generateTrees(i+1, end);
                // add all possible combinations to result
                for(TreeNode lefttree : left){
                    for(TreeNode righttree : right){
                        TreeNode root = new TreeNode(i);
                        root.left = lefttree;
                        root.right = righttree;
                        result.add(root);
                    }
                }

            }
            return result;
        }


    }
}

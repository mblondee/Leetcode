package leetcode.leetcode101_120;

/*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).*/

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    // check if two trees are symmetric
    private boolean isSymmetric(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        else if(node1 == null || node2 == null){
            return false;
        }
        // node value should be the same
        else if(node1.val != node2.val){
            return false;
        }
        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);

    }

    public boolean symm(TreeNode root){
        if(root == null){
            return true;
        }

        // two queues to add all trees for which it has to be checked that they are the same
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(root.left);
        queue2.add(root.right);


        while(!queue1.isEmpty() && !queue2.isEmpty()){
            // root value have to be the same
            TreeNode node1 = queue1.remove();
            TreeNode node2 = queue2.remove();

            if(node1 == null && node2 == null){
                continue;
            }
            else if(node1 == null && node2 != null || node1 != null && node2 == null){
                return false;
            }
            // node1 != null && node2 != null
            else if(node1.val != node2.val){
                return false;
            }
            else{
                // left of node 1 should be the same as right of node 2
                queue1.add(node1.left);
                queue2.add(node2.right);

                // right of node 1 should be the same as left of node 1
                queue1.add(node1.right);
                queue2.add(node2.left);
            }
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }


}

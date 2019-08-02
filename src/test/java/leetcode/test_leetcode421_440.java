package leetcode;

import leetcode.leetcode101_120.PathSumII_113;
import leetcode.leetcode421_440.LongestRepeatingCharacterReplacement_424;
import leetcode.leetcode421_440.NaryTreeLevelOrderTraversal_429;
import leetcode.leetcode421_440.PathSumIII_437;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class test_leetcode421_440 {

    @Test
    public void testLongestRepeatingCharacterReplacement(){
        assertEquals(0, LongestRepeatingCharacterReplacement_424.characterReplacement("", 2));
        assertEquals(1, LongestRepeatingCharacterReplacement_424.characterReplacement("A", 2));
        assertEquals(4, LongestRepeatingCharacterReplacement_424.characterReplacement("ABAB", 2));
        assertEquals(4, LongestRepeatingCharacterReplacement_424.characterReplacement("AABABBA", 1));
    }

    @Test
    public void testNaryTreeLevelOrderTraversal(){
        Node node1 = new Node();
        Node node3 = new Node();
        Node node2 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();

        node1.val = 1;
        node1.children = new ArrayList<>();
        node1.children.add(node3);
        node1.children.add(node2);
        node1.children.add(node4);
        node3.val = 3;
        node2.val = 2;
        node4.val = 4;
        node2.children = new ArrayList<>();
        node3.children = new ArrayList<>();
        node3.children.add(node5);
        node3.children.add(node6);
        node5.val = 5;
        node6.val = 6;
        node4.children = new ArrayList<>();
        node5.children = new ArrayList<>();
        node6.children = new ArrayList<>();

        List<List<Integer>> result = NaryTreeLevelOrderTraversal_429.levelOrder(node1);
        assertEquals(3, result.size());

     }

     @Test
    public void testPathSumIII(){
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(-3);

        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(2);

        node.left.left.left = new TreeNode(3);
        node.left.left.right = new TreeNode(-2);

         node.left.right.right = new TreeNode(1);

         node.right.right = new TreeNode(11);

         PathSumIII_437 path = new PathSumIII_437();
         assertEquals(3,path.pathSum(node,8));

         TreeNode node1  = new TreeNode(1);
         node1.left = new TreeNode(1);
         node1.right = new TreeNode(1);
         node1.left.left = new TreeNode(1);
         node1.left.right = new TreeNode(1);
         node1.right.left = new TreeNode(1);
         node1.right.right = new TreeNode(1);
         PathSumIII_437 path1 = new PathSumIII_437();
         assertEquals(7,path1.pathSum(node1,1));

     }
}

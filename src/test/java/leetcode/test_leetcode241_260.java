package leetcode;

import leetcode.leetcode241_260.BinaryTreePaths_257;
import leetcode.leetcode241_260.DifferentWaysAddParentheses_241;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class test_leetcode241_260 {

    @Test
    public void testDifferentWaysAddParenthese(){
        List<Integer> result = DifferentWaysAddParentheses_241.diffWaysToCompute("2-1-1");
        assertEquals(2, result.size());

        List<Integer> result1 = DifferentWaysAddParentheses_241.diffWaysToCompute("2*3-4*5");
        assertEquals(5, result1.size());
    }

    @Test
    public void testBinaryTreePaths(){
        BinaryTreePaths_257 paths = new BinaryTreePaths_257();

        TreeNode node = new TreeNode(1);
        List<String> result1 = paths.binaryTreePaths(node);
        assertEquals(1, result1.size());
        assertEquals("1", result1.get(0));



        node.left = new TreeNode(2);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        List<String> result = paths.binaryTreePaths(node);
        assertEquals(2, result.size());
        assertEquals("1->2->5", result.get(0));
        assertEquals("1->3", result.get(1));

    }
}

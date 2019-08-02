package leetcode;

import leetcode.leetcode141_160.BinaryTreePostorderTraversal_145;
import leetcode.leetcode141_160.EvaluateReversePolishNotation_150;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class test_leetcode141_160 {

    @Test
    public void testEvaluateReversePolishNotation(){
        assertEquals(9, EvaluateReversePolishNotation_150.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(6, EvaluateReversePolishNotation_150.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        assertEquals(22, EvaluateReversePolishNotation_150.evalRPN(
                new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    @Test
    public void testBinaryTreePostorderTraversal(){
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(6);
        node.right = new TreeNode(3);


        List<Integer> result = new ArrayList<>();
        result.add(5);
        result.add(6);
        result.add(2);
        result.add(3);
        result.add(1);

        List<Integer> traversal = BinaryTreePostorderTraversal_145.postorderTraversal(node);
        assertEquals(result.size(), traversal.size());
        for(int i = 0; i < result.size(); i++){
            assertEquals(result.get(i), traversal.get(i));
        }
    }
}

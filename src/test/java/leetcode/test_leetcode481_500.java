package leetcode;

import leetcode.leetcode461_480.Codec_449;
import leetcode.leetcode481_500.MaxConsecutiveOnes_485;
import leetcode.leetcode481_500.ReversePairs_493;
import leetcode.leetcode481_500.TargetSum_494;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test_leetcode481_500 {

    @Test
    public void testReversePairs(){
        assertEquals(2, ReversePairs_493.reversePairs(new int[]{1,3,2,3,1}));
        assertEquals(3, ReversePairs_493.reversePairs(new int[]{2,4,3,5,1}));
        ReversePairs_493.reversePairs(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
        Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE});
    }

    @Test
    public void testTargetSum(){
        assertEquals(5, TargetSum_494.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    @Test
    public void testMaxConsecutiveOnes(){
        assertEquals(3, MaxConsecutiveOnes_485.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        assertEquals(0, MaxConsecutiveOnes_485.findMaxConsecutiveOnes(new int[]{0,0,0,0,0,0}));
    }

    @Test
    public void testCodec(){
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(12);
        node.right.left = new TreeNode(11);
        node.right.right = new TreeNode(15);
        node.right.right.left = new TreeNode(13);


        Codec_449 codec = new Codec_449();
        String coded = codec.serialize(node);
        assertEquals("10,5,#,#,12,11,#,#,15,13,#,#,#",coded);
        TreeNode decoded = codec.deserialize(coded);

        assertEquals(10, decoded.val);
        assertEquals(5, decoded.left.val);
        assertEquals(null, decoded.left.left);
        assertEquals(null, decoded.left.right);
        assertEquals(12, decoded.right.val);
        assertEquals(11, decoded.right.left.val);
        assertEquals(null, decoded.right.left.left);
        assertEquals(null, decoded.right.left.right);
        assertEquals(15, decoded.right.right.val);
        assertEquals(13, decoded.right.right.left.val);
        assertEquals(null, decoded.right.right.left.left);
        assertEquals(null, decoded.right.right.left.right);
        assertEquals(null, decoded.right.right.right);




    }
}

package leetcode;

import leetcode.leetcode981_1000.IntervalListIntersections_986;
import leetcode.leetcode981_1000.SmallestStringStartingFromLeaf_988;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class test_leetcode981_1000 {

    @Test
    public void testIntervalListIntersections(){
        int[][] A = {{0,2}, {5,10}, {13,23}, {24,25}};
        int[][] B = {{1,5}, {8,12}, {15,24}, {25,26}};
        assertArrayEquals(new int[][]{{1,2}, {5,5}, {8,10}, {15,23}, {24,24}, {25,25}},
                IntervalListIntersections_986.intervalIntersection(A,B));

        assertArrayEquals(new int[][]{}, IntervalListIntersections_986.intervalIntersection(
                new int[][]{{1,2}, {3,4}}, new int[][]{}
        ));

        assertArrayEquals(new int[][]{}, IntervalListIntersections_986.intervalIntersection(
                new int[][]{{1,2}, {3,4}}, new int[][]{{6,8}}
        ));

        assertArrayEquals(new int[][]{{2,3}, {4,5}}, IntervalListIntersections_986.intervalIntersection(
                new int[][]{{1,3}, {4,6}}, new int[][]{{2,5}}
        ));
    }

    @Test
    public void testSmallestStringStartingFromLeaf(){
        SmallestStringStartingFromLeaf_988 substring = new SmallestStringStartingFromLeaf_988();

        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(4);

        assertEquals("dba", substring.smallestFromLeaf(node));


        TreeNode node1 = new TreeNode(2);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(1);
        node1.left.right = new TreeNode(1);
        node1.left.right.left = new TreeNode(0);
        node1.right.left = new TreeNode(0);

        assertEquals("abc", substring.smallestFromLeaf(node1));

        TreeNode node2 = new TreeNode(25);
        assertEquals("z", substring.smallestFromLeaf(node2));
        node2.left = new TreeNode(1);
        node2.right = new TreeNode(3);
        node2.left.left = new TreeNode(1);
        node2.left.right = new TreeNode(3);
        node2.right.left = new TreeNode(0);
        node2.right.right = new TreeNode(2);

        assertEquals("adz", substring.smallestFromLeaf(node2));
    }
}

package leetcode;

import leetcode.leetcode581_600.NaryTreePostorderTraversal_590;
import leetcode.leetcode581_600.NaryTreePreorderTraversal_589;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class test_leetcode581_600 {

    @Test
    public void testNaryTreePostorderTraversal(){
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
        node3.children = new ArrayList<>();
        node3.children.add(node5);
        node3.children.add(node6);
        node5.val = 5;
        node6.val = 6;
        node4.children = new ArrayList<>();
        node5.children = new ArrayList<>();
        node6.children = new ArrayList<>();

        List<Integer> result = NaryTreePostorderTraversal_590.postorder(node1);
        List<Integer> answer = new ArrayList<>();
        answer.add(5);
        answer.add(6);
        answer.add(3);
        answer.add(2);
        answer.add(4);
        answer.add(1);
        assertEquals(answer.size(), result.size());
        for(int i = 0; i < answer.size(); i++){
            assertEquals(answer.get(i), result.get(i));
        }
    }

    @Test
    public void testNaryTreePreorderTraversal(){
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
        node3.children = new ArrayList<>();
        node3.children.add(node5);
        node3.children.add(node6);
        node5.val = 5;
        node6.val = 6;
        node4.children = new ArrayList<>();
        node5.children = new ArrayList<>();
        node6.children = new ArrayList<>();

        List<Integer> result = NaryTreePreorderTraversal_589.preorder(node1);

        List<Integer> answer = new ArrayList<>();
        answer.add(1);
        answer.add(3);
        answer.add(5);
        answer.add(6);
        answer.add(2);
        answer.add(4);
        assertEquals(answer.size(), result.size());
        for(int i = 0; i < answer.size(); i++){
            assertEquals(answer.get(i), result.get(i));
        }

    }
}

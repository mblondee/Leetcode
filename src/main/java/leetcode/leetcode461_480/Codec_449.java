package leetcode.leetcode461_480;

/*Serialization is the process of converting a data structure or object
        into a sequence of bits so that it can be stored in a file or memory buffer,
        or transmitted across a network connection link to be reconstructed later
        in the same or another computer environment.

        Design an algorithm to serialize and deserialize a binary search tree.
        There is no restriction on how your serialization/deserialization algorithm should work.
        You just need to ensure that a binary search tree can be serialized to a string
        and this string can be deserialized to the original tree structure.

        The encoded string should be as compact as possible.

        Note: Do not use class member/global/static variables to store states.
        Your serialize and deserialize algorithms should be stateless.*/

import leetcode.TreeNode;

import java.util.Stack;

public class Codec_449 {


    // Encodes a tree to a single string.
    // preorder: root - left - right
    public String serialize(TreeNode root) {


        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        StringBuffer str = new StringBuffer();

        // stack contains still to process nodes
        stack.push(current);

        // while still to be processed
        while(! stack.empty()){
            current = stack.pop();

            // add next node
            if(current == null){
                str.append("#,");
            }
            else {
                str.append(current.val);
                str.append(",");
            }

            // still to do: left and right subtree (if tree not null)
            // add right first because has to be processed after left
            if(current != null) {
                stack.push(current.right);
                stack.push(current.left);
            }
        }

        // remove last ","
        str.deleteCharAt(str.length()-1);

        return str.toString();



    }

    // Decodes your encoded data to tree.
    // from preorder to BST
    // preorder: root - left - right
    public TreeNode deserialize(String data) {
        // assumption: we know that it is valid string representing a BST
        // node - left subtree - right subtree
        // BST: first val larger than nodeval is where right subtree starts
        // complete BST (null values are added): hence data string has either one char (null tree) or at least tree

        if(data.length() == 1){ // data : "#"
            return null;
        }

        // tree has a root and two subtrees
        String[] array = data.split(",");

        return helperDeSerialize(array, 0, array.length-1);

    }

    // construct node using subarray of data index start to end included
    // assumed start <= end
    private TreeNode helperDeSerialize(String[] data, int start, int end){
        if(start == end){
            // should be "#"
            return null;
        }

        // if not null, subarray of data should have at least 3 elements
        // data[start] will have value belonging to the root
        // we must check which subarray is left subtree and which one is right subtree
        TreeNode node = new TreeNode(Integer.parseInt(data[start]));
        // case where left subtree is null
        if(data[start+1].equals("#")){
            node.left = null;
            node.right = helperDeSerialize(data, start+2, end);
        }


        else {
            // case where left subtree is not null
            // we search for first element in data that is larger than value in data[start]
            int i = start + 2;
            while (i <= end) {
                if (data[i].equals("#") || Integer.parseInt(data[i]) < Integer.parseInt(data[start])) {
                    //continue
                    //lazy or: second part will only be evaluated if data[i] != "#", hence when it is a number
                    i++;
                } else {
                    break;
                }
            }

            // if we couldn't find such an index: then the right subtree is null ("#" in index end)
            if (i > end) {
                node.left = helperDeSerialize(data, start+1, end-1);
                node.right = null;
            }
            else{
                node.left = helperDeSerialize(data, start+1, i-1);
                node.right = helperDeSerialize(data, i,end);
            }
        }


        return node;
    }


}

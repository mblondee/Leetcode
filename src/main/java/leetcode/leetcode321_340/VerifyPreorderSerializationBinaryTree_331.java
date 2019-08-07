package leetcode.leetcode321_340;

/*One way to serialize a binary tree is to use pre-order traversal.
        When we encounter a non-null node, we record the node's value.
        If it is a null node, we record using a sentinel value such as #.

        For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#",
        where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder
traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character
'#' representing null pointer.

You may assume that the input format is always valid, for example it could
never contain two consecutive commas such as "1,,3".
        */

public class VerifyPreorderSerializationBinaryTree_331 {

    public boolean isValidSerialization(String preorder) {

        // idea: every time we see a not null node, this means it has to have two children
        // we keep save this number of slots to fill
        // every time we see a node, this means a spot is filled, it is a null node, no extra slots are
        // created
        // if at some point the number of available spots is negative, this cannot be a valid tree
        // at the end the number of available spots has to be equal to zero

        if(preorder.length() == 0){
            return true;
        }


        if(preorder.charAt(0)=='#' && preorder.length() != 1){
            return false;
        }

        String[] array = preorder.split(",");

        // we start with one slot to be filled (by the root node, we know it is not a null node)
        int slots = 1;
        for(int i = 0; i<array.length; i++){

            // one slot taken
            slots--;

            if(slots < 0){
                return false;
            }

            if(!array[i].equals("#")){
                // slots created
                slots+=2;
            }



        }

        return slots == 0;



    }


    // slow recursive version
    public boolean isValidSerializationrec(String preorder) {
        if(preorder.length() == 0){
            return true;
        }
        String[] array = preorder.split(",");
        return isValidSerialization(array, 0, array.length-1);


    }

    private boolean isValidSerialization(String[] preorderArray, int start, int end){
        // not a valid subarray
        if(start > end){
            return false;
        }
        // null node is BT
        if(end == start && preorderArray[start].equals("#")){
            return true;
        }

        // if not null node than there have to be at least 2 children
        if(end - start < 2){
            return false;
        }

        // if first one is # it cannot have children
        if(preorderArray[start].equals("#")){
            return false;
        }

        // leaf node is BT
        if(end - start == 2 && preorderArray[start+1].equals("#") && preorderArray[start+2].equals("#")){
            return true;
        }



        // try all combinations
        // 1 node
        // left subtree: start+1 -> start + 1+ length (length: 0 -> end-start)
        // right subtree: start + 1+ length +1 -> end
        for(int length = 0; length < end-start; length++){
            if(isValidSerialization(preorderArray, start+1, start+1+length) &&
            isValidSerialization(preorderArray, start + length +2, end)){
                return true;
            }
        }

        return false;

    }
}

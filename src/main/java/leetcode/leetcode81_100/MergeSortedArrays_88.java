package leetcode.leetcode81_100;

/*Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

        Note:

        The number of elements initialized in nums1 and nums2 are m and n respectively.
        You may assume that nums1 has enough space (size that is greater or equal to m + n)
        to hold additional elements from nums2.*/

public class MergeSortedArrays_88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // filling in nums1 starting from end (i.e. index m+n-1)
        int i = m+n-1;
        int last1 = m-1;
        int last2 = n-1;

        while(last1 >= 0 && last2 >= 0) {
            if (nums1[last1] > nums2[last2]) {
                nums1[i--] = nums1[last1--];
            } else {
                nums1[i--] = nums2[last2--];
            }
        }

        if(last1 < 0){
            // adding elements from nums2
            while(last2 >= 0){
                nums1[i--] = nums2[last2--];
            }
        }

        // if last2 < 0 : all elements are in place

    }


}

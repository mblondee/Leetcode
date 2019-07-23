package leetcode;

import leetcode.leetcode1_20.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;



import static org.junit.Assert.*;


public class test_leetcode1_20 {

    @Test
    public void testTwoSum(){
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] res = TwoSum_1.twoSum(nums, target);
        assertEquals(2, res.length);

        Arrays.sort(res);
        assertArrayEquals(new int[]{0,1}, res);



    }

    @Test
    public void testAddTwoNumbers(){
        ListNode l1 = new ListNode(8);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(2);

        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(1);

        ListNode res = AddTwoNumbers_2.addTwoNumbers(l1,l2);
        assertEquals(5, res.val);
        assertEquals(9, res.next.val);
        assertEquals(3, res.next.next.val);
        assertEquals(null, res.next.next.next);

        ListNode l3 = new ListNode(9);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(1);
        l3.next.next.next = new ListNode(4);


        ListNode l4 = new ListNode(2);
        l4.next = new ListNode(8);

        ListNode res3 = AddTwoNumbers_2.addTwoNumbers(l3,l4);
        assertEquals(1, res3.val);
        assertEquals(1, res3.next.val);
        assertEquals(2, res3.next.next.val);
        assertEquals(4, res3.next.next.next.val);
        assertEquals(null, res3.next.next.next.next);


        ListNode l5 = new ListNode(0);


        ListNode l6 = new ListNode(2);
        l6.next = new ListNode(8);

        ListNode res5 = AddTwoNumbers_2.addTwoNumbers(l5,l6);
        assertEquals(2, res5.val);
        assertEquals(8, res5.next.val);
        assertEquals(null, res5.next.next);


        ListNode l7 = new ListNode(1);
        ListNode l8 = new ListNode(9);
        l8.next = new ListNode(9);
        ListNode res7 = AddTwoNumbers_2.addTwoNumbers(l7, l8);
        assertEquals(0, res7.val);
        assertEquals(0, res7.next.val);
        assertEquals(1, res7.next.next.val);
        assertEquals(null, res7.next.next.next);


    }


    @Test
    public void testLongestSubstring(){
        String s1 = "";
        Assert.assertEquals(0, LongestSubstring_3.lengthOfLongestSubstring(s1));

        String s2 = "hahaha";
        Assert.assertEquals(2, LongestSubstring_3.lengthOfLongestSubstring(s2));

        String s3 = "abcabcbb";
        Assert.assertEquals(3, LongestSubstring_3.lengthOfLongestSubstring(s3));

        String s4 = "bbbbb";
        Assert.assertEquals(1, LongestSubstring_3.lengthOfLongestSubstring(s4));

        String s5 = "pwwkew";
        Assert.assertEquals(3, LongestSubstring_3.lengthOfLongestSubstring(s5));

        String s6 = "dvdf";
        Assert.assertEquals(3, LongestSubstring_3.lengthOfLongestSubstring(s6));

    }

    @Test
    public void testkthEl(){
        int[] A = new int[]{0,1,2,3,4};
        int[] B = new int[]{4,5,6,7,8};
        Assert.assertEquals(0.0, MedianSortedArrays_4.findkthElement(1, A,B, 0, 0), 0.0001);
        Assert.assertEquals(1.0, MedianSortedArrays_4.findkthElement(2, A,B, 0, 0), 0.0001);
        Assert.assertEquals(2.0, MedianSortedArrays_4.findkthElement(3, A,B, 0, 0), 0.0001);
        Assert.assertEquals(3.0, MedianSortedArrays_4.findkthElement(4, A,B, 0, 0), 0.0001);
        Assert.assertEquals(4.0, MedianSortedArrays_4.findkthElement(5, A,B, 0, 0), 0.0001);
        Assert.assertEquals(4.0, MedianSortedArrays_4.findkthElement(6, A,B, 0, 0), 0.0001);
        Assert.assertEquals(5.0, MedianSortedArrays_4.findkthElement(7, A,B, 0, 0), 0.0001);
        Assert.assertEquals(6.0, MedianSortedArrays_4.findkthElement(8, A,B, 0, 0), 0.0001);
        Assert.assertEquals(7.0, MedianSortedArrays_4.findkthElement(9, A,B, 0, 0), 0.0001);
        Assert.assertEquals(8.0, MedianSortedArrays_4.findkthElement(10, A,B, 0, 0), 0.0001);

        int[] A1 = new int[]{1,4};
        int[] B1 = new int[]{2,2,3,3,4,4,5,5,6};

        Assert.assertEquals(1.0, MedianSortedArrays_4.findkthElement(1, A1,B1, 0, 0), 0.0001);
        Assert.assertEquals(2.0, MedianSortedArrays_4.findkthElement(2, A1,B1, 0, 0), 0.0001);
        Assert.assertEquals(2.0, MedianSortedArrays_4.findkthElement(3, A1,B1, 0, 0), 0.0001);
        Assert.assertEquals(3.0, MedianSortedArrays_4.findkthElement(4, A1,B1, 0, 0), 0.0001);
        Assert.assertEquals(3.0, MedianSortedArrays_4.findkthElement(5, A1,B1, 0, 0), 0.0001);
        Assert.assertEquals(4.0, MedianSortedArrays_4.findkthElement(6, A1,B1, 0, 0), 0.0001);
        Assert.assertEquals(4.0, MedianSortedArrays_4.findkthElement(7, A1,B1, 0, 0), 0.0001);
        Assert.assertEquals(4.0, MedianSortedArrays_4.findkthElement(8, A1,B1, 0, 0), 0.0001);
        Assert.assertEquals(5.0, MedianSortedArrays_4.findkthElement(9, A1,B1, 0, 0), 0.0001);
        Assert.assertEquals(5.0, MedianSortedArrays_4.findkthElement(10, A1,B1, 0, 0), 0.0001);
        Assert.assertEquals(6.0, MedianSortedArrays_4.findkthElement(11, A1,B1, 0, 0), 0.0001);


        Assert.assertEquals(1.0, MedianSortedArrays_4.findkthElement(1, B1,A1, 0, 0), 0.0001);
        Assert.assertEquals(2.0, MedianSortedArrays_4.findkthElement(2, B1,A1, 0, 0), 0.0001);
        Assert.assertEquals(2.0, MedianSortedArrays_4.findkthElement(3, B1,A1, 0, 0), 0.0001);
        Assert.assertEquals(3.0, MedianSortedArrays_4.findkthElement(4, B1,A1, 0, 0), 0.0001);
        Assert.assertEquals(3.0, MedianSortedArrays_4.findkthElement(5, B1,A1, 0, 0), 0.0001);
        Assert.assertEquals(4.0, MedianSortedArrays_4.findkthElement(6, B1,A1, 0, 0), 0.0001);
        Assert.assertEquals(4.0, MedianSortedArrays_4.findkthElement(7, B1, A1,0, 0), 0.0001);
        Assert.assertEquals(4.0, MedianSortedArrays_4.findkthElement(8, B1, A1,0, 0), 0.0001);
        Assert.assertEquals(5.0, MedianSortedArrays_4.findkthElement(9, B1, A1, 0, 0), 0.0001);
        Assert.assertEquals(5.0, MedianSortedArrays_4.findkthElement(10, B1, A1, 0, 0), 0.0001);
        Assert.assertEquals(6.0, MedianSortedArrays_4.findkthElement(11, B1,A1, 0, 0), 0.0001);

        int[] A3 = new int[]{1};
        int[] B3 = new int[]{2};
        Assert.assertEquals(1, MedianSortedArrays_4.findkthElement(1, A3,B3, 0, 0), 0.0001);
        Assert.assertEquals(2, MedianSortedArrays_4.findkthElement(2, A3,B3, 0, 0), 0.0001);


    }

    @Test
    public void testMedian(){
        int[] A = new int[]{0,1,2,3,4};
        int[] B = new int[]{4,5,6,7,8};
        Assert.assertEquals(4.0, MedianSortedArrays_4.findMedianSortedArrays(A,B), 0.001);


        int[] A1 = new int[]{1,4};
        int[] B1 = new int[]{2,2,3,3,4,4,5,5,6};
        Assert.assertEquals(4.0, MedianSortedArrays_4.findMedianSortedArrays(A1,B1), 0.001);

        int[] A2 = new int[]{};
        int[] B2 = new int[]{2,2,3,3,4,4,5,5,6};
        Assert.assertEquals(4.0, MedianSortedArrays_4.findMedianSortedArrays(A2,B2), 0.001);

        int[] A3 = new int[]{1};
        int[] B3 = new int[]{2};
        Assert.assertEquals(1.5, MedianSortedArrays_4.findMedianSortedArrays(A3,B3), 0.001);
    }

    @Test
    public void testPalindormicSubstring(){
        String s1 = "babad";
        assertTrue(LongestPalindromicSubstring_5.longestPalindrome(s1).equals("aba") ||
                LongestPalindromicSubstring_5.longestPalindrome(s1).equals("bab"));

        String s2 = "cbbd";
        Assert.assertEquals("bb", LongestPalindromicSubstring_5.longestPalindrome(s2));

        String s3 = "";
        Assert.assertEquals("", LongestPalindromicSubstring_5.longestPalindrome(s3));

        String s4 = "bbbbbbbbbb";
        Assert.assertEquals("bbbbbbbbbb", LongestPalindromicSubstring_5.longestPalindrome(s4));

        String s5 = "bbaaabb";
        Assert.assertEquals(s5, LongestPalindromicSubstring_5.longestPalindrome(s5));

        String s6 = "a";
        Assert.assertEquals(s6, LongestPalindromicSubstring_5.longestPalindrome(s6));
    }

    @Test
    public void testZigZagConversion(){
        String s1 = "PAYPALISHIRING";
        Assert.assertEquals("PAHNAPLSIIGYIR", ZigZagConversion_6.convert(s1, 3));
        Assert.assertEquals("PINALSIGYAHRPI", ZigZagConversion_6.convert(s1, 4));

        String s2 = "";
        Assert.assertEquals("", ZigZagConversion_6.convert(s2,1));

        String s3 = "ab";
        Assert.assertEquals("ab", ZigZagConversion_6.convert(s3, 1));
    }

    @Test
    public void testReverseInteger(){
        Assert.assertEquals(321, ReverseInteger_7.reverse(123));
        Assert.assertEquals(-321, ReverseInteger_7.reverse(-123));
        Assert.assertEquals(0, ReverseInteger_7.reverse(1534236469));
        Assert.assertEquals(-2143847412, ReverseInteger_7.reverse(-2147483412));
    }

    @Test
    public void testStringToInteger(){
        Assert.assertEquals(42, StringToInteger_8.myAtoi("42"));
        Assert.assertEquals(-42, StringToInteger_8.myAtoi("-42"));
        Assert.assertEquals(42, StringToInteger_8.myAtoi("     42"));
        Assert.assertEquals(-42, StringToInteger_8.myAtoi("    -42"));
        Assert.assertEquals(0, StringToInteger_8.myAtoi("aba"));
        Assert.assertEquals(4193, StringToInteger_8.myAtoi("4193 with words"));
        Assert.assertEquals(0, StringToInteger_8.myAtoi("words and 987"));
        Assert.assertEquals(Integer.MIN_VALUE, StringToInteger_8.myAtoi("-91283472332"));
        Assert.assertEquals(Integer.MAX_VALUE, StringToInteger_8.myAtoi("91283472332"));
        Assert.assertEquals(3, StringToInteger_8.myAtoi("3.14159"));
        Assert.assertEquals(0, StringToInteger_8.myAtoi("+-2"));
        Assert.assertEquals(-12, StringToInteger_8.myAtoi("  -0012a42"));
        Assert.assertEquals(0, StringToInteger_8.myAtoi(" b11228552307"));


    }

    @Test
    public void testPalindromeNumber(){
        assertTrue(PalindromeNumber_9.isPalindrome(64346));
        assertTrue(PalindromeNumber_9.isPalindrome(6));
        assertTrue(PalindromeNumber_9.isPalindrome(66));
        assertFalse(PalindromeNumber_9.isPalindrome(-121));
        assertFalse(PalindromeNumber_9.isPalindrome(10));

    }

    @Test
    public void testRegExMatching(){
        assertFalse(RegExMatching_10.helper("aa", "a", 0,0,2,1));
        assertTrue(RegExMatching_10.helper("aa", "..", 0,0,2,2));
        assertFalse(RegExMatching_10.helper("aa", ".", 0,0,2,1));
        assertFalse(RegExMatching_10.helper("", ".", 0,0,0,1));

        assertTrue(RegExMatching_10.helper("aa", "a*", 0,0,2,2));
        assertTrue(RegExMatching_10.helper("aaaa", "a*a*", 0,0,4,4));
        assertFalse(RegExMatching_10.helper("baaa", "a*a*", 0,0,4,4));
        assertFalse(RegExMatching_10.helper("aaba", "a*a*", 0,0,4,4));

        assertTrue(RegExMatching_10.helper("aab", "c*a*b", 0,0,3,5));
        assertTrue(RegExMatching_10.helper("aab", ".*", 0,0,3,2));

        assertTrue(RegExMatching_10.helper("aabc", ".*c", 0,0,4,3));
        assertFalse(RegExMatching_10.helper("aabd", ".*c", 0,0,4,3));

        assertTrue(RegExMatching_10.isMatch("aaa", "ab*ac*a"));
    }

    @Test
    public void testMaxArea(){
        int[] input = new int[]{1,8,6,2,5,4,8,3,7};
        Assert.assertEquals(49, MaxWater_11.maxArea(input));
    }

    @Test
    public void testIntegerToRoman(){
        Assert.assertEquals("I", IntegerToRoman_12.intToRoman(1));
        Assert.assertEquals("II", IntegerToRoman_12.intToRoman(2));
        Assert.assertEquals("III", IntegerToRoman_12.intToRoman(3));
        Assert.assertEquals("IV", IntegerToRoman_12.intToRoman(4));
        Assert.assertEquals("V", IntegerToRoman_12.intToRoman(5));
        Assert.assertEquals("VI", IntegerToRoman_12.intToRoman(6));
        Assert.assertEquals("VII", IntegerToRoman_12.intToRoman(7));
        Assert.assertEquals("VIII", IntegerToRoman_12.intToRoman(8));
        Assert.assertEquals("IX", IntegerToRoman_12.intToRoman(9));
        Assert.assertEquals("X", IntegerToRoman_12.intToRoman(10));
        Assert.assertEquals("L", IntegerToRoman_12.intToRoman(50));
        Assert.assertEquals("C", IntegerToRoman_12.intToRoman(100));
        Assert.assertEquals("D", IntegerToRoman_12.intToRoman(500));
        Assert.assertEquals("M", IntegerToRoman_12.intToRoman(1000));

        Assert.assertEquals("MCMXCIV", IntegerToRoman_12.intToRoman(1994));
    }

    @Test
    public void testRomanToInteger(){
        Assert.assertEquals(1, RomanToInteger_13.romanToInt("I"));
        Assert.assertEquals(2, RomanToInteger_13.romanToInt("II"));
        Assert.assertEquals(3, RomanToInteger_13.romanToInt("III"));
        Assert.assertEquals(4, RomanToInteger_13.romanToInt("IV"));
        Assert.assertEquals(5, RomanToInteger_13.romanToInt("V"));
        Assert.assertEquals(6, RomanToInteger_13.romanToInt("VI"));
        Assert.assertEquals(7, RomanToInteger_13.romanToInt("VII"));
        Assert.assertEquals(8, RomanToInteger_13.romanToInt("VIII"));
        Assert.assertEquals(9, RomanToInteger_13.romanToInt("IX"));
        Assert.assertEquals(10, RomanToInteger_13.romanToInt("X"));

        Assert.assertEquals(40, RomanToInteger_13.romanToInt("XL"));
        Assert.assertEquals(50, RomanToInteger_13.romanToInt("L"));
        Assert.assertEquals(90, RomanToInteger_13.romanToInt("XC"));
        Assert.assertEquals(100, RomanToInteger_13.romanToInt("C"));
        Assert.assertEquals(400, RomanToInteger_13.romanToInt("CD"));
        Assert.assertEquals(900, RomanToInteger_13.romanToInt("CM"));

        Assert.assertEquals(1994, RomanToInteger_13.romanToInt("MCMXCIV"));

    }

    @Test
    public void testCommonPrefix(){
        String[] empty = new String[]{};
        Assert.assertEquals("", LongestCommonPrefix_14.longestCommonPrefix(empty));

        String[] strs1 = new String[]{"flower","flow","flight"};
        Assert.assertEquals("fl", LongestCommonPrefix_14.longestCommonPrefix(strs1));

        String[] strs2 = new String[]{"dog","racecar","car"};
        Assert.assertEquals("", LongestCommonPrefix_14.longestCommonPrefix(strs2));
    }

    @Test
    public void testThreeSum(){
        int[] example1 = new int[]{-1, 0, 1, 2, -1,-4};
        Assert.assertEquals(2, ThreeSum_15.threeSum(example1).size());

        int[] example3 = new int[]{-1, 0,1, 1,-1, 2, -1,-4};
        Assert.assertEquals(2, ThreeSum_15.threeSum(example3).size());

        int[] example2 = new int[]{-1,-1,-1,0,0, 0, 1, 2, -1, -4};
        Assert.assertEquals(3, ThreeSum_15.threeSum(example2).size());

        int[] example4 = new int[]{-2,0,0,2,2};
        Assert.assertEquals(1, ThreeSum_15.threeSum(example4).size());
    }

    @Test
    public void testThreeSumClosest(){
        int[] example1 = new int[]{-1, 2, 1, -4};
        Assert.assertEquals(2, ThreeSumClosest_16.threeSumClosest(example1,1));

        int[] example2 = new int[]{-1, 2,-1,1, 1, 1, -4};
        Assert.assertEquals(1, ThreeSumClosest_16.threeSumClosest(example2,1));
    }

    @Test
    public void testLetterCombinations(){
        String input = "23";
        String[] output = {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        List<String> generated = LetterCombinationsPhone_17.letterCombinations(input);
        assertEquals(output.length, generated.size());
        for(String str: output){
            assertTrue(generated.contains(str));
        }

        String input1 = "";
        String[] output1 = {};
        List<String> generated1 = LetterCombinationsPhone_17.letterCombinations(input1);
        assertEquals(output1.length, generated1.size());


    }

    @Test
    public void testFourSum(){
        int[] example1 = {1, 0, -1, 0, -2, 2};
        Assert.assertEquals(3, FourSum_18.fourSum(example1, 0).size());

        int[] example2 = {1, 0,0,0, -1, 0, -2,2,-2, 2};
        Assert.assertEquals(5, FourSum_18.fourSum(example2, 0).size());

        int[] example3 = {0,0,0,0};
        Assert.assertEquals(1, FourSum_18.fourSum(example3,0).size());
    }

    @Test
    public void testRemoveNthNode(){
        ListNode testNode = new ListNode(1);
        testNode.next = new ListNode(2);
        testNode.next.next = new ListNode(3);
        testNode.next.next.next = new ListNode(4);
        testNode.next.next.next.next = new ListNode(5);
        RemoveNthNode_19.removeNthFromEnd(testNode,2);

        ListNode expected = new ListNode(1);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(5);

        ListNode pointer1 = testNode;
        ListNode pointer2 = expected;
        while(pointer2 != null){
            assertEquals(pointer1.val, pointer2.val);
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        ListNode testNode1 = new ListNode(1);
        ListNode result = RemoveNthNode_19.removeNthFromEnd(testNode1,0);
        assertEquals(null, result);


        RemoveNthNode_19.removeNthFromEnd(testNode, 1);
        ListNode expected1 = new ListNode(1);
        expected1.next = new ListNode(2);
        expected1.next.next = new ListNode(3);

        ListNode pointer3 = testNode;
        ListNode pointer4 = expected1;
        while(pointer4 != null){
            assertEquals(pointer3.val, pointer4.val);
            pointer3 = pointer3.next;
            pointer4 = pointer4.next;
        }



    }

    @Test
    public void testParentheses(){
        assertTrue(ValidParentheses_20.isValid(""));
        assertTrue(ValidParentheses_20.isValid("()"));
        assertTrue(ValidParentheses_20.isValid("{}"));
        assertTrue(ValidParentheses_20.isValid("[]"));
        assertTrue(ValidParentheses_20.isValid("(){}[][]()"));
        assertTrue(ValidParentheses_20.isValid("({[]})"));

        assertFalse(ValidParentheses_20.isValid("({)}"));
        assertFalse(ValidParentheses_20.isValid("[{(}}[]"));
        assertFalse(ValidParentheses_20.isValid("(((((((("));
    }

}

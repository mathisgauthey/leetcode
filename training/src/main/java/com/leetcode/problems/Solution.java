package com.leetcode.problems;

public class Solution {

    public static String largestOddNumber(String num) {
        String solution = "";
        if ((int) num.charAt(num.length() - 1) % 2 != 0) {
            solution = num;
        } else {
            for (int i = num.length() - 1; i >= 0; i--) {
                if ((int) num.charAt(i) % 2 != 0) {
                    solution = num.substring(0, i + 1);
                    break;
                }
            }
        }
        return solution;
    }

    // public static String concatStringArray(String[] word) {
    // String result = word[0];
    // for (int i = 1; i < word.length; i++) {
    // result = result + word[i];
    // }
    // return result;
    // }

    // public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    // String word1_concat = concatStringArray(word1);
    // String word2_concat = concatStringArray(word2);
    // boolean res = false;
    // if (word1_concat.equals(word2_concat)) {
    // res = true;
    // }
    // return res;
    // }

    // public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    // String left = ""; // Initialize left and right to empty strings
    // String right = "";

    // // Concatenate strings in word1
    // for (int i = 0; i < word1.length; i++) {
    // left += word1[i];
    // }

    // // Concatenate strings in word2
    // for (int i = 0; i < word2.length; i++) {
    // right += word2[i];
    // }

    // // Use equals() method to compare strings
    // return left.equals(right);
    // }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for (String word : word1) {
            str1.append(word);
        }
        for (String word : word2) {
            str2.append(word);
        }
        String s1 = str1.toString();
        String s2 = str2.toString();

        if (s1.equals(s2)) {
            return true;
        } else {
            return false;
        }
    }

    public static void mergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }

    public static int maxProduct(int[] num) {
        int res;
        int max = 0;
        int second_max = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] <= max && num[i] > second_max) {
                second_max = num[i];
            }
            if (num[i] > max) {
                second_max = max;
                max = num[i];
            }
        }
        res = (max - 1) * (second_max - 1);
        return res;
    }

    public static int strStr(String haystack, String needle) {
        int hayLength = haystack.length();
        int needleLength = needle.length();
        if (hayLength < needleLength) {
            return -1;
        }
        // There is a total of n = (hayLength-needleLength+1) substrings of
        // size needle in haystack. So you need to iterate from index 0 to
        // index hayLength-needleLength.
        for (int i = 0; i <= hayLength - needleLength; i++) {
            int j = 0;
            while (j < needleLength && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needleLength) {
                return i;
            }
        }
        return -1;
    }
}

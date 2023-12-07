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

    public static String concatStringArray(String[] word) {
        String result = word[0];
        for (int i = 1; i < word.length; i++) {
            result = result + word[i];
        }
        return result;
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String word1_concat = concatStringArray(word1);
        String word2_concat = concatStringArray(word2);
        boolean res = false;
        if (word1_concat.equals(word2_concat)) {
            res = true;
        }
        return res;
    }
}

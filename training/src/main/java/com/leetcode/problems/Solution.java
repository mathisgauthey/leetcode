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
}

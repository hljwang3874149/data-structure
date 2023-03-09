package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    public static void main(String[] args) {
        new LeetCode22().generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {

        List<String> stringList = new ArrayList<>();
        int left = 0, right = 0;
        generate(stringList, left, right, n, "");

        return stringList;
        /**
         * List<List<String>> res = new ArrayList<>();
         *         res.add(new ArrayList<>(Arrays.asList("")));
         *         res.add(new ArrayList<>(Arrays.asList("()")));
         *         for (int i = 2; i <= n; i++) {
         *             List<String> tmp = new ArrayList<>();
         *             for (int j = 0; j < i; j++) {
         *                 List<String> str1 = res.get(j);
         *                 List<String> str2 = res.get(i - 1 - j);
         *                 for (String s1 : str1) {
         *                     for (String s2 : str2) {
         *                         StringBuilder sb = new StringBuilder();
         *                         sb.append('(').append(s1).append(')').append(s2);
         *                         tmp.add(sb.toString());
         *                     }
         *                 }
         *             }
         *             res.add(tmp);
         *         }
         *         return res.get(n);
         */
    }

    private void generate(List<String> stringList, int left, int right, int n, String result) {
        if (n == right && left == n) {
            stringList.add(result);
            return;
        }
        if (left < n) {
            generate(stringList, left + 1, right, n, result + "(");
        }
        if (right < left) {
            generate(stringList, left, right + 1, n, result + ")");

        }

    }
}

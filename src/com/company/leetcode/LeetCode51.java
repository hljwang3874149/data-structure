package com.company.leetcode;

import java.util.*;

/**
 * N皇后问题
 * row 仅且只能放一个
 * 撇 row+column
 * 捺 row-column
 * 递归每个row
 * 循环row上的column
 */
public class LeetCode51 {
    public static void main(String[] args) {

    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n==1){
             result.add(Collections.singletonList("Q"));
             return result;
        }
        int[] queens = new int[n];
        Arrays.fill(queens,-1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();

        dfs(result,queens,n,0,columns,diagonals1,diagonals2);

    return result;

    }

    private void dfs(List<List<String>> result, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {

        if(n == row){
            result.add(generateString(queens,n));
        }else{
            for (int i = 0; i < n; i++) {
                if(columns.contains(i)){
                    continue;
                }
                int diagonal1  = row -i;
                if(diagonals1.contains(diagonal1)){
                    continue;
                }
                int diagonal2 = row +i;
                if(diagonals2.contains(diagonal2)){
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                dfs(result, queens, n, row+1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }

    }

    private List<String> generateString(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}

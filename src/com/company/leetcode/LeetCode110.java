package com.company.leetcode;

public class LeetCode110 {
    public static void main(String[] args) {

    }
   static class Solution {
        public boolean isBalanced(TreeNode root) {
            return recur(root) != -1;
        }
        private int recur(TreeNode node){
            if(node==null) return 0;
            int left = recur(node.left);
            if (left ==-1)return  -1;
            int right =recur(node.right);
            if(right==-1)return -1;
            return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
        }

       static  final int Mod = 1000000007;
       public int fib(int n) {
            //O(n) O(1)

           if(n<2){
               return n;
           }
           int p =0,e=0,r=1;
           for (int i=2;i<n;i++){
               p =e;
               e=r;
               r= (p+e)%Mod ;
           }
           return r;

       }
       public int fib1(int n) {
           if(n<2)return n;
            int[][] unit = {{1,1},{1,0}};
           int [][] res =pow(unit,n-1);
           return res[0][0];

       }

       private int[][] pow(int[][] unit, int i) {
            int[][] ret = {{1,0},{0,1}};
            while (i>0){
                if((i&1)!=0){
                    ret = multiply(ret,unit);
                }
                i>>=1;
                unit= multiply(unit,unit);



            }
           return ret;
       }

       private int[][] multiply(int[][] ret, int[][] unit) {
           int[][] res = new int[2][2];
           for (int i = 0; i < 2; i++) {
               for (int j = 0; j < 2; j++) {
                   res[i][j]= (ret[i][0]*unit[0][j]+res[i][1]*unit[1][j])%Mod;
               }
           }
           return  res;

       }

   }
}

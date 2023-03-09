package com.company.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode104 {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
//        return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode  node=  queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right !=null){
                    queue.add(node.right);
                }
            }
        }
        return depth;


    }
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int left =minDepth(root.left);
        int right = minDepth(root.right);
        return  (left==0||right==0) ?right+left+1:Math.min(left,right)+1;

    }
}

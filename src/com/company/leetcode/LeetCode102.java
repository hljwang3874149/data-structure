package com.company.leetcode;

import java.util.*;

public class LeetCode102 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
//        bfs(root, list);
        dfs(root,list,0);



        return list;
    }

    private void dfs(TreeNode node, List<List<Integer>> list, int level) {
        if(node ==null) return;
        level = level+1;
        if(list.size() <level){
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        dfs(node.left,list,level);
        dfs(node.right,list,level);
    }

    private static void bfs(TreeNode root, List<List<Integer>> list) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> cell = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                cell.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(cell);
        }
    }
}

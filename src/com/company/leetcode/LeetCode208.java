package com.company.leetcode;

public class LeetCode208 {
    public static void main(String[] args) {
        int b = 0b1111111;
//        b = b& (b-1);
        System.out.println(b);
        int count =0;
        while (b!=0){
            count++;
            b = b& (b-1);
            System.out.println("b:"+b + "count:"+count);
        }

    }

    class Trie {
        boolean isEnd;
        Trie[] children;
        final static int R = 26;

        public Trie() {
            isEnd = false;
            children = new Trie[R];

        }
        //删除字典数中包含的单词
        public void delete(String word) {
            Trie node = this;
            char[] chars = word.toCharArray();
            for (char ch : chars) {
                int index = ch -'a';
                if (node.children[index] ==null){
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }

            node.isEnd =true;
        }



        public void insert(String word) {
            Trie node = this;
            char[] chars = word.toCharArray();
            for (char ch : chars) {
                int index = ch -'a';
                if (node.children[index] ==null){
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }

            node.isEnd =true;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;

        }

        private Trie searchPrefix(String word) {
            Trie node = this;
           char[] chars =  word.toCharArray();
            for (char ch : chars) {
                int index = ch - 'a';
                if (node.children[index] ==null) return null;
                node = node.children[index];

            }
            return node;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) !=null;

        }
    }
}

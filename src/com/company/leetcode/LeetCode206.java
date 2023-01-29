package com.company.leetcode;

import java.util.*;

import static sun.misc.Version.print;

public class LeetCode206 {

    public static void main(String[] args) {
//        ListNode first = new ListNode(0);
//        ListNode head = first;
//        for (int i = 1; i < 5; i++) {
//            first.next = new ListNode(i);
//            first = first.next;
//        }
//        printNode(head);
//        ListNode reverse = new Solution().reverseList(head);
//        System.out.println("reverse = " + reverse.val);
//        printNode(reverse);
//        String s = "[{()}]";
//        System.out.println(new Solution().isValid(s));
//        new Solution().isAnagram("anagram", "nagaram");
        int[] nums = new int[]{3,2,4};
        new Solution().twoSum(nums, 6);

    }

    public static void printNode(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    static class Solution {
        //        public ListNode reverseList(ListNode head) {
////            ListNode preNode =null;
////            ListNode current = head;
////            while(current!=null ){
////                ListNode temp = current.next;
////                current.next =preNode;
////                preNode = current;
////                current =temp;
////            }
////            return preNode;
//
//            if (head ==null || head.next ==null){
//                return  head;
//            }
//            ListNode newNode = reverseList(head.next);
////            4.next =3
//            head.next.next =head;
////            3.next =null
//            head.next=null;
//            return newNode;
//
//        }
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;
            return next;
        }

        public ListNode reverseList(ListNode head) {
//           if(head ==null || head.next==null){
//               return head;
//           }
//           ListNode newNode = reverseList(head.next);
//           head.next.next =head;
//           head.next = null;
//           return  newNode;
            ListNode pre = null;
            ListNode current = head;
            while (current != null) {
                ListNode next = current.next;
                current.next = pre;
                pre = current;
                current = next;
            }
            return pre;

        }

        public boolean hasCycle(ListNode head) {
//            if (head == null || head.next == null) {
//                return false;
//            }
//            ListNode preNode = head;
//            ListNode tailNode = head.next;
//            while (preNode!=tailNode) {
//                if(tailNode.next==null || preNode.next ==null){
//                    return false;
//                }
//
//                preNode = preNode.next;
//                tailNode = tailNode.next.next;
//            }
//            return true;
            HashSet<ListNode> hashSet = new HashSet<>();
            while (head.next != null) {
                if (!hashSet.add(head)) {
                    return true;
                }
                head = head.next;
            }
            return false;

        }

        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return null;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;

//            while (true) {
//                if (fast == null || fast.next == null) return null;
//                fast = fast.next.next;
//                slow = slow.next;
//                if (fast == slow) break;
//            }
//            fast = head;
//            while (slow != fast) {
//                slow = slow.next;
//                fast = fast.next;
//            }
//            return fast;


        }

        //25
        public ListNode reverseKGroup1(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy, end = dummy;
            while (end.next != null) {
                for (int i = 0; i < k & end != null; i++) {
                    end = end.next;
                }
                if (end == null) break;
                ListNode next = end.next;
                ListNode start = pre.next;
                end.next = null;
                pre.next = swap(start);
                start.next = next;
                pre = start;
                end = pre;
            }

            return dummy.next;

        }

        private ListNode swap(ListNode start) {
            ListNode pre = null;
            ListNode curr = start;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }

            return pre;
        }

        //20
//        public boolean isValid(String s) {
////            "{}[]()"
//            if(s ==null || s.length()<2 || s.length()%2 !=0)return  false;
//            for (int i = 0; i < s.length()/2; i+=2) {
//              boolean result = check(s.charAt(i),s.charAt(i+1));
//              if(!result){
//                  return false;
//              }
//            }
//            return true;
//        }
//
        private boolean check(char charAt, char charAt1) {
            switch (charAt) {
                case '{': {
                    return charAt1 == '}';
                }
                case '(': {
                    return charAt1 == ')';
                }
                case '[':
                    return charAt1 == ']';
                default:
                    return false;
            }
        }

        public boolean isValid(String s) {
            if (s == null || s.length() < 2 || s.length() % 2 != 0) return false;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (stack.size() == 0) {
                    stack.push(s.charAt(i));
                    continue;
                }
                char curr = s.charAt(i);
                boolean result = check(stack.peek(), curr);
                if (result) {
                    stack.pop();
                } else {
                    stack.push(curr);
                }

            }
            return stack.size() == 0;
//            if(stack.size()==0)return true;
//            Stack<Character> backStack = new Stack<>();
//
//            while (stack.size() !=0){
//                char end = stack.pop();
//                if(backStack.size() ==0){
//                    backStack.push(end);
//                    continue;
//                }
//                if (check(end, backStack.peek())){
//                    backStack.pop();
//                }else {
//                    backStack.push(end);
//                }
//            }
//            return  backStack.size()==0 && stack.size() ==0;

        }

        //242
        // @see https://leetcode.cn/problems/valid-anagram/
        public boolean isAnagram(String s, String t) {
//            if (s.equals(t)) return true;
//            if(s==null || t == null) return false;
//            if(s.length() != t.length())return false;
//            HashMap<Character,Integer> hashMap = new HashMap();
//            HashMap<Character,Integer> hashMap1 = new HashMap();
//            for (int i = 0; i < s.length(); i++) {
//                char sChar =s.charAt(i);
//                char tChar = t.charAt(i);
//                if(sChar!=tChar) {
//                    Integer sValue  = hashMap.get(sChar);
//                    Integer tValue  = hashMap1.get(tChar);
//                    hashMap.put(sChar,hashMap.getOrDefault(sChar,0)+1);
//                    hashMap1.put(tChar,tValue==null?1:++tValue);
//
//                }
//
//            }
//                char curr =s.charAt(i);
//                Integer value = hashMap.get(curr);
//                if(value==null){
//                    hashMap.put(curr,1);
//                }else{
//                    value ++;
//                    if (value ==0){
//                        hashMap.remove(curr);
//                    }else{
//                        hashMap.put(curr,value);
//                    }
//                }
//                char pair = t.charAt(i);
//                Integer pairValue = hashMap.get(pair);
//                if (pairValue == null){
//                    pairValue =-1;
//                    hashMap.put(pair,pairValue);
//                }else{
//                    pairValue--;
//                    if (pairValue==0){
//                        hashMap.remove(pair);
//                    }else{
//                        hashMap.put(pair,pairValue);
//                    }
//                }
//            }
//
//            return hashMap.size()==0;

//            return hashMap.equals(hashMap1);
            //======================================
//            int[] hash=new int[26];
//            char[] chars = s.toCharArray();
//            for (char aChar : chars) {
//                hash[aChar-'a']++;
//            }
//            char[] chars1 = t.toCharArray();
//            for (char c : chars1) {
//                hash[c-'a']--;
//            }
//            for (int i = 0; i < 26; i++) {
//                if(hash[i]!=0){
//                    return false;
//                }
//            }
//            return true;
            char[] chars = s.toCharArray();
            char[] chars1 = t.toCharArray();
            Arrays.sort(chars);
            Arrays.sort(chars1);
            return Arrays.equals(chars,chars1);
//            if(s==null || t==null ||s.length() != t.length())return  false;
//            int[] array = new int[26];
//            char[] chars = s.toCharArray();
//            char[] tChars = t.toCharArray();
//            for (char aChar : chars) {
//                array[aChar -'a']++;
//            }
//            for (char tChar :tChars){
//                array[tChar -'a']--;
//                if( array[tChar -'a']<0){
//                    return  false;
//                }
//            }
//            return true;
        }
        //https://leetcode.cn/problems/two-sum/ 01
        public int[] twoSum(int[] nums, int target) {
            if (nums.length<2) return null;
            Map<Integer,Integer>  map = new HashMap<>();
            for (int i = 0,j=nums.length-1; i < j; i++,j--) {
                if(nums[i] + nums[j] ==target) return  new int[]{i,j};
                int b = target -nums[i];
                int c = target -nums[j];
               if(map.containsKey(b))return new int[]{i,map.get(b)};
               if(map.containsKey(c))return new int[]{map.get(c),j};

                map.put(nums[i],i);
                map.put(nums[j],j);
            }
//            for (int i = 0; i < nums.length; i++) {
//                int b = target -nums[i];
//                int index =map.getOrDefault(b,-1);
//                if (index !=-1 && index != i){
//                    return  new int[]{i,map.get(b)};
//                }
//            }
            return null;

        }

        private static int[] getInts(Map<Integer, Integer> map, int i, int b) {
            int index = map.getOrDefault(b,-1);
            if (index !=-1 && index != i){
                return new int[]{i, map.get(b)};
            }
            return null;
        }

        public boolean isValidBST(TreeNode root) {

            List<Integer> list = new ArrayList<>();
           if( !isValidBST(root,list)){
               return false;
           }
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i)>=list.get(i+1)){
                    return  false;
                }
            }

            return true;


        }
        public boolean   isValidBST(TreeNode root,List<Integer> list ) {
            if(root ==null) return true;
            isValidBST(root.left,list);
            if(list.contains(root.val)){
                return false;
            }
            list.add(root.val);
             isValidBST(root.right, list);
             return  true;


        }

        TreeNode current =null;
        public boolean isValidBST1(TreeNode root) {
            if(root==null) return true;
            boolean leftTree = true;
            if(root.left!=null){
                leftTree = isValidBST(root.left);
            }
            if(current!=null){
                if(root.val>current.val){
                    current =root;
                }else{
                    return  false;
                }

            }else{
                current = root;
            }
            boolean rightTree = true;
            if(root.right!=null){
                rightTree = isValidBST(root.right);
            }

            return leftTree && rightTree;

//
//            List<Integer> list = new ArrayList<>();
//            if( !isValidBST(root,list)){
//                return false;
//            }
//            for (int i = 0; i < list.size()-1; i++) {
//                if (list.get(i)>=list.get(i+1)){
//                    return  false;
//                }
//            }
//
//            return true;


        }

    }


}

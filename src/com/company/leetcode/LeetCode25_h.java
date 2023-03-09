package com.company.leetcode;

public class LeetCode25_h {
//    https://leetcode.cn/problems/reverse-nodes-in-k-group/description/

    /**
     *  添加虚拟头节点 dummy 方便计算
     *  获取k步内有效链表
     *  翻转链表
     *  拼接翻转后的链表
     *  继续循环K步有效链表
     */
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
}

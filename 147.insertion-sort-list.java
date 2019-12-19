/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) { return null; }

        ListNode prev = head;
        ListNode current = head.next;
        do {
            ListNode nodePrev = null;
            ListNode node = head;
            while (node != current && node.val <= current.val) {
                nodePrev = node;
                node = node.next;
            }

            if (node == prev) {
                int tmp = node.val;
                node.val = current.val;
                current.val = tmp;
            } else if (node != current) {
                prev.next = current.next;
                current.next = node;
                if (nodePrev != null) {
                    nodePrev.next = current;
                } else {
                    head = current;
                }
                current = prev;
            }

            prev = current;
            current = current.next;
        } while (current != null);

        return head;
    }
}
// @lc code=end

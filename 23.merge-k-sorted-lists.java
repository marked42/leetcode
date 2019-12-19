import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value.val));

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode previous = head;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            previous.next = node;
            if (node.next != null) {
                pq.offer(node.next);
            }
            previous = node;
        }

        return head.next;
    }
}
// @lc code=end

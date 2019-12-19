import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (pq.peek() < num) {
                pq.poll();
                pq.offer(num);
            }
        }

        return pq.peek();
    }
}
// @lc code=end

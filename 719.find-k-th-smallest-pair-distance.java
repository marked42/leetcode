import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=719 lang=java
 *
 * [719] Find K-th Smallest Pair Distance
 */

// @lc code=start
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                pq.offer(Math.abs(nums[i] - nums[j]));
            }
        }

        while (k > 1) {
            pq.poll();
            k--;
        }

        return pq.peek();
    }
}
// @lc code=end

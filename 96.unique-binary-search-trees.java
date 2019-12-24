/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        int[] nums = new int[n + 1];

        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                nums[i] += nums[k - 1] * nums[i - k];
            }
        }

        return nums[n];
    }
}
// @lc code=end

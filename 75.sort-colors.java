/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public static final int RED = 0;
    public static final int WHITE = 1;
    public static final int BLUE = 2;

    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            while (nums[i] < WHITE) {
                i++;
            }

            while (nums[j] > WHITE) {
                j--;
            }

            if (nums[i] != nums[j]) {
                swap(nums, i, j);
                continue;
            }
        }

        int k = i + 1;
        while (k < j) {
            if (nums[k] == WHITE) {
                k++;
            } else if (nums[k] < WHITE) {
                swap(nums, k, i);
                i++;
                k++;
            } else {
                swap(nums, k, j);
                k++;
                j--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

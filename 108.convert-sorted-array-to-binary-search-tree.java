/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) { return null; }

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) { return null; }

        // choose upper median required by test cases and problem description implicitly
        int mid = low + (high + 1 - low) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, low, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, high);

        return node;
    }
}
// @lc code=end

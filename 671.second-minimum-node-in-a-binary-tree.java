/*
 * @lc app=leetcode id=671 lang=java
 *
 * [671] Second Minimum Node In a Binary Tree
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
    public Integer secondMinimum = null;

    public int findSecondMinimumValue(TreeNode root) {
        find(root);
        return secondMinimum == null ? -1 : secondMinimum;
    }

    public void find(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        if (root.val == root.left.val && root.val == root.right.val) {
            find(root.left);
            find(root.right);
        } else if (root.val == root.left.val) {
            if (secondMinimum == null || root.right.val < secondMinimum) {
                secondMinimum = root.right.val;
            }
            find(root.left);
        } else {
            if (secondMinimum == null || root.left.val < secondMinimum) {
                secondMinimum = root.left.val;
            }
            find(root.right);
        }
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) { return true; }

        if ((lower != null && root.val <= lower) || (upper != null && root.val >= upper)) {
            return false;
        }

        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }
}
// @lc code=end

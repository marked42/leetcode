/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
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
    public void flatten(TreeNode root) {
        if (root == null) { return; }

        flatten(root.left);
        flatten(root.right);

        if (root.left == null) {
            return;
        }

        TreeNode node = root.left;
        while (node.right != null) {
            node = node.right;
        }

        node.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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
    public final int unbalanced = -1;

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != unbalanced;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) { return 0; }

        int left = maxDepth(root.left);
        if (left == unbalanced) { return unbalanced; }

        int right = maxDepth(root.right);
        if (right == unbalanced) { return unbalanced; }

        if (Math.abs(left - right) > 1) { return unbalanced; }

        return 1 + Math.max(left, right);
    }
    // public boolean isBalanced(TreeNode root) {
    //     if (root == null) { return true; }

    //     return Math.abs(maxHeight(root.left) - maxHeight(root.right)) <= 1
    //         && isBalanced(root.left) && isBalanced(root.right);
    // }

    // public int maxHeight(TreeNode node) {
    //     if (node == null) { return 0; }

    //     return Math.max(maxHeight(node.left), maxHeight(node.right)) + 1;
    // }
}
// @lc code=end

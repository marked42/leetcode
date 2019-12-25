/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int sum) {
        if (root == null) { return 0; }

        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }

        return dfs(root.left, sum * 10 + root.val) + dfs(root.right, sum * 10 + root.val);
    }
}
// @lc code=end

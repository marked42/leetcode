import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=563 lang=java
 *
 * [563] Binary Tree Tilt
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
    public int findTilt(TreeNode root) {
        if (root == null) { return 0; }

        int tilt = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            tilt += Math.abs(sum(node.left) - sum(node.right));

            if (node.left != null) {
                stack.add(node.left);
            }

            if (node.right != null) {
                stack.add(node.right);
            }
        }

        return tilt;
    }

    public int sum(TreeNode root) {
        if (root == null) { return 0; }

        return root.val + sum(root.left) + sum(root.right);
    }
}
// @lc code=end

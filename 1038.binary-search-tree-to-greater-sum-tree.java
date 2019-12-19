/*
 * @lc app=leetcode id=1038 lang=java
 *
 * [1038] Binary Search Tree to Greater Sum Tree
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
    private TreeNode successor = null;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return root;
        }

        if (successor == null && root.right == null) {
            successor = root;
            return root;
        }

        bstToGst(root.right);
        root.val += successor.val;
        successor = root;
        bstToGst(root.left);

        return root;
    }
}
// @lc code=end

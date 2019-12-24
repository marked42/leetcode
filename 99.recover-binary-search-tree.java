/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    public void recoverTree(TreeNode root) {
        if (root == null) { return; }

        TreeNode first = null;
        TreeNode second = null;

        TreeNode prev = null;
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                if (prev != null && current.val < prev.val) {
                    if (first == null) {
                        first = prev;
                    }
                    second = current;
                }

                prev = current;
                current = current.right;
            } else {
                TreeNode predecessor = current.left;

                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // down
                if (predecessor.right == null) {
                    predecessor.right = current;

                    current = current.left;
                } else {
                    if (current.val < prev.val) {
                        if (first == null) {
                            first = prev;
                        }
                        second = current;
                    }

                    predecessor.right = null;
                    prev = current;
                    current = current.right;
                }
            }
        }

        swap(first, second);
    }

    static void swap(TreeNode left, TreeNode right) {
        Integer temp = left.val;
        left.val = right.val;
        right.val = temp;
    }
}
// @lc code=end

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversalIteratively(root);
    }

    public List<Integer> inorderTraversalRecursively(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return inorderTraversalRecursively(root, result);
    }

    public List<Integer> inorderTraversalRecursively(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }

        inorderTraversalRecursively(root.left, result);
        result.add(root.val);
        inorderTraversalRecursively(root.right, result);

        return result;
    }

    public List<Integer> inorderTraversalIteratively(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode next = root;

        while (next != null || !stack.isEmpty()) {
            while (next != null) {
                stack.add(next);
                next = next.left;
            }

            TreeNode top = stack.pop();
            result.add(top.val);
            next = top.right;
        }

        return result;
    }
}
// @lc code=end

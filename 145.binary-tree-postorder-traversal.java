import java.util.ArrayList;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode next = root;
        Integer last = null;

        while (next != null || !stack.isEmpty()) {
            while (next != null) {
                stack.add(next);
                next = next.left;
            }

            TreeNode node = stack.peek();
            if (node.right != null && (last == null || node.right.val != last)) {
                next = node.right;
                continue;
            }

            stack.pop();
            result.add(node.val);
            next = null;
            last = node.val;
        }

        return result;
    }
}
// @lc code=end

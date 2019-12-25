import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSum(root, sum, new Stack<Integer>());
        return result;
    }

    public void pathSum(TreeNode root, int sum, Stack<Integer> path) {
        if (root == null) { return; }

        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                result.add(new ArrayList<>(path));
            }
        }

        // if (root.left == null) {
        //     pathSum(root.right, sum - root.val, path, result);
        // } else if (root.right == null) {
        //     pathSum(root.left, sum - root.val, path, result);
        // } else {
        //     pathSum(root.left, sum - root.val, path, result);
        //     pathSum(root.right, sum - root.val, path, result);
        // }
        if (root.left != null) {
            pathSum(root.left, sum - root.val, path);
        }

        if (root.right != null) {
            pathSum(root.right, sum - root.val, path);
        }

        path.pop();
    }
}
// @lc code=end

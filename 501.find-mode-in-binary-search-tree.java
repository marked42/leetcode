import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
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
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        findMode(root, modes, 0, null);

        return modes.stream().mapToInt(val -> val).toArray();
    }

    public void findMode(TreeNode root, List<Integer> modes, int maxFrequency, Integer last) {

        findMode(root.left, modes, maxFrequency, last);
    }
}
// @lc code=end

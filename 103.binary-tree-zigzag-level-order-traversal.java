import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) { return result; }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean zig = true;
        while (!queue.isEmpty()) {
            List<Integer> nextLevelNodes = queue.stream().map(value -> value.val).collect(Collectors.toList());
            if (!zig) {
                Collections.reverse(nextLevelNodes);
            }
            result.add(nextLevelNodes);

            int childCount = queue.size();
            for (int i = 0; i < childCount; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            zig = !zig;
        }

        return result;
    }
}
// @lc code=end

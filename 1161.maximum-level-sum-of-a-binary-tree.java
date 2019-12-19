import java.util.Map;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=1161 lang=java
 *
 * [1161] Maximum Level Sum of a Binary Tree
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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.add(root);

        int sum = 0;
        int level = 1;
        int currentLevel = 1;

        while (!levelNodes.isEmpty()) {
            int currentLevelSum = 0;
            int size = levelNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = levelNodes.poll();
                currentLevelSum += node.val;

                if (node.left != null) { levelNodes.add(node.left); }
                if (node.right != null) { levelNodes.add(node.right); }
            }

            if (currentLevelSum > sum) {
                sum = currentLevelSum;
                level = currentLevel;
            }

            currentLevel++;
        }

        return level;
    }
}
// @lc code=end

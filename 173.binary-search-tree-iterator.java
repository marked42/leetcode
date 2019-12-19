/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
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
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode nextNode;
    private TreeNode nextTarget;

    public BSTIterator(TreeNode root) {
        this.nextTarget = root;
    }

    /** @return the nextTarget smallest number */
    public int next() {
        if (!hasNext()) {
            return -1;
        }

        int value = nextNode.val;
        nextNode = null;

        return value;
    }

    private void advance() {
        if (nextTarget != null || !stack.isEmpty()) {
            while (nextTarget != null) {
                stack.add(nextTarget);
                nextTarget = nextTarget.left;
            }

            nextNode = stack.pop();
            nextTarget = nextNode.right;
        }
    }

    /** @return whether we have a nextTarget smallest number */
    public boolean hasNext() {
        if (nextNode == null) {
            advance();
        }

        return nextNode != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

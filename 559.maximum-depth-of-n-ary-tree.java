/*
 * @lc app=leetcode id=559 lang=java
 *
 * [559] Maximum Depth of N-ary Tree
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        if (root == null) { return 0; }

        int depth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int childDepth = maxDepth(root.children.get(i));
            if (childDepth > depth) {
                depth = childDepth;
            }
        }

        return 1 + depth;
    }
}
// @lc code=end

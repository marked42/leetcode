/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        connect(root, null);
        return root;
    }

    public void connect(Node node, Node sibling) {
        if (node == null) {
            return;
        } else {
            node.next = sibling;
        }

        connect(node.left, node.right);
        connect(node.right, sibling == null ? null : sibling.left);
    }
}
// @lc code=end

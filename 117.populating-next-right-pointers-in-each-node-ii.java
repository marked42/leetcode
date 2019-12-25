/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
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
        if (root == null) { return null; }

        Node dummy = new Node(-1);
        Node prev = dummy;

        for (Node current = root; current != null; current = current.next) {
            if (current.left != null) {
                prev.next = current.left;
                prev = prev.next;
            }

            if (current.right != null) {
                prev.next = current.right;
                prev = prev.next;
            }
        }

        connect(dummy.next);

        return root;
    }
}
// @lc code=end

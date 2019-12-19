/*
 * @lc app=leetcode id=590 lang=java
 *
 * [590] N-ary Tree Postorder Traversal
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
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);

        return result;
    }

    public void postorder(Node root, List<Integer> result) {
        if (root == null) { return; }

        for (int i = 0; i < root.children.size(); i++) {
            postorder(root.children.get(i), result);
        }
        result.add(root.val);
    }
}
// @lc code=end

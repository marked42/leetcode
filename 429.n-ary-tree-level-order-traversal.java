import java.util.Queue;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) { return result; }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> childValues = new ArrayList<>();
            int childCount = queue.size();

            for (int i = 0; i < childCount; i++) {
                Node node = queue.poll();
                childValues.add(node.val);
                queue.addAll(node.children);
            }
            result.add(childValues);
        }

        return result;
    }
}
// @lc code=end

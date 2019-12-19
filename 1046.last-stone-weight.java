import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() >= 2) {
            int x = pq.poll();
            int y = pq.poll();

            if (x != y) {
                pq.offer(Math.abs(x - y));
            }
        }

        return pq.size() == 1 ? pq.poll() : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lastStoneWeight(new int[]{2,7,4,1,8,1});
    }
}
// @lc code=end

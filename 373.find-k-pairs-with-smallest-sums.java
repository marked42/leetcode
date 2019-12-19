import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=373 lang=java
 *
 * [373] Find K Pairs with Smallest Sums
 */

// @lc code=start
class Solution {
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(value -> nums1[value.first] + nums2[value.second]));

        for (int i = 0; i < nums1.length && nums2.length > 0; i++) {
            pq.offer(new Pair(i, 0));
        }

        List<List<Integer>> result = new ArrayList<>();

        while (k > 0 && !pq.isEmpty()) {
            Pair pair = pq.poll();
            result.add(Arrays.asList(nums1[pair.first], nums2[pair.second]));

            if (pair.second < nums2.length - 1) {
                pq.offer(new Pair(pair.first, pair.second + 1));
            }

            k--;
        }

        return result;
    }
}
// @lc code=end

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        // lambda as comparator will be 2 times slower
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return compareDistance(b, a);
            }
        });

        // check then add will be a litter faster than add then remove if size bigger than K
        for (int[] point : points) {
            if (queue.size() < K) {
                queue.offer(point);
                continue;
            }

            int[] head = queue.peek();
            if (compareDistance(point, head) < 0) {
                queue.remove();
                queue.offer(point);
            }
        }

        // toArray will be faster than iterative copy
        return queue.toArray(new int[K][2]);
    }

    // Integer.compareTo will be much slower than primitive type int
    public static int compareDistance(int[] left, int[] right) {
        int leftSquare = left[0] * left[0] + left[1] * left[1];
        int rightSquare = right[0] * right[0] + right[1] * right[1];

        return leftSquare - rightSquare;
    }
}
// @lc code=end

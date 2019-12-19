import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

/*
 * @lc app=leetcode id=1030 lang=java
 *
 * [1030] Matrix Cells in Distance Order
 */

// @lc code=start
class Solution {
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Map<Integer, List<int[]>> result = new HashMap<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int distance = Math.abs(i - r0) + Math.abs(j - c0);

                if (!result.containsKey(distance)) {
                    result.put(distance, new ArrayList<int[]>());
                }

                result.get(distance).add(new int[] { i, j });
            }
        }

        int[][] distArray = new int[R * C][];
        int k = 0;
        for (Integer i : result.keySet()) {
            for (int[] j : result.get(i)) {
                distArray[k++] = j;
            }
        }

        return distArray;
    }

    // public static int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
    //     int[][] result = new int[R * C][];

    //     int i = 0;
    //     result[i++] = new int[] { r0, c0 };
    //     for (int d = 1; r0 - d >= 0 || r0 + d < R || c0 - d >= 0 || c0 + d < C; d++) {
    //         if (r0 + d < R) {
    //             result[i++] = (new int[] { r0 + d, c0 });
    //         }

    //         if (r0 - d >= 0) {
    //             result[i++] = (new int[] { r0 - d, c0 });
    //         }

    //         if (c0 + d < C) {
    //             result[i++] = (new int[] { r0, c0 + d });
    //         }

    //         if (c0 - d >= 0) {
    //             result[i++] = (new int[] { r0, c0 - d });
    //         }

    //         for (int dist = 1; dist < d; dist++) {
    //             if (r0 + dist < R && c0 + (d - dist) < C) {
    //                 result[i++] = (new int[] { r0 + dist, c0 + (d - dist) });
    //             }

    //             if (r0 + dist < R && c0 - (d - dist) >= 0) {
    //                 result[i++] = (new int[] { r0 + dist, c0 - (d - dist) });
    //             }

    //             if (r0 - dist >= 0 && c0 + (d - dist) < C) {
    //                 result[i++] = (new int[] { r0 - dist, c0 + (d - dist) });
    //             }

    //             if (r0 - dist >= 0 && c0 - (d - dist) >= 0) {
    //                 result[i++] = (new int[] { r0 - dist, c0 - (d - dist) });
    //             }
    //         }
    //     }

    //     return result;
    // }
}
// @lc code=end

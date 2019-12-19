/*
 * @lc app=leetcode id=1042 lang=java
 *
 * [1042] Flower Planting With No Adjacent
 */

// @lc code=start
class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        List<Integer>[] graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < paths.length; i++) {
            graph[paths[i][0]].add(paths[i][1]);
            graph[paths[i][1]].add(paths[i][0]);
        }

        int[] colors = new int[N + 1];
        boolean[][] candidateColors = new boolean[N + 1][4];

        for (int i = 1; i <= N; i++) {
            for (int color = 1; color <= 4; color++) {
                // pick candidate color if not already rejected
                if (candidateColors[i][color - 1] == false) {
                    colors[i] = color;

                    for (int adjVertex : graph[i]) {
                        // reject candidate color for vertex
                        if (adjVertex > i) {
                            candidateColors[adjVertex][color - 1] = true;
                        }
                    }

                    break;
                }
            }
        }

        return Arrays.copyOfRange(colors, 1, N + 1);
    }
}
// @lc code=end

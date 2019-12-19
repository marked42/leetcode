import java.util.HashSet;

/*
 * @lc app=leetcode id=997 lang=java
 *
 * [997] Find the Town Judge
 */

// @lc code=start
class Solution {
    public int findJudge(int N, int[][] trust) {
        Set<Integer>[] trustersSet = new Set[N];
        boolean[] hasTrust = new boolean[N];
        for (int i = 0; i < N; i++) {
            trustersSet[i] = new HashSet<>();
        }

        for (int i = 0; i < trust.length; i++) {
            trustersSet[trust[i][1] - 1].add(trust[i][0]);
            hasTrust[trust[i][0] - 1] = true;
        }

        for (int i = 0; i < trustersSet.length; i++) {
            if (trustersSet[i].size() == N - 1 && !hasTrust[i]) {
                return i + 1;
            }
        }

        return -1;
    }
}
// @lc code=end

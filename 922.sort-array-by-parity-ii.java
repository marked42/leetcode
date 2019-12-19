/*
 * @lc app=leetcode id=922 lang=java
 *
 * [922] Sort Array By Parity II
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int odd = 1;
        int even = 0;

        while (even < A.length) {
            if (A[even] % 2 == 0) {
                even += 2;
                continue;
            }

            while (A[odd] % 2 == 1) {
                odd += 2;
            }

            swap(A, odd, even);
        }

        return A;
    }

    public static void swap(int[] A, int i, int j) {
        if (i == j) { return; }

        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
// @lc code=end

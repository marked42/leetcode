import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();
        for (int i : nums1) {
            num1Set.add(i);
        }

        Set<Integer> num2Set = new HashSet<>();
        for (int i : nums2) {
            if (num1Set.contains(i) && !num2Set.contains(i)) {
                num2Set.add(i);
            }
        }

        int[] result = new int[num2Set.size()];
        int i = 0;
        for (int value : num2Set) {
            result[i++] = value;
        }

        return result;
    }
}
// @lc code=end

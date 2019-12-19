import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> num1Set = new HashMap<>();
        for (int i : nums1) {
            int count = !num1Set.containsKey(i) ? 1 : num1Set.get(i) + 1;
            num1Set.put(i, count);
        }

        List<Integer> result = new ArrayList<>();
        for (int val : nums2) {
            if (num1Set.containsKey(val) && num1Set.get(val) > 0) {
                result.add(val);
                num1Set.put(val, num1Set.get(val) - 1);
            }
        }

        int[] subArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            subArray[i] = result.get(i);
        }

        return subArray;
    }
}
// @lc code=end

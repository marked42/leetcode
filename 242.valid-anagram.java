import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);
           int count = !countMap.containsKey(c) ? 1 : countMap.get(c) + 1;
           countMap.put(c, count);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!countMap.containsKey(c) || countMap.get(c) < 0) {
                return false;
            }

            int count = countMap.get(c);
            if (count == 1) {
                countMap.remove(c);
            } else {
                countMap.put(c, count - 1);
            }
        }

        return countMap.size() == 0;
    }
}
// @lc code=end

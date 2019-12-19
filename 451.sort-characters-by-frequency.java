import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (Character character : s.toCharArray()) {
            frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((left, right) -> {
            return right.getValue().compareTo(left.getValue());
        });

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();

            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}
// @lc code=end

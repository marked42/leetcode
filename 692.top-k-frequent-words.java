import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        Comparator<Map.Entry<String, Integer>> comparator = (left, right) -> {
            int same = left.getValue().compareTo(right.getValue());

            if (same != 0) {
                return same;
            }

            return right.getKey().compareTo(left.getKey());
        };
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(comparator);

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            } else if (comparator.compare(pq.peek(), entry) < 0) {
                pq.poll();
                pq.offer(entry);
            }
        }

        List<String> result = pq.stream()
                .sorted((left, right) -> {
                    int same = right.getValue().compareTo(left.getValue());

                    if (same != 0) {
                        return same;
                    }

                    return left.getKey().compareTo(right.getKey());
                })
                .map(val -> val.getKey())
                .collect(Collectors.toList());

        System.out.println(result);

        return result;
    }
}
// @lc code=end

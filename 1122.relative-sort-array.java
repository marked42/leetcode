import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=1122 lang=java
 *
 * [1122] Relative Sort Array
 */

// @lc code=start
class Solution {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> orderMap = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            orderMap.put(arr2[i], i);
        }

        Comparator<Integer> comparator = (left, right) -> {
            if (orderMap.containsKey(left) && !orderMap.containsKey(right)) {
                return -1;
            } else if (!orderMap.containsKey(left) && orderMap.containsKey(right)) {
                return 1;
            } else if (orderMap.containsKey(left) && orderMap.containsKey(right)) {
                return orderMap.get(left).compareTo(orderMap.get(right));
            } else {
                return left.compareTo(right);
            }
        };

        Integer[] what = Arrays.stream(arr1).boxed().toArray( Integer[]::new );
        Arrays.sort(what, comparator);
        int[] result = Arrays.asList(what).stream().mapToInt(i -> i).toArray();
        return result;
    }
}
// @lc code=end

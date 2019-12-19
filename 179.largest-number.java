import java.util.HashMap;
import java.util.Map;

import jdk.internal.joptsimple.internal.Strings;

/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
    /**
     * <ul>
     * <li>
     * when use getDigitsLength directly, for such a quicker integer operation than Map
     * read/write operation, it slows down performance when using Map as a cache.
     * 3ms 98.95% (direct getDigitsLength call) vs 7ms (map cache)
     * </li>
     *
     * <li>
     * for custom comparator, its quicker to use integer comparison than string comparison.
     * </li>
     * </ul>
     */
    public String largestNumber(int[] nums) {
        Integer[] numsArray = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsArray[i] = nums[i];
        }

        // string comparison
        //     Arrays.sort(chars, new Comparator<String>(){
        //         @Override
        //         public int compare(String c1, String c2)
        //         {
        //             String s1 = c1 + c2;
        //             String s2 = c2 + c1;
        //             return s2.compareTo(s1);
        //         }
        //     });

        Arrays.sort(numsArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int aLength = getDigitsLength(a);
                int bLength = getDigitsLength(b);

                if (aLength == bLength) {
                    return b - a;
                }

                return (b * (int)Math.pow(10, aLength) + a) - (a * (int)Math.pow(10, bLength) + b);

            }
        });

        StringBuilder sb = new StringBuilder();
        for (int num : numsArray) {
            sb.append(num);
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }

    public int getDigitsLength(int num) {
        int i = 1;
        int limit = 10;
        while (limit <= num) {
            limit *= 10;
            i++;
        }

        return i;
    }
}
// @lc code=end

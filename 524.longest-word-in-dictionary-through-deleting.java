import java.util.Map;

/*
 * @lc app=leetcode id=524 lang=java
 *
 * [524] Longest Word in Dictionary through Deleting
 */

// @lc code=start
class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String word : d) {
            boolean longerOrLexicographicallySmaller = word.length() > longestWord.length()
                || (word.length() == longestWord.length() && word.compareTo(longestWord) < 0);

            if (longerOrLexicographicallySmaller && canBuildThroughDeleting(s, word)) {
                longestWord = word;
            }
        }

        return longestWord;
    }

    public static boolean canBuildThroughDeleting(String source, String target) {
        if (source.length() < target.length()) {
            return false;
        }

        if (source.equals(target)) { return true; }

        int j = 0;
        for (int i = 0; i < source.length() && j < target.length(); i++) {
            if (source.charAt(i) == target.charAt(j)) {
                j++;
            }
        }

        return j == target.length();
    }
}

// @lc code=end

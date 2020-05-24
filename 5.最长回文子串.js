/*
 * @lc app=leetcode.cn id=5 lang=javascript
 *
 * [5] 最长回文子串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
  let dp = new Array(s.length)

  let maxSubstr = ''

  for (let start = s.length - 1; start >= 0; start--) {
    for (let end = s.length - 1; end >= start; end--) {
      const len = end + 1 - start
      dp[end] = (len <= 2 || dp[end-1]) && s.charAt(start) === s.charAt(end)

      if (dp[end] && len > maxSubstr.length) {
        maxSubstr = s.substring(start, end + 1)
      }
    }
  }

  return maxSubstr
};
// @lc code=end

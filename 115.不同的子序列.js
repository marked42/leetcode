/*
 * @lc app=leetcode.cn id=115 lang=javascript
 *
 * [115] 不同的子序列
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var numDistinct = function(s, t) {
  const dp = new Array(t.length + 1)
  dp[0] = 1
  dp.fill(1, 0)

  for (let i = 1; i < s.length; i++) {
    for (let j = 1; j < t.length; j++) {
      dp[j] += s[i-1] === t[j-1] ? dp[j-1] : 0
    }
  }

  return dp[t.length]
};
// @lc code=end

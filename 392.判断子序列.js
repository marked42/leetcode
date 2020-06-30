/*
 * @lc app=leetcode.cn id=392 lang=javascript
 *
 * [392] 判断子序列
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function(s, t) {
  const dp = new Array(s.length + 1)
  dp[0] = true
  dp.fill(false, 1)

  for (let i = 1; i <= t.length; i++) {
    for (let j = s.length; j >= 1; j--) {
      const same = t[i-1] === s[j-1]
      dp[j] = same ? (dp[j] || dp[j-1]) : dp[j]
    }
  }

  return dp[dp.length - 1]
};
// @lc code=end

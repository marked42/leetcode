/*
 * @lc app=leetcode.cn id=91 lang=javascript
 *
 * [91] 解码方法
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
  const dp = new Array(s.length + 1)
  dp[s.length] = 1
  dp[s.length - 1] = s[s.length - 1] === '0' ? 0 : 1

  for (let i = s.length - 2; i >= 0; i--) {
    if (s[i] === '0') {
      dp[i] = 0
    } else {
      dp[i] = (Number.parseInt(s.substr(i, 2)) <= 26) ? (dp[i+1] + dp[i+2]) : dp[i+1]
    }
  }

  return dp[0]
};
// @lc code=end

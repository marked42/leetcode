/*
 * @lc app=leetcode.cn id=139 lang=javascript
 *
 * [139] 单词拆分
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function(s, wordDict) {
  const dp = new Array(s.length + 1)
  dp[0] = true
  dp.fill(false, 1)

  const breakpoints = []
  for (let i = 1; i < dp.length; i++) {
    breakpoints[i] = []
    for (let word of wordDict) {
      const j = i - word.length
      if (dp[j] && word === s.substring(j, i)) {
        dp[i] = true
        breakpoints[i].push(j)
      }
    }
  }

  return dp[dp.length - 1]
};
// @lc code=end

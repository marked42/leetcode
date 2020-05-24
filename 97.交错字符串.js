/*
 * @lc app=leetcode.cn id=97 lang=javascript
 *
 * [97] 交错字符串
 */

// @lc code=start
/**
 * @param {string} s1
 * @param {string} s2
 * @param {string} s3
 * @return {boolean}
 */
var isInterleave = function(s1, s2, s3) {
  const s1Length = s1.length
  const s2Length = s2.length
  const s3Length = s3.length

  if (s1Length + s2Length !== s3Length) {
    return false
  }

  const dp = new Array(s1Length+1)
  for (let i = 0; i < s1Length+1; i++) {
    dp[i] = new Array(s2Length+1)
  }
  // 1. 空串拼凑空串
  dp[0][0] = true
  for (let i = 1; i < s1Length+1; i++) {
    dp[i][0] = dp[i-1][0] && s1[i-1] === s3[i-1]
  }
  for (let i = 1; i < s2Length+1; i++) {
    dp[0][i] = dp[0][i-1] && s2[i-1] === s3[i-1]
  }

  for (let i = 1; i < s1Length + 1; i++) {
    for (let j = 1; j < s2Length + 1; j++) {
      const s1SubProblem = s1[i-1] === s3[i+j-1] && dp[i-1][j]
      const s2SubProblem = s2[j-1] === s3[i+j-1] && dp[i][j-1]
      dp[i][j] = s1SubProblem || s2SubProblem
    }
  }

  return dp[s1Length][s2Length]
};
// @lc code=end

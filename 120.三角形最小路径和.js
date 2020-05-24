/*
 * @lc app=leetcode.cn id=120 lang=javascript
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function(triangle) {
  const dp = Array.from(triangle[triangle.length - 1])

  for (let row = triangle.length - 2; row >= 0; row--) {
    for (let col = 0; col <= row; col++) {
      dp[col] = triangle[row][col] + Math.min(dp[col], dp[col+1])
    }
  }

  return dp[0]
};
// @lc code=end

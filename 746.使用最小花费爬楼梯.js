/*
 * @lc app=leetcode.cn id=746 lang=javascript
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
  const dp = [...cost, 0]

  for (let i = 2; i < dp.length; i++) {
    dp[i] = Math.min(dp[i-1], dp[i-2]) + dp[i]
  }

  return dp[dp.length - 1]
};
// @lc code=end

/*
 * @lc app=leetcode.cn id=53 lang=javascript
 *
 * [53] 最大子序和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
  let sum = nums[0]
  let left = 0;
  let right = 0;

  function sum(nums, from, to) {
    return nums.slice(from, to + 1).reduce((sum, val) => sum + val, 0)
  }

  for (let i = 1; i < nums.length; i++) {
    if (sum < 0) {
      left = right = i
      sum = nums[i]
    } else {
      sum(j+1, i)
    }
  }
};
// @lc code=end

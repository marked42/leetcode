/*
 * @lc app=leetcode.cn id=56 lang=javascript
 *
 * [56] 合并区间
 */

// @lc code=start
/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
  function mergeTwo(one, another) {
    if (one[1] < another[0] || one[0] > another[1]) {
      return { overlaps: false }
    }

    return { overlaps: true, merged: [Math.min(one[0], another[0]), Math.max(one[1], another[1])]}
  }

  const result = []

  while (intervals.length > 0) {
    let one = intervals.shift()

    const separateElements = []
    for (const other of intervals) {
      const { overlaps, merged } = mergeTwo(one, other)

      if (!overlaps) {
        separateElements.push(other)
      } else {
        one = merged
      }
    }

    if (separateElements.length === intervals.length) {
      result.push(one)
    } else {
      intervals = [one, ...separateElements]
    }
  }

  return result
};
// @lc code=end

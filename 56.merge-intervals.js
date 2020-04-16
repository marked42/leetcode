/*
 * @lc app=leetcode id=56 lang=javascript
 *
 * [56] Merge Intervals
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

var merge1 = function(intervals) {
  function mergeTwo(one, another) {
    if (one[1] < another[0] || one[0] > another[1]) {
      return { overlaps: false }
    }

    return { overlaps: true, merged: [Math.min(one[0], another[0]), Math.max(one[1], another[1])]}
  }

  const result = []
  let one
  while (intervals.length > 0) {
    if (!one) {
      one = intervals.shift()
    }

    const newIntervals = []
    for (const other of intervals) {
      const { overlaps, merged } = mergeTwo(one, other)
      if (overlaps) {
        one = merged
      } else {
        newIntervals.push(other)
      }
    }

    if (newIntervals.length === intervals.length) {
      result.push(one)
      one = undefined
    } else {
      intervals = newIntervals
    }
  }
  if (one) {
    result.push(one)
  }

  return result
};

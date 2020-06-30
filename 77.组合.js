/*
 * @lc app=leetcode.cn id=77 lang=javascript
 *
 * [77] 组合
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
// var combine = function(n, k) {
//   if (k === 0) {
//     return [[]]
//   }

//   if (k >= n) {
//     return [Array.from({ length: n }).map((_, i) => i + 1)]
//   }

//   return [
//     ...combine(n-1, k-1).map(val => [...val, n]),
//     ...combine(n-1, k),
//   ]
// };
var combine = function(n, k) {
  function traverse(start, path, result) {
    if (path.length === k) {
      result.push([...path])
    }

    for (let i = start + 1; i < n + 1; i++) {
      path.push(i)
      traverse(i + 1, path)
      path.pop(i)
    }
  }

  const path = []
  const result = []
  traverse(1, path, result)

  return result
}
// @lc code=end

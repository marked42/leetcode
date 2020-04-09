/*
 * @lc app=leetcode id=22 lang=javascript
 *
 * [22] Generate Parentheses
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    const cache = new Map()
    cache.set(0, [""])
    cache.set(1, ["()"])

    if (cache.has(n)) {
      return cache.get(n)
    }

    function compose(left, right) {
      const leftPairs = generateParenthesis(left)
      const rightPairs = generateParenthesis(right)

      const result = []
      for (let i = 0; i < leftPairs.length; i++) {
        for (let j = 0; j < rightPairs.length; j++) {
          result[(i + 1) * (j + 1) - 1] = `(${leftPairs[i]})${rightPairs[j]}`
        }
      }
      return result
    }

    let result = []
    for (let i = 0; i <= n - 1; i++) {
      result = [...result, ...compose(n - 1 - i, i)]
    }

    cache.set(n, result)
    return result
};
// @lc code=end

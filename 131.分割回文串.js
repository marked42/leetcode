/*
 * @lc app=leetcode.cn id=131 lang=javascript
 *
 * [131] 分割回文串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function(s) {
  function isPalindromic(str, start, end) {
    while (start < end) {
      if (str.charAt(start) !== str.charAt(end)) {
        return false
      }
      start++
      end--
    }

    return true
  }

  function partitionImpl(s, start) {
    if (start === s.length) {
      return [[]]
    }

    let ans = []
    for (let i = start; i < s.length; i++) {
      if (isPalindromic(s, start, i)) {
        const left = s.substring(start, i + 1)
        const right = partitionImpl(s, i + 1)
        ans = ans.concat(right.map(items => [left, ...items]))
      }
    }

    return ans
  }
  // return partitionImpl(s, 0)

  function partitionImpl2(s) {
    const result = []
    function partitionTraceback(s, start, visitedPalindromes = [], result) {
      if (start === s.length) {
        result.push([...visitedPalindromes])
        return
      }

      for (let i = start; i < s.length; i++) {
        if (isPalindromic(s, start, i)) {
          const left = s.substring(start, i + 1)
          visitedPalindromes.push(left)
          partitionTraceback(s, i + 1, visitedPalindromes, result)
          visitedPalindromes.pop()
        }
      }
    }

    partitionTraceback(s, 0, undefined, result)
    return result
  }

  return partitionImpl2(s)
};
// @lc code=end

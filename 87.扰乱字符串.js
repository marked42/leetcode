/*
 * @lc app=leetcode.cn id=87 lang=javascript
 *
 * [87] 扰乱字符串
 */

// @lc code=start
/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var isScramble = function(s1, s2) {
  if (s1.length !== s2.length) { return false }
  const s1Array = s1.split("").sort()
  const s2Array = s2.split("").sort()

  return s1Array.every((char, i) => char === s2Array[i])
};
// @lc code=end

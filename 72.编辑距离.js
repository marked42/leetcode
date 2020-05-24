/*
 * @lc app=leetcode.cn id=72 lang=javascript
 *
 * [72] 编辑距离
 */

// @lc code=start
/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function(word1, word2) {
  function minDistance1(word1, word2) {
    // 规模增加1相当于在前边word1,word2前边增加一个字符，防止处理边界情况
    // 1. 其中一个字符串为空
    // 2. 初始化的dp[0][0] 可能是0(第一个字符相同)或者1（第一个字符不同）
    const ROW_COUNT = word1.length + 1
    const COL_COUNT = word2.length + 1

    const dp = new Array(ROW_COUNT)
    for (let row = 0; row < ROW_COUNT; row++) {
      dp[row] = new Array(COL_COUNT)
      dp[row][0] = row
    }
    for (let col = 1; col < COL_COUNT; col++) {
      dp[0][col] = col
    }

    for (let row = 1; row < ROW_COUNT; row++) {
      for (let col = 1; col < COL_COUNT; col++) {
        const left = dp[row][col-1] + 1
        const top = dp[row-1][col] + 1
        // dp规模比字符串大1，所以去字符时下标减1
        const same = word1.charAt(row - 1) === word2.charAt(col - 1)
        const diag = dp[row-1][col-1] + (same ? 0 : 1)
        dp[row][col] = Math.min(left, top, diag)
      }
    }

    return dp[ROW_COUNT-1][COL_COUNT-1]
  }

  return minDistance1(word1, word2)
};
// @lc code=end

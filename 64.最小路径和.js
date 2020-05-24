/*
 * @lc app=leetcode.cn id=64 lang=javascript
 *
 * [64] 最小路径和
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
  /**
   * too slow
   * @param {*} grid
   */
  function minPathSum1(grid) {
    function minPathSumImpl(grid, row, col) {
      const ROW_COUNT = grid.length
      const COL_COUNT = grid[0].length

      if (row === ROW_COUNT - 1 && col === COL_COUNT - 1) {
        return grid[row][col]
      }

      if (row === ROW_COUNT || col === COL_COUNT)  {
        return Number.MAX_VALUE
      }

      return grid[row][col] + Math.min(minPathSum(grid, row, col + 1), minPathSum(grid, row + 1, col))
    }

    return minPathSumImpl(grid, 0, 0)
  }

  /**
   * in-place dp
   * @param {string} grid input test
   */
  function minPathSum2(grid) {
    const COLUMN_COUNT = grid[0].length

    for (let row = 1; row < ROW_COUNT; row++) {
      grid[row][0] += grid[row-1][0]
    }

    for (let col = 1; col < COLUMN_COUNT; col++) {
      grid[0][col] += grid[0][col-1]
    }

    for (let row = 1; row < ROW_COUNT; row++) {
      for (let col = 1; col < COLUMN_COUNT; col++) {
        grid[row][col] += Math.min(grid[row-1][col], grid[row][col-1])
      }
    }

    const lastRow = grid[ROW_COUNT - 1]
    return lastRow[COLUMN_COUNT - 1]
  }

  function minPathSum3(grid) {
    const ROW_COUNT = grid.length
    const COL_COUNT = grid[0].length

    const dp = new Array(COL_COUNT)

    for (let row = 0; row < ROW_COUNT; row++) {
      for (let col = 0; col < COL_COUNT; col++) {
        if (row === 0 && col === 0) {
          dp[0] = grid[row][col]
        } else {
          dp[col] = grid[row][col] + Math.min(dp[col] !== undefined ? dp[col] : Number.MAX_VALUE,
            dp[col-1] !== undefined ? dp[col-1] : Number.MAX_VALUE)
        }
      }
    }

    return dp[COL_COUNT - 1]
  }

  return minPathSum3(grid)
};
// @lc code=end

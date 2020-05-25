/*
 * @lc app=leetcode.cn id=140 lang=javascript
 *
 * [140] 单词拆分 II
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {string[]}
 */
var wordBreak = function(s, wordDict) {
  const dp = new Array(s.length + 1)
  dp[0] = true
  dp.fill(false, 1)

  const breakpoints = []
  for (let i = 1; i < dp.length; i++) {
    breakpoints[i] = []
    for (let word of wordDict) {
      const j = i - word.length
      if (dp[j] && word === s.substring(j, i)) {
        dp[i] = true
        breakpoints[i].push(j)
      }
    }
  }

  console.log('breakpoints: ', breakpoints)
  function genResult(breakpoints, s) {
    let result = [[breakpoints.length-1]]

    while (result.some(r => r[0] !== 0)) {
      let tempResult = []

      for (let i = 0; i < result.length; i++) {
        const val = result[i]
        const [left, ...rest] = val
        if (left !== 0) {
          tempResult = tempResult.concat(breakpoints[left].map(b => ([b, left, ...rest])))
        } else {
          tempResult.push(val)
        }
      }

      result = tempResult
    }

    const words = result.map(points => points.slice(0, points.length - 1).map((point, index) => s.substring(point, points[index+1])).join(" "))
    return words
  }

  function dfsGenResult() {
    const result = []
    function dfs(path, breakpoints, result) {
      const pathEnd = path[path.length - 1]

      if (pathEnd === 0) {
        result.push([...path])
        return
      }

      for (let step of breakpoints[pathEnd]) {
        path.push(step)
        dfs(path, breakpoints, result)
        path.pop()
      }
    }
    dfs([breakpoints.length - 1], breakpoints, result)

    const words = result.map(points => points.reverse().slice(0, points.length - 1).map((point, index) => s.substring(point, points[index+1])).join(" "))
    return words
  }

  return dfsGenResult()
};
// @lc code=end

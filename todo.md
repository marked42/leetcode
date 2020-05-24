# TODO

# 53 最大子序列和

https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-cshi-xian-si-chong-jie-fa-bao-li-f/

# 5 最长回文子序列

1. 暴力破解
1. 最长公共子序列
1. 动态规划（按长度，逆序，优化空间到线性）
1. 从中间扩展
1. manacher's algorithm

# 131 切割回文字符串

1. 切分为子问题，左边是一个回文字符串，拼凑右边字符串对应子问题的结果得到原问题的结果。
1. 回溯法：从左到右不断切割回文子串，并用栈记录，一层调用嵌套加深一层，知道右侧子串为空递归结束，这时栈中内容就是一个回文子串的切分结果；之后向上回溯，完成一个调用栈进行一次出栈操作

# 132 回文字符串最小切割数

1. 分治法，
1. 回溯，
1. 中心扩展

# 二维问题

## 120 三角形最小路径和

## 64 最小路径和
  1. 滚动数组，状态压缩？
  1. 递归法 缺点是重复计算、嵌套层数可能很多

## 72 编辑距离

1. 注意边界条件

## 97 交错字符串

注意边界条件
定义f(i, j)表示子问题字符串`s1[0, i]`和`s2[0,j]`交错组成`s3[0, i+j+1]`，分解成子问题

```js
f(i,j) = s1[i] === s3[i+j+1] && f(i-1,j) || s2[j] === s3[i+j+1] && f(i, j-1)
```

注意边界条件，

1. f(-1, j)表示s1前缀（空串）和s2能否组成s3前缀，对应动态规划数组第一行
1. 相应的f(i,-1)对应第一列
1. f(-1, -1)对应左上角，对应子问题s1(空串)和s2（空串）能否交错组成s3（空串），结果是true

使用的动态规划二位数组长度是`[s1.length+1][s2.length+1]`，

此问题可以进行状态压缩，使用一维数组。

## 87 扰乱字符串？

三维dp，为什么不能排序对比？

## 91 解码方法
## 639 解码方法2
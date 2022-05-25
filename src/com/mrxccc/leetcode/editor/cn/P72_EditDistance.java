package com.mrxccc.leetcode.editor.cn;

/**
<p>给你两个单词&nbsp;<code>word1</code> 和&nbsp;<code>word2</code>， <em>请返回将&nbsp;<code>word1</code>&nbsp;转换成&nbsp;<code>word2</code> 所使用的最少操作数</em> &nbsp;。</p>

<p>你可以对一个单词进行如下三种操作：</p>

<ul>
	<li>插入一个字符</li>
	<li>删除一个字符</li>
	<li>替换一个字符</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>word1 = "horse", word2 = "ros"
<strong>输出：</strong>3
<strong>解释：</strong>
horse -&gt; rorse (将 'h' 替换为 'r')
rorse -&gt; rose (删除 'r')
rose -&gt; ros (删除 'e')
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>word1 = "intention", word2 = "execution"
<strong>输出：</strong>5
<strong>解释：</strong>
intention -&gt; inention (删除 't')
inention -&gt; enention (将 'i' 替换为 'e')
enention -&gt; exention (将 'n' 替换为 'x')
exention -&gt; exection (将 'n' 替换为 'c')
exection -&gt; execution (插入 'u')
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= word1.length, word2.length &lt;= 500</code></li>
	<li><code>word1</code> 和 <code>word2</code> 由小写英文字母组成</li>
</ul>
<div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 2395</li><li>👎 0</li></div>
*/

import java.util.Arrays;

/**
 * 编辑距离
 *
 * @author saint
 */
public class P72_EditDistance{
    public static void main(String[] args) {
        Solution solution = new P72_EditDistance().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * if s1[i] == s2[j]:
     *     啥都别做（skip）
     *     i, j 同时向前移动
     * else:
     *     三选一：
     *         插入（insert）
     *         删除（delete）
     *         替换（replace
     */
    //        dp(s1, i, s2, j - 1) + 1,    // 插入
    //        dp(s1, i - 1, s2, j) + 1,    // 删除
    //        dp(s1, i - 1, s2, j - 1) + 1 // 替换
    //        dp(s1, i -1 , s2, j - 1)     // 跳过
class Solution {
        // 备忘录
    int[][] memo;
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // 备忘录初始化为特殊值，代表还未计算
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s1,m,s2,n);
    }

    // 定义：返回 s1[0..i] 和 s2[0..j] 的最小编辑距离
    int dp(String s1, int i, String s2, int j) {
        // base case
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;

        if (s1.charAt(i) == s2.charAt(j)){
            return dp(s1, i -1 , s2, j - 1);
        } else {
            memo[i][j] =  min(
                    dp(s1, i, s2, j - 1) + 1,
                    dp(s1, i - 1, s2, j) + 1,
                    dp(s1, i - 1, s2, j - 1) + 1
            );
        }
        return memo[i][j];
    }

    int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

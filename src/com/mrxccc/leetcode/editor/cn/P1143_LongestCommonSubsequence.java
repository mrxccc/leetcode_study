package com.mrxccc.leetcode.editor.cn;

/**
<p>给定两个字符串 <code>text1</code> 和 <code>text2</code>，返回这两个字符串的最长 <strong>公共子序列</strong> 的长度。如果不存在 <strong>公共子序列</strong> ，返回 <code>0</code> 。</p>

<p>一个字符串的 <strong>子序列</strong><em> </em>是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。</p>

<ul>
	<li>例如，<code>"ace"</code> 是 <code>"abcde"</code> 的子序列，但 <code>"aec"</code> 不是 <code>"abcde"</code> 的子序列。</li>
</ul>

<p>两个字符串的 <strong>公共子序列</strong> 是这两个字符串所共同拥有的子序列。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>text1 = "abcde", text2 = "ace" 
<strong>输出：</strong>3  
<strong>解释：</strong>最长公共子序列是 "ace" ，它的长度为 3 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>text1 = "abc", text2 = "abc"
<strong>输出：</strong>3
<strong>解释：</strong>最长公共子序列是 "abc" ，它的长度为 3 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>text1 = "abc", text2 = "def"
<strong>输出：</strong>0
<strong>解释：</strong>两个字符串没有公共子序列，返回 0 。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= text1.length, text2.length <= 1000</code></li>
	<li><code>text1</code> 和 <code>text2</code> 仅由小写英文字符组成。</li>
</ul>
<div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 990</li><li>👎 0</li></div>
*/

import java.util.Arrays;

/**
 * 最长公共子序列
 *
 * @author saint
 */
public class P1143_LongestCommonSubsequence{
    public static void main(String[] args) {
        Solution solution = new P1143_LongestCommonSubsequence().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] memo;
    public int longestCommonSubsequence(String s1, String s2) {
        // 备忘录初始化为特殊值，代表还未计算
        memo = new int[s1.length()][s2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s1,0,s2,0);
    }

        int dp(String s1, int i, String s2, int j) {
            // base case
            if (i == s1.length() || j == s2.length()){
                return 0;
            }
            // 如果之前计算过，则直接返回备忘录中的答案
            if (memo[i][j] != -1) {
                memo[i][j] =  memo[i][j];
            }
            if (s1.charAt(i) == s2.charAt(j)){
                return dp(s1, i + 1 , s2, j + 1) + 1;
            } else {
                // s1[i] 和 s2[j] 至少有一个不在 lcs 中
                memo[i][j] = Math.max(dp(s1, i, s2, j + 1),
                        dp(s1, i + 1, s2, j));
            }
            return memo[i][j];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}

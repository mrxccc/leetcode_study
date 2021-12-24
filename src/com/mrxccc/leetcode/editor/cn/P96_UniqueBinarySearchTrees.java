package com.mrxccc.leetcode.editor.cn;

/**
<p>给你一个整数 <code>n</code> ，求恰由 <code>n</code> 个节点组成且节点值从 <code>1</code> 到 <code>n</code> 互不相同的 <strong>二叉搜索树</strong> 有多少种？返回满足题意的二叉搜索树的种数。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg" style="width: 600px; height: 148px;" />
<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>5
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 19</code></li>
</ul>
<div><div>Related Topics</div><div><li>树</li><li>二叉搜索树</li><li>数学</li><li>动态规划</li><li>二叉树</li></div></div><br><div><li>👍 1450</li><li>👎 0</li></div>
*/
/**
 * 不同的二叉搜索树
 *
 * @author saint
 */
public class P96_UniqueBinarySearchTrees{
    public static void main(String[] args) {
        Solution solution = new P96_UniqueBinarySearchTrees().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;
        public int numTrees(int n) {
            // 备忘录的值初始化为 0
            memo = new int[n + 1][n + 1];
            return count(1,n);
        }

        private int count(int lo, int hi) {
            if (lo > hi) return 1;
            // 查备忘录
            if (memo[lo][hi] != 0) {
                return memo[lo][hi];
            }
            int res = 0;
            for (int i = lo; i <= hi; i++){
                int left = count(lo,i-1);
                int right = count(i + 1, hi);
                res += left*right;
            }
            // 将结果存入备忘录
            memo[lo][hi] = res;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

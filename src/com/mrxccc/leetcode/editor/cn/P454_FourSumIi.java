package com.mrxccc.leetcode.editor.cn;

/**
<p>给你四个整数数组 <code>nums1</code>、<code>nums2</code>、<code>nums3</code> 和 <code>nums4</code> ，数组长度都是 <code>n</code> ，请你计算有多少个元组 <code>(i, j, k, l)</code> 能满足：</p>

<ul> 
 <li><code>0 &lt;= i, j, k, l &lt; n</code></li> 
 <li><code>nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
<strong>输出：</strong>2
<strong>解释：</strong>
两个元组如下：
1. (0, 0, 0, 1) -&gt; nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -&gt; nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p>&nbsp; <strong>提示：</strong></p>

<ul> 
 <li><code>n == nums1.length</code></li> 
 <li><code>n == nums2.length</code></li> 
 <li><code>n == nums3.length</code></li> 
 <li><code>n == nums4.length</code></li> 
 <li><code>1 &lt;= n &lt;= 200</code></li> 
 <li><code>-2<sup>28</sup> &lt;= nums1[i], nums2[i], nums3[i], nums4[i] &lt;= 2<sup>28</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li></div></div><br><div><li>👍 878</li><li>👎 0</li></div>
*/

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加 II
 *
 * @author saint
 */
public class P454_FourSumIi{
    public static void main(String[] args) {
        Solution solution = new P454_FourSumIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(0 - i - j, 0);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

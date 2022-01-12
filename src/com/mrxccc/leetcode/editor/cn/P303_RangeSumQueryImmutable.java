package com.mrxccc.leetcode.editor.cn;

/**
 * <p>给定一个整数数组  <code>nums</code>，求出数组从索引 <code>i</code><em> </em>到 <code>j</code>（<code>i ≤ j</code>）范围内元素的总和，包含 <code>i</code>、<code>j </code>两点。</p>
 *
 * <div class="original__bRMd">
 * <div>
 * <p>实现 <code>NumArray</code> 类：</p>
 *
 * <ul>
 * <li><code>NumArray(int[] nums)</code> 使用数组 <code>nums</code> 初始化对象</li>
 * <li><code>int sumRange(int i, int j)</code> 返回数组 <code>nums</code> 从索引 <code>i</code><em> </em>到 <code>j</code><em>（</em><code>i ≤ j</code>）范围内元素的总和，包含 <code>i</code>、<code>j </code>两点（也就是 <code>sum(nums[i], nums[i + 1], ... , nums[j])</code>）</li>
 * </ul>
 *
 * <p> </p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * <strong>输出：
 * </strong>[null, 1, -1, -3]
 *
 * <strong>解释：</strong>
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>0 <= nums.length <= 10<sup>4</sup></code></li>
 * <li><code>-10<sup>5</sup> <= nums[i] <= 10<sup>5</sup></code></li>
 * <li><code>0 <= i <= j < nums.length</code></li>
 * <li>最多调用 <code>10<sup>4</sup></code> 次 <code>sumRange</code><strong> </strong>方法</li>
 * </ul>
 * </div>
 * </div>
 * <div><div>Related Topics</div><div><li>设计</li><li>数组</li><li>前缀和</li></div></div><br><div><li>👍 403</li><li>👎 0</li></div>
 */

/**
 * 区域和检索 - 数组不可变
 *
 * @author saint
 */
public class P303_RangeSumQueryImmutable {
    public static void main(String[] args) {
//        Solution solution = new P303_RangeSumQueryImmutable().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        private int[] preSum;

        public NumArray(int[] nums) {
            preSum = new int[nums.length + 1];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

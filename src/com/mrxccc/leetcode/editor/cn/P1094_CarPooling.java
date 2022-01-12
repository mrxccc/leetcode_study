package com.mrxccc.leetcode.editor.cn;

/**
<p>假设你是一位顺风车司机，车上最初有&nbsp;<code>capacity</code>&nbsp;个空座位可以用来载客。由于道路的限制，车&nbsp;<strong>只能&nbsp;</strong>向一个方向行驶（也就是说，<strong>不允许掉头或改变方向</strong>，你可以将其想象为一个向量）。</p>

<p>这儿有一份乘客行程计划表&nbsp;<code>trips[][]</code>，其中&nbsp;<code>trips[i] = [num_passengers, start_location, end_location]</code>&nbsp;包含了第 <code>i</code> 组乘客的行程信息：</p>

<ul>
	<li>必须接送的乘客数量；</li>
	<li>乘客的上车地点；</li>
	<li>以及乘客的下车地点。</li>
</ul>

<p>这些给出的地点位置是从你的&nbsp;<strong>初始&nbsp;</strong>出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。</p>

<p>请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所有乘客的任务（当且仅当你可以在所有给定的行程中接送所有乘客时，返回&nbsp;<code>true</code>，否则请返回 <code>false</code>）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>trips = [[2,1,5],[3,3,7]], capacity = 4
<strong>输出：</strong>false
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>trips = [[2,1,5],[3,3,7]], capacity = 5
<strong>输出：</strong>true
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>trips = [[2,1,5],[3,5,7]], capacity = 3
<strong>输出：</strong>true
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
<strong>输出：</strong>true
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>你可以假设乘客会自觉遵守 &ldquo;<strong>先下后上</strong>&rdquo; 的良好素质</li>
	<li><code>trips.length &lt;= 1000</code></li>
	<li><code>trips[i].length == 3</code></li>
	<li><code>1 &lt;= trips[i][0] &lt;= 100</code></li>
	<li><code>0 &lt;= trips[i][1] &lt; trips[i][2] &lt;= 1000</code></li>
	<li><code>1 &lt;=&nbsp;capacity &lt;= 100000</code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>前缀和</li><li>排序</li><li>模拟</li><li>堆（优先队列）</li></div></div><br><div><li>👍 142</li><li>👎 0</li></div>
*/
/**
 * 拼车
 *
 * @author saint
 */
public class P1094_CarPooling{
    public static void main(String[] args) {
        Solution solution = new P1094_CarPooling().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
// 最多有 1000 个车站
		int[] nums = new int[1001];
		// 构造差分解法
		Difference df = new Difference(nums);

		for (int[] trip : trips) {
			// 乘客数量
			int val = trip[0];
			// 第 trip[1] 站乘客上车
			int i = trip[1];
			// 第 trip[2] 站乘客已经下车，
			// 即乘客在车上的区间是 [trip[1], trip[2] - 1]
			int j = trip[2] - 1;
			// 进行区间操作
			df.increment(i, j, val);
		}

		int[] res = df.result();

		// 客车自始至终都不应该超载
		for (int i = 0; i < res.length; i++) {
			if (capacity < res[i]) {
				return false;
			}
		}
		return true;
    }
}
	// 差分数组工具类
	class Difference {
		// 差分数组
		private int[] diff;

		/* 输入一个初始数组，区间操作将在这个数组上进行 */
		public Difference(int[] nums) {
			assert nums.length > 0;
			diff = new int[nums.length];
			// 根据初始数组构造差分数组
			diff[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				diff[i] = nums[i] - nums[i - 1];
			}
		}

		/* 给闭区间 [i,j] 增加 val（可以是负数）*/
		public void increment(int i, int j, int val) {
			diff[i] += val;
			if (j + 1 < diff.length) {
				diff[j + 1] -= val;
			}
		}

		/* 返回结果数组 */
		public int[] result() {
			int[] res = new int[diff.length];
			// 根据差分数组构造结果数组
			res[0] = diff[0];
			for (int i = 1; i < diff.length; i++) {
				res[i] = res[i - 1] + diff[i];
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

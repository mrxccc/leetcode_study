package com.mrxccc.leetcode.editor.cn;

/**
<p>给你一个字符串 <code>s</code> 、一个字符串 <code>t</code> 。返回 <code>s</code> 中涵盖 <code>t</code> 所有字符的最小子串。如果 <code>s</code> 中不存在涵盖 <code>t</code> 所有字符的子串，则返回空字符串 <code>""</code> 。</p>

<p> </p>

<p><strong>注意：</strong></p>

<ul>
	<li>对于 <code>t</code> 中重复字符，我们寻找的子字符串中该字符数量必须不少于 <code>t</code> 中该字符数量。</li>
	<li>如果 <code>s</code> 中存在这样的子串，我们保证它是唯一的答案。</li>
</ul>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "ADOBECODEBANC", t = "ABC"
<strong>输出：</strong>"BANC"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "a", t = "a"
<strong>输出：</strong>"a"
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> s = "a", t = "aa"
<strong>输出:</strong> ""
<strong>解释:</strong> t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length, t.length <= 10<sup>5</sup></code></li>
	<li><code>s</code> 和 <code>t</code> 由英文字母组成</li>
</ul>

<p> </p>
<strong>进阶：</strong>你能设计一个在 <code>o(n)</code> 时间内解决此问题的算法吗？<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 1675</li><li>👎 0</li></div>
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 最小覆盖子串
 *
 * @author saint
 */
public class P76_MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new P76_MinimumWindowSubstring().new Solution();
        // TO TEST
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public String minWindow(String s, String t) {
            Map<Character, Integer> need = new HashMap<Character, Integer>();
            Map<Character, Integer> window = new HashMap<Character, Integer>();

            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int valid = 0;
            int left = 0,right = 0;
            // 记录最小覆盖子串的起始索引
            int start = 0;
            int len = Integer.MAX_VALUE;
            while(right < s.length()){
                char c = s.charAt(right);
                right++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(c)){
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))){
                        valid++;
                    }
                }

                // 判断左侧窗口是否要收缩
                while (valid == need.size()){
                    // 在这里判断是否找到了合法的子串
                    if (right - left < len){
                        len = right - left;
                        start = left;
                    }
                    Character d = s.charAt(left);
                    left++;
                    // 进行窗口内数据的一系列更新
                    if (need.containsKey(d)){
                        if (window.get(d).equals(need.get(d))){
                            valid--;
                        }
                        window.put(d, window.getOrDefault(d, 0) - 1);
                    }
                }
            }
            return len == Integer.MAX_VALUE ? "": s.substring(start, start + len);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}

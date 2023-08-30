package com.mrxccc.leetcode.editor.cn;

/**
<p>给定两个字符串 <code><em>s</em></code> 和 <code><em>t</em></code> ，编写一个函数来判断 <code><em>t</em></code> 是否是 <code><em>s</em></code> 的字母异位词。</p>

<p><strong>注意：</strong>若&nbsp;<code><em>s</em></code> 和 <code><em>t</em></code><em>&nbsp;</em>中每个字符出现的次数都相同，则称&nbsp;<code><em>s</em></code> 和 <code><em>t</em></code><em>&nbsp;</em>互为字母异位词。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入:</strong> <em>s</em> = "anagram", <em>t</em> = "nagaram"
<strong>输出:</strong> true
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> <em>s</em> = "rat", <em>t</em> = "car"
<strong>输出: </strong>false</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length, t.length &lt;= 5 * 10<sup>4</sup></code></li> 
 <li><code>s</code> 和 <code>t</code>&nbsp;仅包含小写字母</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶:&nbsp;</strong>如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？</p>

<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>排序</li></div></div><br><div><li>👍 836</li><li>👎 0</li></div>
*/
/**
 * 有效的字母异位词
 *
 * @author saint
 */
public class P242_ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new P242_ValidAnagram().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;     // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int count: record) {
            if (count != 0) {               // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
                return false;
            }
        }
        return true;                        // record数组所有元素都为零0，说明字符串s和t是字母异位词
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

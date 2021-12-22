package com.mrxccc.leetcode.editor.cn;

/**
<p>给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意<strong>一棵</strong>的根结点即可。</p>

<p>两棵树重复是指它们具有相同的结构以及相同的结点值。</p>

<p><strong>示例 1：</strong></p>

<pre>        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
</pre>

<p>下面是两个重复的子树：</p>

<pre>      2
     /
    4
</pre>

<p>和</p>

<pre>    4
</pre>

<p>因此，你需要以列表的形式返回上述重复子树的根结点。</p>
<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 346</li><li>👎 0</li></div>
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 寻找重复的子树
 *
 * @author saint
 */
public class P652_FindDuplicateSubtrees{
    public static void main(String[] args) {
        Solution solution = new P652_FindDuplicateSubtrees().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return list;
    }

    String traverse(TreeNode root){
        if (root == null) return "#";
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subNodeStr = new StringBuilder(left).append(",").append(right).append(",").append(root.val).toString();
        Integer count = map.getOrDefault(subNodeStr, 0);
        if (count == 1){
            list.add(root);
        }
        map.put(subNodeStr, count++);
        return subNodeStr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

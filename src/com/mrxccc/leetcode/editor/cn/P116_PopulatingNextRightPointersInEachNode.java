package com.mrxccc.leetcode.editor.cn;

/**
<p>给定一个 <strong>完美二叉树 </strong>，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：</p>

<pre>
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}</pre>

<p>填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 <code>NULL</code>。</p>

<p>初始状态下，所有 next 指针都被设置为 <code>NULL</code>。</p>

<p> </p>

<p><strong>进阶：</strong></p>

<ul>
	<li>你只能使用常量级额外空间。</li>
	<li>使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。</li>
</ul>

<p> </p>

<p><strong>示例：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/02/14/116_sample.png" style="height: 205px; width: 600px;" /></p>

<pre>
<b>输入：</b>root = [1,2,3,4,5,6,7]
<b>输出：</b>[1,#,2,3,#,4,5,6,7,#]
<b>解释：</b>给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点的数量少于 <code>4096</code></li>
	<li><code>-1000 <= node.val <= 1000</code></li>
</ul>
<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 620</li><li>👎 0</li></div>
*/
/**
 * 填充每个节点的下一个右侧节点指针
 *
 * @author saint
 */
public class P116_PopulatingNextRightPointersInEachNode{
    public static void main(String[] args) {
        Solution solution = new P116_PopulatingNextRightPointersInEachNode().new Solution();
        // TO TEST
    }
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root != null){
            connectTwoNodes(root.left,root.right);
        }
        return root;
    }

    private void connectTwoNodes(Node node1, Node node2) {
        if (node1 == null || node2 == null){
            return;
        }
        node1.next = node2;
        connectTwoNodes(node1.left,node1.right);
        connectTwoNodes(node2.left, node2.right);
        connectTwoNodes(node1.right, node2.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

package com.mrxccc.leetcode.editor.cn;

/**
 <p>序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。</p>

 <p>请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。</p>

 <p><strong>提示: </strong>输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 <a href="/faq/#binary-tree">LeetCode 序列化二叉树的格式</a>。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。</p>

 <p> </p>

 <p><strong>示例 1：</strong></p>
 <img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/serdeser.jpg" style="width: 442px; height: 324px;" />
 <pre>
 <strong>输入：</strong>root = [1,2,3,null,null,4,5]
 <strong>输出：</strong>[1,2,3,null,null,4,5]
 </pre>

 <p><strong>示例 2：</strong></p>

 <pre>
 <strong>输入：</strong>root = []
 <strong>输出：</strong>[]
 </pre>

 <p><strong>示例 3：</strong></p>

 <pre>
 <strong>输入：</strong>root = [1]
 <strong>输出：</strong>[1]
 </pre>

 <p><strong>示例 4：</strong></p>

 <pre>
 <strong>输入：</strong>root = [1,2]
 <strong>输出：</strong>[1,2]
 </pre>

 <p> </p>

 <p><strong>提示：</strong></p>

 <ul>
 <li>树中结点数在范围 <code>[0, 10<sup>4</sup>]</code> 内</li>
 <li><code>-1000 <= Node.val <= 1000</code></li>
 </ul>
 <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>设计</li><li>字符串</li><li>二叉树</li></div></div><br><div><li>👍 719</li><li>👎 0</li></div>
 */

import java.util.LinkedList;

/**
 * 二叉树的序列化与反序列化
 *
 * @author saint
 */
public class P297_SerializeAndDeserializeBinaryTree{
    public static void main(String[] args) {
        Codec solution = new P297_SerializeAndDeserializeBinaryTree().new Codec();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // 代表分隔符的字符
        String SEP = ",";
        // 代表 null 空指针的字符
        String NULL = "#";
        // 用于拼接字符串
        StringBuilder sb = new StringBuilder();

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            serialize(root, sb);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            // 将字符串转化成列表
            LinkedList<String> nodes = new LinkedList<>();
            for (String s : data.split(SEP)) {
                nodes.addLast(s);
            }
            return deserialize(nodes);
        }

        private TreeNode deserialize(LinkedList<String> nodes) {
            // badcase
            if (nodes.isEmpty()) return null;
            /****** 前序遍历位置 ******/
            String first = nodes.removeFirst();
            if (first.equals(NULL)) return null;
            TreeNode root = new TreeNode(Integer.parseInt(first));
            root.left = deserialize(nodes);
            root.right = deserialize(nodes);
            return root;
        }


        /* 将二叉树打平为字符串 */
        void serialize(TreeNode root, StringBuilder sb) {
            // badcase
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }
            /****** 前序遍历位置 ******/
            // do something
            sb.append(root.val).append(SEP);

            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}

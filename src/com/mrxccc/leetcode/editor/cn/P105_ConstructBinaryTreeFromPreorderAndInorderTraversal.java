package com.mrxccc.leetcode.editor.cn;

/**
 * <p>给定一棵树的前序遍历 <code>preorder</code> 与中序遍历  <code>inorder</code>。请构造二叉树并返回其根节点。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" />
 * <pre>
 * <strong>Input:</strong> preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * <strong>Output:</strong> [3,9,20,null,null,15,7]
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> preorder = [-1], inorder = [-1]
 * <strong>Output:</strong> [-1]
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li><code>1 <= preorder.length <= 3000</code></li>
 * <li><code>inorder.length == preorder.length</code></li>
 * <li><code>-3000 <= preorder[i], inorder[i] <= 3000</code></li>
 * <li><code>preorder</code> 和 <code>inorder</code> 均无重复元素</li>
 * <li><code>inorder</code> 均出现在 <code>preorder</code></li>
 * <li><code>preorder</code> 保证为二叉树的前序遍历序列</li>
 * <li><code>inorder</code> 保证为二叉树的中序遍历序列</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>数组</li><li>哈希表</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍 1336</li><li>👎 0</li></div>
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author saint
 */
public class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        Map<Integer,Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++){
                map.put(inorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd) {
                return null;
            }

            // 找出根节点
            int val = preorder[preStart];
            TreeNode root = new TreeNode(val);
            int index = map.get(val);
            root.left = build(preorder, preStart + 1, preStart + index - inStart, inorder, inStart, index - 1);
            root.right = build(preorder, preStart + index - inStart + 1, preEnd, inorder, index + 1, inEnd);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

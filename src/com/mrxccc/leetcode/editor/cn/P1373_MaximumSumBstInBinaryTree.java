package com.mrxccc.leetcode.editor.cn;

/**
 <p>给你一棵以 <code>root</code> 为根的 <strong>二叉树</strong> ，请你返回 <strong>任意</strong> 二叉搜索子树的最大键值和。</p>

 <p>二叉搜索树的定义如下：</p>

 <ul>
 <li>任意节点的左子树中的键值都 <strong>小于</strong> 此节点的键值。</li>
 <li>任意节点的右子树中的键值都 <strong>大于</strong> 此节点的键值。</li>
 <li>任意节点的左子树和右子树都是二叉搜索树。</li>
 </ul>

 <p> </p>

 <p><strong>示例 1：</strong></p>

 <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/03/07/sample_1_1709.png" style="height: 250px; width: 320px;" /></p>

 <pre>
 <strong>输入：</strong>root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 <strong>输出：</strong>20
 <strong>解释：</strong>键值为 3 的子树是和最大的二叉搜索树。
 </pre>

 <p><strong>示例 2：</strong></p>

 <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/03/07/sample_2_1709.png" style="height: 180px; width: 134px;" /></p>

 <pre>
 <strong>输入：</strong>root = [4,3,null,1,2]
 <strong>输出：</strong>2
 <strong>解释：</strong>键值为 2 的单节点子树是和最大的二叉搜索树。
 </pre>

 <p><strong>示例 3：</strong></p>

 <pre>
 <strong>输入：</strong>root = [-4,-2,-5]
 <strong>输出：</strong>0
 <strong>解释：</strong>所有节点键值都为负数，和最大的二叉搜索树为空。
 </pre>

 <p><strong>示例 4：</strong></p>

 <pre>
 <strong>输入：</strong>root = [2,1,3]
 <strong>输出：</strong>6
 </pre>

 <p><strong>示例 5：</strong></p>

 <pre>
 <strong>输入：</strong>root = [5,4,8,3,null,6,3]
 <strong>输出：</strong>7
 </pre>

 <p> </p>

 <p><strong>提示：</strong></p>

 <ul>
 <li>每棵树有 <code>1</code> 到 <code>40000</code> 个节点。</li>
 <li>每个节点的键值在 <code>[-4 * 10^4 , 4 * 10^4]</code> 之间。</li>
 </ul>
 <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉搜索树</li><li>动态规划</li><li>二叉树</li></div></div><br><div><li>👍 72</li><li>👎 0</li></div>
 */

import static com.sun.org.apache.xerces.internal.impl.xs.opti.SchemaDOM.traverse;

/**
 * 二叉搜索子树的最大键值和
 *
 * @author saint
 */
public class P1373_MaximumSumBstInBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P1373_MaximumSumBstInBinaryTree().new Solution();
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
// res[0] 记录以 root 为根的二叉树是否是 BST，若为 1 则说明是 BST，若为 0 则说明不是 BST；
//
//res[1] 记录以 root 为根的二叉树所有节点中的最小值；
//
//res[2] 记录以 root 为根的二叉树所有节点中的最大值；
//
//res[3] 记录以 root 为根的二叉树所有节点值之和。
    class Solution {
        int maxSum = 0;
        public int maxSumBST(TreeNode root) {
            traverse(root);
            return maxSum;
        }

        private int[] traverse(TreeNode root) {
            // base case
            if (root == null) {
                return new int[] {
                        1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
                };
            }

            // 递归计算左右子树
            int[] left = traverse(root.left);
            int[] right = traverse(root.right);

            /******* 后序遍历位置 *******/
            int[] res = new int[4];
            // 这个 if 在判断以 root 为根的二叉树是不是 BST
            if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
                // 以 root 为根的二叉树是 BST
                res[0] = 1;
                // 计算以 root 为根的这棵 BST 的最小值
                res[1] = Math.min(left[1], root.val);
                // 计算以 root 为根的这棵 BST 的最大值
                res[2] = Math.max(right[2], root.val);
                // 计算以 root 为根的这棵 BST 所有节点之和
                res[3] = left[3] + right[3] + root.val;
                // 更新全局变量
                maxSum = Math.max(maxSum, res[3]);
            } else {
                // 以 root 为根的二叉树不是 BST
                res[0] = 0;
                // 其他的值都没必要计算了，因为用不到
            }
            /**************************/
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}

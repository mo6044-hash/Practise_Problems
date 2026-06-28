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
    Boolean ans = true;
    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null)) {
            ans = false;
            return ans;
        }
        if (p.val != q.val) {
            ans = false;
            return ans;
        }
        dfs(p.left, q.left);
        dfs(p.right, q.right);
        return true;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p, q);
        return ans;
    }
}

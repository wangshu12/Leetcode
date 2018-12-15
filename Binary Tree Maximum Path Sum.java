/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ret;
    public int maxPathSum(TreeNode root) {
        ret = Integer.MIN_VALUE;
        helper(root);
        return ret;
    }
    
    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        ret = Math.max(ret, left+right+root.val);
        return Math.max(left, right) + root.val;
    }
}
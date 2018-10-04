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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode ret = new TreeNode(-1);
        helper(root, k , ret);
        return ret.val;
    }
    public int helper(TreeNode root, int k, TreeNode ret){
        if(root == null) return 0;
        int left = helper(root.left, k, ret);
        if(left + 1 == k){
            ret.val = root.val;
            System.out.println(ret.val);
        }
        int right = helper(root.right, k - left - 1, ret);
        
        return left +right+ 1;
    }
}
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
        TreeNode ret = new TreeNode(-1); // here is super imortant, we declare a node to store the value.
        int rank = helper(root, k, ret);
        return ret.val;
    }
    
    private int helper(TreeNode node, int k, TreeNode ret){
        if(node == null) return 0;
        int left = helper(node.left, k, ret);
        if(left + 1 == k) ret.val = node.val;
        int right = helper(node.right, k - left - 1, ret); //be careful this is k - left - 1
        
        return left + right + 1;
    }
}
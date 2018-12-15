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
    int count;
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        helper(root);
        return count;
    }
    
    private boolean helper(TreeNode root){
        if(root == null) return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        
        if(left && right){
            if(root.left != null && root.left.val != root.val){
                return false;
            }
            if(root.right != null && root.right.val != root.val){
                return false;
            }
            count++;
            return true;
        }
        return false;
    }
}
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null) return null;
        if(nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }
    
    public TreeNode helper(int[] nums, int i, int j){
        if(i == j) return new TreeNode(nums[i]);
        if(i > j) return null;
        int mid = (i + j) / 2;
        TreeNode parent = new TreeNode(nums[mid]);
        TreeNode left = helper(nums, i, mid - 1);
        TreeNode right = helper(nums, mid + 1, j);
        parent.left = left;
        parent.right = right;
        return parent;
    }
}
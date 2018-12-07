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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(root, ret);
        return ret;
    }
    
    public int helper(TreeNode root, List<List<Integer>> ret){
        if(root == null) return -1;
        int level = Math.max(helper(root.left, ret), helper(root.right, ret)) + 1;
        if(level == ret.size()) ret.add(new ArrayList<Integer>());
        ret.get(level).add(root.val);
        return level;
    }
}
public class Solution{
    public boolean isValidBST (TreeNode root){
        return helper(null, root, null);
    }
    
    public boolean helper(TreeNode min, TreeNode root, TreeNode max){
        if(root == null) return true;
        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;
        return helper(min, root.left, root) && helper(root, root.right, max);
    }
}

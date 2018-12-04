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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;
        if(root.val <= R && root.val >= L){
            root.left = trimBST(root.left, L, root.val);
            root.right = trimBST(root.right, root.val, R);
            return root;
        }else if(root.val > R){
            return trimBST(root.left, L, R);
        }else{
            return trimBST(root.right, L, R);
        }
    }
}
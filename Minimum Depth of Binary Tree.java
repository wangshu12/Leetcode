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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return dfsMinDepth(root, 1);
    }
    
    private int dfsMinDepth(TreeNode node, int depth){
        if(node.left == null && node.right == null) return depth;
        else if(node.left != null && node.right != null){
            return Math.min(dfsMinDepth(node.left, depth+1), dfsMinDepth(node.right,depth+1));
        }else if(node.left != null){
            return dfsMinDepth(node.left,depth+1);
        }else{
            return dfsMinDepth(node.right,depth+1);
        }
    }
}
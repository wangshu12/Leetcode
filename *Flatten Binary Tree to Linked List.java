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
    public void flattenIterative(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode n = stack.pop();
            if(n.right != null) stack.push(n.right);
            if(n.left != null) stack.push(n.left);
            if(!stack.isEmpty()) n.right = stack.peek();
            n.left = null;
        }
    }
}
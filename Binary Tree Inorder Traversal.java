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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        helper(stack, root);
        
        while(!stack.empty()){
            TreeNode node = stack.pop();
            helper(stack, node.right);
            list.add(node.val);
        }
        return list;
    }
    
    public void helper(Stack<TreeNode> stack, TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
}
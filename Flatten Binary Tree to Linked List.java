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
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode cursor = root;
        while(cursor != null){
            
            //Find the rightest node on left tree;
            TreeNode left = cursor.left;
            TreeNode temp = cursor.left;
            while(temp != null){
                left = temp;
                temp = temp.right;
            }
            
            //Attach the rightest node to the right node
            if(left != null){
                left.right = cursor.right;
                cursor.right = cursor.left;
                cursor.left = null;
            }
            cursor = cursor.right;
        }
        
        
        
        // if(root == null) return;
        // Stack<TreeNode> stack = new Stack<>();
        // stack.push(root);
        // while(!stack.isEmpty()){
        //     TreeNode node = stack.pop();
        //     if(node.right != null) stack.push(node.right);
        //     if(node.left != null) stack.push(node.left);
        //     if(!stack.isEmpty()) node.right = stack.peek();
        //     node.left = null;
        // }
    }
}
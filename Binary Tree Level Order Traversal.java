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
   public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        levelHelper(ret, root, 0);
        return ret;
   }
    //we can use a int variable to remember the height of current node, if the height is >=, we construct a new new arraylist to store the node in the level.
    //we use recurrsion and inorder-traversal to solve the problem.
    public void levelHelper(List<List<Integer>> ret, TreeNode root, int height){
        if(root == null) return;
        if(height >= ret.size()) ret.add(new ArrayList<>());
        ret.get(height).add(root.val);
        levelHelper(ret, root.left, height +1);
        levelHelper(ret, root.right, height+1);
    }
}
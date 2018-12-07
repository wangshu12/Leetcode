/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Given a sequence 1…n, to construct a Binary Search Tree (BST) out of the sequence.
// We could enumerate each number i in the sequence, and use the number as the root. 
// The subsequence 1…(i-1) on its left side would lay on the left branch of the root
// The right subsequence (i+1)…n lay on the right branch of the root.
// We can use dp to solve the problem;  (also divide and conquer)
// We use a dp table, and each element in the table is a list of TreeNode;
// which stores structure of unique BST whose length is the index of the element.

// 1 .. n i  --> (1, i - 1) i (i + 1, n)
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] table = new ArrayList[n + 1];
        table[0] = new ArrayList<>();
        if(n == 0) return table[0];
        table[0].add(null);
        
        for(int i = 1; i <= n; i++){
            table[i] = new ArrayList<TreeNode>();
            for(int j = 0; j < i; j++){ //as root
                for(TreeNode leftNode : table[j]){
                    for(TreeNode rightNode: table[i - j - 1]){
                        TreeNode root = new TreeNode(j + 1);
                        root.left = leftNode;
                        root.right = shift(rightNode, j+1);
                        table[i].add(root);
                    }
                }
            }
        }
        return table[n];
    }
    
    public TreeNode shift(TreeNode root, int offset){
        if(root == null) return null;
        TreeNode newRoot = new TreeNode(root.val + offset);
        newRoot.left = shift(root.left, offset);
        newRoot.right = shift(root.right, offset);
        return newRoot;
    }
}
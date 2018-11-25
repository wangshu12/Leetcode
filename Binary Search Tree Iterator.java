/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        buildIterator(stack, root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }

    /** @return the next smallest number */
    public int next() {
        if(stack.size() == 0){
            return Integer.MIN_VALUE;
        }
        TreeNode ret = stack.pop();
        buildIterator(stack, ret.right);
        return ret.val;
    }
    
    private void buildIterator(Stack<TreeNode> stack ,TreeNode root){
        TreeNode cursor = root;
        while(cursor != null){
            stack.push(cursor);
            cursor = cursor.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
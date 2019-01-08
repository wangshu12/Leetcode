/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Pre-order traversal is BST's serialized string. I am doing it iteratively.
//To deserialized it, use a queue to recursively get root node, left subtree and right subtree.

//I think time complexity is O(NlogN).
//Errr, my bad, as @ray050899 put below, worst case complexity should be O(N^2), when the tree is really unbalanced.


public class Codec {
    private static final String NULL = "null";
    private static final String SEPR = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return NULL;
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>(); //store TreeNode for sorting them in preorder.
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            sb.append(node.val + SEPR);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(NULL)) return null;
        String[] array = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        for(String s: array){
            queue.add(Integer.parseInt(s));
        }
        return getNode(queue);
    }
    
    private TreeNode getNode(Queue<Integer> q){
        if(q == null) return null;
        if(q.size() == 0) return null;
        int value = q.poll();
        TreeNode root = new TreeNode(value);
        Queue<Integer> left = new LinkedList<>();
        while(!q.isEmpty() && q.peek() < value){
            left.add(q.poll());
        }
        root.left = getNode(left);
        root.right = getNode(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
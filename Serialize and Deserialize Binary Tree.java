/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static String NULL = "null";
    private static String SEP = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        buildBFS(q, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    private void buildBFS(Queue<TreeNode> q, StringBuilder sb){
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                sb.append(NULL + SEP);
                continue;
            }
            sb.append(node.val + SEP);
            q.add(node.left);
            q.add(node.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return convertNode(arr);
    }
    private TreeNode convertNode(String[] arr){
        if(arr[0].equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        int index = 1;
        q.add(root);
        while(!q.isEmpty() && index < arr.length){
            TreeNode cursor = q.poll();
            if(!arr[index].equals(NULL)){
                TreeNode left = new TreeNode(Integer.parseInt(arr[index]));
                cursor.left = left;
                q.add(left);
            }
            index++;
            if(!arr[index].equals(NULL)){
                TreeNode right = new TreeNode(Integer.parseInt(arr[index]));
                cursor.right = right;
                q.add(right);
            }
            index++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
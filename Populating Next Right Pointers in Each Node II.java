/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode levelNode = root;
        
        while(levelNode != null){
            TreeLinkNode cur = levelNode;
            TreeLinkNode start = null;
            
            // find start node in next level
            while(cur != null && start == null){
                if(cur.left != null){
                    start = cur.left;
                    levelNode = cur.left;
                }
                
                if(cur.right != null){
                    if(start != null) start.next = cur.right;
                    else levelNode = cur.right;
                    start = cur.right;
                }
                cur = cur.next;
            }
            
            if(start == null) levelNode = null;
            while(cur != null){
                if(cur.left != null){
                    start.next = cur.left;
                    start = cur.left;
                }
                
                if(cur.right != null){
                    start.next = cur.right;
                    start = cur.right;
                }
                cur = cur.next;
            }
        }
    }
}


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeLinkNode node = queue.poll();
                if(size == 1 || queue.peek() == null) node.next = null;
                else node.next = queue.peek();
                
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                size--;
            }
        }
    }
}


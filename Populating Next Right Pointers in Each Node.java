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
        TreeLinkNode cursor = root;
        while(cursor != null){
            TreeLinkNode nextStart = null;
            TreeLinkNode leftNode = null;
            while(cursor != null){
                if(cursor.left != null){
                    nextStart = cursor.left;
                    leftNode = nextStart;
                    if(cursor.right != null){
                        nextStart.next = cursor.right;
                        leftNode = cursor.right;
                    }
                }else if(cursor.right != null && nextStart == null){
                    nextStart = cursor.right;
                    leftNode = nextStart;
                }
                cursor = cursor.next;
                if(nextStart != null) break;
            }
            
            while(cursor != null){
                if(cursor.left != null){
                    leftNode.next = cursor.left;
                    leftNode = cursor.left;
                }
                if(cursor.right != null){
                    leftNode.next = cursor.right;
                    leftNode = cursor.right;
                }
                cursor = cursor.next;
            }
            cursor = nextStart;
        }
    }
}
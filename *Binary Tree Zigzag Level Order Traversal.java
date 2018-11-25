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
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         //print(root);
         List<List<Integer>> ret = new ArrayList<>();
         //helper(ret, root, 0);
         helper1(ret, root);
         return ret;
     }
    
    public void helper(List<List<Integer>> ret, TreeNode root, int level){
        if(root == null) return;
        if(ret.size() <= level){
            List<Integer> list = new LinkedList<>();
            ret.add(list);
        }
        
        LinkedList<Integer> bag = (LinkedList)ret.get(level);
        if(level % 2 == 0) bag.add(root.val);
        else bag.addFirst(root.val);
        helper(ret, root.left, level + 1);
        helper(ret, root.right, level + 1);
    }
    
    public void helper1(List<List<Integer>> ret, TreeNode root){
        if(root == null) return;
        Stack<TreeNode> parent = new Stack<>();
        parent.add(root);
        int level = 0;
        while(!parent.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> child = new Stack<>();
            while(!parent.isEmpty()){
                TreeNode node = parent.pop();
                list.add(node.val);
                if(level % 2 == 0){
                    if(node.left != null) child.add(node.left);
                    if(node.right != null) child.add(node.right);
                }else{
                    if(node.right != null) child.add(node.right);
                    if(node.left != null) child.add(node.left);
                }
            }
            ret.add(list);
            parent = child;
            level++;
        }
    }
    
    public void print(TreeNode node){
        LinkedList<TreeNode> old = new LinkedList<>();
        LinkedList<TreeNode> even = new LinkedList<>();
        int i = 1;
        old.add(node);
        while(old.size() != 0 || even.size() != 0){
            if(i % 2 == 1){
                while(old.size() > 0){
                    TreeNode n = old.remove();
                    if(n.left != null) even.addFirst(n.left);
                    if(n.right != null) even.addFirst(n.right);
                }
            }else{
                while(even.size() > 0){
                    TreeNode n = even.remove();
                    if(n.left != null) old.add(n.left);
                    if(n.right != null) old.add(n.right);
                }
            }
            i++;
            System.out.println();
        }
        
    }
}
// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> ret = new ArrayList<>();
//         if(root == null) return ret;
//         Stack<TreeNode> s1 = new Stack<>();
//         Stack<TreeNode> s2 = new Stack<>();
//         List<Integer> list = new ArrayList<>();
//         s1.push(root);
//         list.add(root.val);
//         ret.add(list);
//         while(!s1.isEmpty() || !s2.isEmpty()){
//             list = new ArrayList<>();
//             while(!s1.isEmpty()){
//                 TreeNode node = s1.pop();
//                 if(node.right != null){
//                     list.add(node.right.val);
//                     s2.push(node.right);
//                 }
//                 if(node.left != null){
//                     list.add(node.left.val);
//                     s2.push(node.left);
//                 }
//             }
//             if(list.size()!= 0) ret.add(list);
//             list = new ArrayList<>();
//             while(!s2.isEmpty()){
//                 TreeNode node = s2.pop();
//                 if(node.left != null){
//                     list.add(node.left.val);
//                     s1.add(node.left);
//                 }
//                 if(node.right != null){
//                     list.add(node.right.val);
//                     s1.add(node.right);
//                 }
//             }
//             if(list.size()!= 0) ret.add(list);
//         }
//         return ret;
//     }
// }
// we are using bfs, but there is a disadvantage about bfs, that is the order of nodes inserted into queue is from left to right, unlike zigzag; otherwise, we need to use two stacks, one store nodes that is from left to right, the other store nodes from right to left;
// so we could consider to use dfs, and we notice that the order of List<List<Integer>> is as same as the level of the tree. nodes in odd level is from right to left, nodes in even level is from left to right.
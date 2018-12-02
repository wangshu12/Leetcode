/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            Node n = stack.pop();
            if(n.next != null) stack.push(n.next);
            if(n.child != null) stack.push(n.child);
            n.next = null;
            n.child = null;
            if(!stack.isEmpty()){
                n.next = stack.peek();
                stack.peek().prev = n;
            }
        }
        return head;
    }
}
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> queue;
    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        buildQueue(nestedList, queue);
    }
    
    private void buildQueue(List<NestedInteger> nestedList, Queue<Integer> q){
        for(NestedInteger n: nestedList){
            if(n.isInteger()){
                q.add(n.getInteger());
            }else{
                buildQueue(n.getList(), q);
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */


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
        Node cursor = head;
        while(cursor != null){
            Node tail = cursor.child;
            Node prev = tail;
            while(tail != null){
                prev = tail;
                tail = tail.next;
            }
            
            if(prev != null){
                prev.next = cursor.next;
                if(cursor.next != null) cursor.next.prev = prev;
                cursor.child.prev = cursor;
                cursor.next = cursor.child;
                cursor.child = null;
            }
            cursor = cursor.next;
        }
        return head;
    }
}



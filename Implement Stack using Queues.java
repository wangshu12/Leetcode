// we have push, pop and top these three functions; if push spents O(1), then pop and top must spends O(n) to find the last elemt and remove it;
// however, if push spents O(n) which means that we always insert the element in the first position of the queue, then the pop and top will be O(1) in the queue data structure;
// here, we use only one Queue.

class MyStack {
    private Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    // first we can push the input element into the queue;
    // then we pop out all old element and push them back, in order to keep the last element in the first position of the queue.
    public void push(int x) {
        queue.add(x);
        for(int i = 0; i < queue.size() - 1; i ++){
            queue.add(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
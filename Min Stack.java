class MinStack {
    private Node top;
    /** initialize your data structure here. */
    public MinStack() {
        top = null;
    }
    
    public void push(int x) {
        if(top == null){
            top = new Node(x, null, x);
        }else{
            int min = Math.min(x, top.min);
            top = new Node(x, top, min);
        }
    }
    
    public void pop() {
        if(top != null) top = top.next;
    }
    
    public int top() {
        if(top != null) return top.value;
        else return Integer.MIN_VALUE;
    }
    
    public int getMin() {
        return top.min;
    }
    
    // we can design a class -- Node, 
    // each node will rememeber its next node; 
    // also, remember the min number current min number
    
    // In the MinStack, we need to have a pointer to point the top Node;
    private class Node{
        int value;
        Node next;
        int min;
        public Node(int value, Node next, int min){
            this.value = value;
            this.next = next;
            this.min = min;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
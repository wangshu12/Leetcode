class PhoneDirectory {
    Set<Integer> set;
    Queue<Integer> q;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        set = new HashSet<>();
        q = new LinkedList<>();
        for(int i = 0; i < maxNumbers; i++){
            q.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(q.size() == 0) return -1;
        return q.poll();
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if(q.contains(number)) return true;
        return false;
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(q.contains(number)) return;
        q.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
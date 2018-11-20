// Using Queue:
// benefits: this could be multithreaded without use of locks! so scalable.
// issues: it's not time efficient. it's not space efficient.

class HitCounter {
    Queue<Integer> q;
    /** Initialize your data structure here. */
    public HitCounter() {
        q = new LinkedList<>();
    }
    
    /** Record a hit. -- O(1)
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.add(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes. -- O(1) -- O(n) worst case
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!q.isEmpty() && timestamp - q.peek() >= 300){
            q.poll();
        }
        return q.size();
    }
}

// O(s) s is total seconds in given time interval, in this case 300.
// basic ideal is using buckets. 
// time_array stores the current time, and the index is computed by mod operation. 
// freq_array is associated with time_array to record the number of hits in current second. 
// If the input timestamp does not equal to the corresponding time in the time_array, 
// it means value of the time_array is 300s or 600... ago. 
// So, we need update the time_array, and the set the associated freq_array to 1; else, we just use freq_array[index] ++.
class HitCounter {
    int[] time_array;
    int[] freq_array;
    /** Initialize your data structure here. */
    public HitCounter() {
        time_array = new int[300];
        freq_array = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if(timestamp == time_array[index]){
            freq_array[index]++;
        }else{
            time_array[index] = timestamp;
            freq_array[index] = 1;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        for(int i = 0; i < time_array.length; i++){
            if(timestamp - time_array[i] < 300 && timestamp - time_array[i] >=0){
                count += freq_array[i];
            }
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
class LFUCache {
    int capacity;
    int time;
    HashMap<Integer, Cache> map;
    TreeSet<Cache> set;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        time = 0;
        map = new HashMap<>();
        set = new TreeSet<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        time ++;
        Cache c = map.get(key);
        set.remove(c);
        Cache nC = new Cache(time, c.freq + 1, c.value, key);
        set.add(nC);
        map.put(key, nC);
        return c.value;
    }
    
    public void put(int key, int value) {
        if(capacity <= 0) return;
        time++;
        if(map.containsKey(key)){
            Cache c = map.get(key);
            set.remove(c);
            Cache nc = new Cache(time, c.freq + 1, value, key);
            set.add(nc);
            map.put(key, nc);
        }else{
            Cache add = new Cache(time, 1, value, key);
            if(map.size() == capacity){
                Cache removed = set.pollFirst();
                map.remove(removed.key);
                //System.out.println("removed: " + removed.key + " " + removed.value);
            }
            map.put(key, add);
            set.add(add);
        }
    }
    
    class Cache implements Comparable<Cache>{
        int time;
        int freq;
        int value;
        int key;
        
        public Cache(int time, int freq, int value, int key){
            this.time = time;
            this.freq = freq;
            this.value = value;
            this.key = key;
        }
        
        public int compareTo(Cache e){
            if(freq == e.freq){
                return time - e.time;
            }else{
                return freq - e.freq;
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
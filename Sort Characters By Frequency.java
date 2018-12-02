class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        queue.addAll(map.entrySet());
        
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            Map.Entry<Character, Integer> entry = queue.poll();
            for(int i = 0; i < entry.getValue(); i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}


class Solution {
    //Bucket sort
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }
        
        List<Character> [] buckets = new List[s.length() + 1];
        for(Character c: map.keySet()){
            int fre = map.get(c);
            if(buckets[fre] == null){
                buckets[fre] = new ArrayList<Character>();
            }
            buckets[fre].add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = buckets.length - 1; i >= 0; i--){
            if(buckets[i] != null){
                for(int j = 0; j < buckets[i].size(); j++){
                    for(int k = 0; k < i; k++){
                        sb.append(buckets[i].get(j));
                    }
                }
            }
        }
        return sb.toString();
    }
}
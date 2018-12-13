class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //Count frequency of string by using hashmap;
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words){
            if(!map.containsKey(word)){
                map.put(word, 0);
            }
            map.put(word, map.get(word) + 1);
        }
        
        //USE BUCKETS SORT -- SORT FREQUENCY; USE TREESET TO SORT STRING ALPHABETICALLY.
        TreeSet<String> [] buckets = new TreeSet[words.length + 1];
        for(String word: map.keySet()){
            int fre = map.get(word);
            if(buckets[fre] == null){
                buckets[fre] = new TreeSet<>();
            }
            buckets[fre].add(word);
        }
        
        //COMPUTE THE RESULT
        List<String> ret = new ArrayList<>();
        for(int i = buckets.length - 1; i >= 0 && k > 0; i--){
            if(buckets[i] != null){
                while(buckets[i].size() > 0){
                    String s = buckets[i].pollFirst();
                    ret.add(s);
                    k--;
                    if(k == 0) return ret;
                }
            }
        }
        return ret;
    }
}
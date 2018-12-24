class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String, Integer> freq_map = new HashMap<>();
        for(String word: words){
            freq_map.put(word, freq_map.getOrDefault(word, 0) + 1);
        }
        for(String word: banned){
            if(freq_map.containsKey(word)) freq_map.remove(word);
        }
        String ret = "";
        int freq = 0;
        for(String key: freq_map.keySet()){
            int f = freq_map.get(key);
            if(f > freq){
                ret = key;
                freq = f;
            }
        }
        return ret;
    }
}
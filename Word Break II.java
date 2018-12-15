class Solution {
    private HashMap<String, List<String>> map = new HashMap<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(map.containsKey(s)) return map.get(s);
        
        List<String> ret = new ArrayList<String>();
        if(wordDict.contains(s)) ret.add(s);
        for(int i = 1; i <= s.length(); i++){
            String sub = s.substring(0, i);
            if(wordDict.contains(sub)){
                List<String> list = wordBreak(s.substring(i, s.length()), wordDict);
                if(list.size() == 0) continue;
                for(String str: list){
                    ret.add(sub + " " + str);
                }
            }
        }
        map.put(s, ret);
        return ret;
    }
}

//Time: worst: O(2^n), best: O(n^2)
//Space: worst: O(2^n), 
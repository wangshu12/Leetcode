class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        if(s == null || p == null || s.length() == 0 || p.length() == 0 || p.length() > s.length()) return ret;
        // init a map which remember each character in string p and its frequency.
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            if(!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }
        int begin = 0, end = 0;
        int counter = map.size(); //maintain a counter to check whether matches target string.
        
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) counter--; //if we find a character, we decrease counter.
            }
            end++;
            
            while(counter == 0){// when counter equals to zero, means that we find a substring contains all characters of string p.
                char startChar = s.charAt(begin);
                if(map.containsKey(startChar)){
                    map.put(startChar, map.get(startChar) + 1);
                    if(map.get(startChar) == 1){// when frequency of a character is == 1, means that the substring does not contains all character of string p, we increase counter.
                        counter++;
                    }
                }
                //
                if(end - begin == p.length()){//when counter == 0, and the length of substring equals to target string, means we find the right anagram. We record the start index.
                    ret.add(begin);
                }
                begin++;
            }
        }
        return ret;
    }
}
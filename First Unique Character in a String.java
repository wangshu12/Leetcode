class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> freq_map = new HashMap<>();
        for(char c: s.toCharArray()){
            freq_map.put(c, freq_map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++){
            if(freq_map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        if(s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>(); // counter
        int maxLength = 0;
        int length = 0;
        int left = 0, right = 0;
        
        while(right < s.length()){
            char c = s.charAt(right);
            if(!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c) + 1);
            length ++;
            while(left < right && map.get(c) > 1){
                char left_char = s.charAt(left);
                map.put(left_char, map.get(left_char) - 1);
                left++;
                length --;
            }
            if(length > maxLength){
                maxLength = length;
            }
            right++;
        }
        return maxLength;
    }
}
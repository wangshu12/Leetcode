// The main idea is to maintain a sliding window with 2 unique characters. 
// The hashmap record the frequency of each character in the substring.
// If the size of the hashmap < 3, then we can increase the frequency of that character and right++.
// Whenever the size of the hashmap exceeds 2, 
// we decrease the frequency of the left character, left++ and length++ until the size < 3;
// Once the frequency of the character is == 0, then remove the character from the hashmap.
// Whenever right++, we increase length; when left--, we decrease length. When length > max_length, we update max_length
// Time: O(n);
// Space: O(1);
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int length = 0, max_length = 0;
        
        while(right < s.length()){
            char right_char = s.charAt(right);
            if(!map.containsKey(right_char)) map.put(right_char, 0);
            map.put(right_char, map.get(right_char) + 1);
            right++;
            length++;
            
            if(map.size() > 2){
                while(left < right && map.size() > 2){
                    char left_char = s.charAt(left);
                    map.put(left_char, map.get(left_char) - 1);
                    if(map.get(left_char) == 0){
                        map.remove(left_char);
                    }
                    left++;
                    length--;
                }
            }
            if(length > max_length) max_length = length;
        }
        return max_length;
    }
}


// The main idea is to maintain a sliding window with 2 unique characters. 
// The key is to store the last index of each character as the value in the hashmap. 
// This way, whenever the size of the hashmap exceeds 2, we can traverse through the map to find the character with the left most index, and remove the corresponding character from our map. 
//Since the range of characters is constrained, we should be able to find the left most index in constant time.
// time: O(n)
// space: O(1)
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> index_map = new HashMap<>();
        int right = 0;
        int length = 0, max_length = 0;
        
        while(right < s.length()){
            char right_char = s.charAt(right);
            index_map.put(right_char, right);
            right++;
            length++;
            if(index_map.size() > 2){
                int left = s.length() - 1;
                for(int index: index_map.values()){
                    left = Math.min(left, index);
                }
                char left_char = s.charAt(left);
                index_map.remove(left_char);
                length = right - left - 1;
            }
            if(length > max_length) max_length = length;
        }
        return max_length;
    }
}
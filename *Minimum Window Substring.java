// Here I want to use sliding window algorithm. 
// We have a hashmap to record the frequency of each character in target string.
// And 'left', 'right' variables defines the range of the window.
// 'size' variable record the number of character in target string.
// If the map contains a character pointed by 'right' as key, then we decrease its frequency.
// When the frequency equals to 0, it means we find all the character in the sliding window. And we decrease the 'size'.
// Once 'size' == 0, it means that we find all characters of the target string, and we need to increase the 'left' pointer to find the minimum length of substring.
// If map contains the character pointed by the left as key, we increase its frequency.
// Once its frequency is > 0, it means that in the current sliding window, it does not contains enough character of 'left_char' any anymore. So, we increase the 'size'.
// When we update the 'left' pointer, we also record the left and right index of substring with minimum length.
// When right >= s.length(), we jump out of the loop and return the substring with mimmum length.
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> frequency_map = new HashMap<>();
        int left = 0, right = 0;
        int ret_left = 0, ret_right = 0;
        int length = s.length();
        for(int i = 0; i < t.length(); i++){
            char cha = t.charAt(i);
            if(!frequency_map.containsKey(cha)) frequency_map.put(cha, 0);
            frequency_map.put(cha, frequency_map.get(cha) + 1);
        }
        int size = frequency_map.size();
        
        while(right < s.length()){
            char right_char = s.charAt(right);
            if(frequency_map.containsKey(right_char)){
                frequency_map.put(right_char, frequency_map.get(right_char) - 1);
                if(frequency_map.get(right_char) == 0) size--;
            }
            right++;
            
            while(size == 0){
                if(right - left <= length){
                    ret_left = left;
                    ret_right = right;
                    length = right - left;
                }
                char left_char = s.charAt(left);
                if(frequency_map.containsKey(left_char)){
                    frequency_map.put(left_char, frequency_map.get(left_char) + 1);
                    if(frequency_map.get(left_char) > 0) size++;
                }
                left++;
            }
        }
        if(ret_left == ret_right) return "";
        return s.substring(ret_left, ret_right);
    }
}




class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null) return "";
        int counter = t.length();
        int min = s.length();
        int min_start = -1;
        int min_end = -1;
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 0);
            }
        }
        
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c) && map.get(c) > 0){
                //System.out.println("char is " + c);
                counter --;
            }
            map.put(c, map.get(c) - 1);
            while(counter == 0){
                //System.out.println("start is " + start);
                //System.out.println("end is " + end);
                if(end - start < min){
                    min = end - start;
                    min_start = start;
                    min_end = end;
                }
                if(map.get(s.charAt(start)) == 0){
                    counter++;
                }
                map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                start++;
            }
            end++;
        }
        if(min_start == -1) return "";
        else return s.substring(min_start, min_end + 1);
    }
}
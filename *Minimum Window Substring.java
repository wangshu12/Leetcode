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
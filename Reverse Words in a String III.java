class Solution {
    public String reverseWords(String s) {
        if(s == null) return null;
        if(s.length() == 0) return "";
        
        char[] chars = s.toCharArray();
        int i = 0, j = 0;
        while(j < s.length()){
            while(j < s.length() && chars[j] != ' ') j++;
            if(j <= s.length()){
                swap(i, j, chars);
            }
            j ++;
            i = j;
        }
        return new String(chars);
    }
    
    public void swap(int i, int j, char[] chars){
        j --;
        while(i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i ++;
            j --;
        }
    }
}
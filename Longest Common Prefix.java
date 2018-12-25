class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null) return null;
        if(strs.length == 0) return "";
        String maxPre = strs[0];
        int index = 1;
        while(index < strs.length){
            maxPre = commonPrefix(maxPre, strs[index]);
            index++;
        }
        return maxPre;
    }
    
    private String commonPrefix(String str1, String str2){
        if(str1 == null) return str2;
        if(str2 == null) return str1;
        if(str1.length() == 0 || str2.length() == 0) return "";
        int index1 = 0, index2 = 0;
        while(index1 < str1.length() && index2 < str2.length() && str1.charAt(index1) == str2.charAt(index2)){
            index1++;
            index2++;
        }
        return str1.substring(0, index1);
    }
}
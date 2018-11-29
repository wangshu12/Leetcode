class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
        if(haystack.length() == 0 && needle.length() == 0) return 0;
        if(haystack.length() == 0) return -1;
        if(needle.length() == 0) return 0;
        int[] lps = buildLPS(needle);
        int h = 0;
        int l = 0;
        while(h < haystack.length()){
            System.out.println(h + " " + haystack.charAt(h) + " " + l + needle.charAt(l));
            if(haystack.charAt(h) == needle.charAt(l)){
                h++;
                l++;
            }else{
                if(l > 0){
                    l = lps[l - 1];
                }else{
                    h++;
                }
                
            }
            if(l == needle.length()){
                return h - needle.length();
            }
        }
        return -1;
    }
    
    public int[] buildLPS(String needle){
        int[] ret = new int[needle.length()];
        ret[0] = 0;
        int len = 0;
        int index = 1;
        while(index < needle.length()){
            if(needle.charAt(len) == needle.charAt(index)){
                len++;
                ret[index] = len;
                index++;
            }else{
                if(len != 0){
                    len = ret[len - 1];
                }else{
                    ret[index] = len;
                    index++;
                }
            }
        }
        return ret;
    }

}
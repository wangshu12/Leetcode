class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return "";
        String ret = "1";
        while(n > 1){
            ret = generateNextString(ret);
            n--;
        }
        return ret;
    }
    
    private String generateNextString(String str){
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < str.length()){
            int start = index;
            while(index < str.length() && str.charAt(index) == str.charAt(start)) index++;
            sb.append(index - start);
            sb.append(str.charAt(start));
        }
        return sb.toString();
    }
}
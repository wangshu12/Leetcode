class Solution {
    public String toLowerCase(String str) {
        if(str == null) return null;
        //if(str.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c <= 'Z' && c >= 'A'){
                c = (char)(c + 32);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
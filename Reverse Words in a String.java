public class Solution {
    public String reverseWords(String s) {
        if(s == null) return "";
        if(s.length() == 0) return "";
        String[] arr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i > 0; i --){
            sb.append(arr[i] + " ");
        }
        sb.append(arr[0]);
        return sb.toString();
    }
}
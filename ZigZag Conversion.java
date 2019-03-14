class Solution {
    public String convert(String s, int numRows) {
        if(s == null) return null;
        if(s.length() == 0 || numRows <= 0) return "";
        StringBuilder sb = new StringBuilder();
        int step1 = 2 * numRows - 2;
        int step2 = 0;
        int startIndex = 0;
        if(step1 == 0) return s;
        while(step1 >= 0 && startIndex < s.length()){
            int index = startIndex;
            sb.append(s.charAt(index));
            while(index < s.length()){
                index = index + step1;
                if(index < s.length() && step1 != 0){
                    sb.append(s.charAt(index));
                }
                index = index + step2;
                if(index < s.length() && step2 != 0){
                    sb.append(s.charAt(index));
                }
            }
            startIndex++;
            step1 -= 2;
            step2 += 2;
        }
        return sb.toString();
    }
}
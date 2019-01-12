class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int startIndex = 0;
        int index = 0;
        while(index < str.length() && str.charAt(index) == ' ') index++;
        if(index == str.length()) return 0;
        startIndex = index;
        if(str.charAt(index) == '-' || str.charAt(index) == '+') {
            index ++;
        }
        if(index >= str.length() || !Character.isDigit(str.charAt(index))) return 0;
        while(index < str.length() && Character.isDigit(str.charAt(index))){
            index++;
        }
        if(startIndex - index == 1 && (str.charAt(startIndex) == '-' || str.charAt(startIndex) == '+')) return 0;
        double result = Double.parseDouble(str.substring(startIndex, index));
        if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) result;
    }
}
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] array = S.toCharArray();
        for(int start = 0, end = S.length() - 1; start < end; start++, end--){
            while(start < end && !Character.isLetter(array[start])) start++;
            while(start < end && !Character.isLetter(array[end])) end--;
            if(start < end){
                char temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
        return new String(array);
    }
}
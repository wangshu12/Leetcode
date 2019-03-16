class Solution {
    public int rotatedDigits(int N) {
        int counter = 0;
        for(int i = 1; i <= N; i++){
            if(validReversedNum(i)){
                counter++;
            }
        }
        return counter;
    }
    
    public boolean validReversedNum(int N){
        char[] charArr = Integer.toString(N).toCharArray();
        boolean notEquals = false;
        for(int i = 0; i < charArr.length; i++){
            char c = charArr[i];
            if(c == '3' || c == '4' || c == '7'){
                return false;
            }else if(!notEquals && (c == '2' || c == '5' || c == '6' || c == '9')){
                notEquals = true;
            }
        }
        return notEquals;
    }
}
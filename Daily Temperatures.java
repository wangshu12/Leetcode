// Stack stores a list of number whose value is greater than current value, and they are ordered in decreasing by their value.
// And the numbers in the stack are waiting for the first number whose value is greater than theirs.
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> s = new Stack<>();
        if(T == null || T.length == 0) return new int[0];
        int[] ret = new int[T.length];
        
        for(int i = 0; i < T.length; i++){
            while(s.size() > 0 && T[i] > T[s.peek()]){
                int index = s.pop();
                ret[index] = i - index;
            }
            s.add(i);
        }
        ret[T.length - 1] = 0;
        return ret;
    }
}
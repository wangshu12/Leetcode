// We use stack to remember index of parentheses that separate valid parenthesis sequence.
//      if character is not ')': we push the index into stack
//      else: if stack is not empty and peek is '(', then we pop the index of the left parentheses
//            else we push the index into stack.
//base case: if the stack is empty, then the longest valid parentheses is length of the string itself.
//iteration: iterate the stack and find the longest valid parentheses.
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> indexes = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ')'){
                indexes.push(i);
            }else{
                if(!indexes.isEmpty() && s.charAt(indexes.peek()) == '(' ){
                    indexes.pop();
                }else{
                    indexes.push(i);
                }
            }
        }
        if(indexes.isEmpty()) return s.length();
        int ret = 0;
        int right = s.length();
        while(!indexes.isEmpty()){
            int left = indexes.pop();
            if(right - left - 1 > ret) ret = right - left - 1;
            right = left;
        }
        return Math.max(ret, right);
    }
}
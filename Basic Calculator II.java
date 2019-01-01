class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        //s = s.trim(); //!!! starting space and tail space!!!!
        int num = 0;
        char prev_sign = '+';
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){ // if we check c != ' ', then we dont need to trim.
                if(prev_sign == '+'){
                    stack.push(num);
                }else if(prev_sign == '-'){
                    stack.push(-num);
                }else if(prev_sign == '*'){
                    stack.push(stack.pop() * num);
                }else if(prev_sign == '/'){
                    stack.push(stack.pop() / num);
                }
                prev_sign = c;
                num = 0;
            }
        }
        int ret = 0;
        for(int n: stack){
            ret += n;
        }
        return ret;
    }
}
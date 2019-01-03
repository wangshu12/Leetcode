class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char prev_sign = '+';
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + c - '0';
            }
            if(c == '('){
                Stack<Character> para = new Stack<>();
                para.add(c);
                int start = i + 1;
                i++; // !!!! skip '('
                for(; i < s.length() && !para.isEmpty(); i++){
                    if(s.charAt(i) == '('){
                        para.add('(');
                    }else if(s.charAt(i) == ')'){
                        para.pop();
                    }
                }
                i--; // !!!!!because there is i++ at the end of the for loop.
                num = calculate(s.substring(start, i));
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
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
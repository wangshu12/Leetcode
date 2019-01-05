class Solution {
    public int calculate(String s) {
        int num = 0, prev_num1 = 0, prev_num2 = 0;
        char prev_sign = '+';
        for(int index = 0; index < s.length(); index++){
            char c = s.charAt(index);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }else if(c == '('){
                index++;
                int start = index;
                int counter = 1;
                while(counter != 0){
                    if(s.charAt(index) == '(') counter++;
                    else if(s.charAt(index) == ')') counter--;
                    index++;
                }
                index--;
                num = calculate(s.substring(start, index));
            }
            
            if(c =='+' || c=='-' ||c =='*' ||c =='/' || index == s.length() - 1){
                if(prev_sign == '+' || prev_sign == '-'){
                    prev_num1 += prev_num2;
                    if(prev_sign == '+'){
                        prev_num2 = num;
                    }else{
                        prev_num2 = -num;
                    }
                }else if(prev_sign == '*'){
                    prev_num2 = prev_num2 * num;
                }else{
                    prev_num2 = prev_num2 / num;
                }
                prev_sign = c;
                num = 0;
            }
        }
        return prev_num1 + prev_num2;
    }
}
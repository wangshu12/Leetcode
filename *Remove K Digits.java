class Solution {
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0 || k == 0) return num;
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        while(i < num.length()){
            char cur = num.charAt(i);
            while(!stack.isEmpty() && cur < stack.peekLast() && k > 0){
                stack.pollLast();
                k--;
            }
            stack.addLast(cur);
            i++;
        }
        // Dealing situation when stack is ascending and k > 0.
        while(!stack.isEmpty() && k > 0){
            stack.pollLast();
            k--;
        }
        // Dealing with starting 0.
        while(!stack.isEmpty()&&stack.peekFirst() == '0'){
            stack.pollFirst();
        }
        // Dealing with emtpy stack.
        if(stack.size() == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
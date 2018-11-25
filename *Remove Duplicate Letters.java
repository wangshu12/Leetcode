
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> ret_stack = new Stack<>();
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        char[] char_arr = s.toCharArray();
        for(int i = 0; i < char_arr.length; i++){
            count[char_arr[i] - 'a']++;
        }
        
        for(int i = 0; i < char_arr.length; i++){
            count[char_arr[i] - 'a'] --;
            if(visited[char_arr[i] - 'a']) continue;
            while(ret_stack.size() > 0 && char_arr[i] < ret_stack.peek() && count[ret_stack.peek() - 'a'] > 0){
                int c = ret_stack.pop();
                visited[c - 'a'] = false;
            }
            ret_stack.push(char_arr[i]);
            visited[char_arr[i] - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(char c: ret_stack){
            sb.append(c);
        }
        return sb.toString();
    }
}
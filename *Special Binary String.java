class Solution {
    public String makeLargestSpecial(String S) {
        List<String> ret_arr = new ArrayList<>();
        int count = 0;
        int left = 0;
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if(c == '1'){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                String str = "1" + makeLargestSpecial(S.substring(left + 1, i)) + "0";
                ret_arr.add(str);
                left = i + 1;
            }
        }
        Collections.sort(ret_arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String s: ret_arr){
            sb.append(s);
        }
        return sb.toString();
    }
}
//We can think of this problem as valid parenthesis problems. 
//'1' represents the left parenthesis, and '0' represents the right parenthesis.
//So the special string is a valid parenthesises.
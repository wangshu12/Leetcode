class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        
        int[] table = new int[num1.length() * num2.length()+1];
        int index = table.length - 1;
        int end = table.length - 1;
        //build table
        for(int i = num1.length() - 1; i >= 0; i--){
            int digit1 = (int)(num1.charAt(i) - '0');
            int carry_on = 0;
            int index_cursor = index;
            int result = 0;
            for(int j = num2.length() - 1; j >= 0; j--){
                int digit2 = (int)(num2.charAt(j) - '0');
                result = digit1 * digit2 + carry_on + table[index_cursor];
                table[index_cursor] = result % 10;
                carry_on = result / 10;
                index_cursor--;
            }
            while(carry_on > 0){
                result = carry_on + table[index_cursor];
                table[index_cursor] = result % 10;
                carry_on = result / 10;
                index_cursor--;
            }
            end = Math.min(index_cursor, end);
            index--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = end + 1; i < table.length; i++){
            sb.append(Integer.toString(table[i]));
        }
        return sb.toString();
    }
}
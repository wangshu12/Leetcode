class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0) return num2;
        if(num2 == null || num2.length() == 0) return num1;
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0, sum = 0;
        StringBuilder sb = new StringBuilder();
        while(index1 >= 0 || index2 >= 0){
            sum = carry;
            if(index1 >= 0) sum += num1.charAt(index1) - '0';
            if(index2 >= 0) sum += num2.charAt(index2) - '0';
            carry = sum / 10;
            sb.append(sum % 10);
            index1--;
            index2--;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
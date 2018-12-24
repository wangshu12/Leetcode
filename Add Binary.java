class Solution {
    public String addBinary(String a, String b) {
        if(a == null) return b;
        if(b == null) return a;
        int index_a = a.length() - 1;
        int index_b = b.length() - 1;
        int sum = 0, carry = 0;
        StringBuilder sb = new StringBuilder();
        while(index_a >= 0 || index_b >= 0){
            sum = carry;
            if(index_a >= 0) sum += a.charAt(index_a) - '0';
            if(index_b >= 0) sum += b.charAt(index_b) - '0';
            carry = sum / 2;
            sb.append(sum % 2);
            index_a --;
            index_b --;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
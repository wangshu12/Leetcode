class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int end1 = 0;
        int end2 = 0;
        long carry_on = 0;
        int zero_counter = 0;
        int index = 0;
        if(num1.charAt(0) == '-'){
            end1 = 1;
        }
        if(num2.charAt(0) == '-'){
            end2 = 1;
        }
        ArrayList<String> nums = new ArrayList<>();
        while(index1 >= end1){
            int c1 = (int)(num1.charAt(index1) - '0');
            carry_on = 0;
            index2 = 0;
            sb.setLength(0);
            for(int i = 0; i < zero_counter; i++){
                sb.append("0");
            }
            while(index2 >= end2){
                int c2 = (int)(num2.charAt(index2) - '0');
                long result = c1 * c2 + carry_on;
                carry_on = result / 10;
                sb.append(Integer.toString((int)(result % 10)));
                index2--;
            }
            
            while(carry_on > 0){
                sb.append(Integer.toString((int)(carry_on % 10)));
                carry_on /= 10;
            }
            String s = sb.reverse().toString();
            index = Math.max(s.length(), index);
            nums.add(s);
            zero_counter++;
        }
        carry_on = 0;
        sb.setLength(0);
        for(int i = 0; i < index; i++){
            int sum = 0;
            for(int j = 0; j < nums.size(); j++){
                String num_str = nums.get(j);
                sum += (int)(num_str.charAt(num_str.length() - i - 1) - '0');
            }
            sum += carry_on;
            sb.append(Integer.toString(sum % 10));
            carry_on = sum / 10;
        }
        
        while(carry_on > 0){
            sb.append(carry_on % 10);
            carry_on /= 10;
        }
        
        return sb.reverse().toString();
    }

}
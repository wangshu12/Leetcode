class Solution {
    public String numberToWords(int num) {
        String[]word1 = {"", "Thousand", "Million", "Billion"};
        String ret = "";
        int count = 0;
        if(num == 0) return "Zero";
        
        //This while loop determine that whether the input is Thousand, Million, Billion and so on.
        while(num > 0){
            String s = helper(num % 1000).trim();
            if(!s.equals("") && count > 0){
                s = s +" "+ word1[count] + " ";
            }
            count ++;
            num = num / 1000;
            ret = s + ret;
        }
        return ret.trim();
    }
    
    
    //This helper determine the string of number under 1000.
    public String helper(int num){
        String[]word2 = {"", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[]word3 = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        StringBuilder sb = new StringBuilder();
        
        //Determine hundreds
        if(num > 99){
            sb.append(word3[num / 100 - 1] + " " + "Hundred ");
        }
        //Determine tens
        int ten = num % 100;
        if(ten == 0) return sb.toString();
        //Use word3 or use (word2 and word3)
        if(ten < 20){
            sb.append(word3[ten - 1] + " ");
        }else{
            sb.append(word2[ten/10 - 1] + " ");
            if(ten%10 != 0){
                sb.append(word3[ten%10 - 1] + " ");
            }
        }
        return sb.toString();
    }
}
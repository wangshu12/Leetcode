class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        
        Comparator<String> com = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(strs, com);
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s);
        }
        String ret = sb.toString();
        if(ret.charAt(0) == '0') return "0";
        return ret;
    }
}
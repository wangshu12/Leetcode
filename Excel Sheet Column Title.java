class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n --; // we assume that 'A' -- 0, so we minus 1 in here.
            int mod = n % 26;
            n = n / 26;
            sb.append((char)('A' + mod));
        }
        return sb.reverse().toString();
    }
}
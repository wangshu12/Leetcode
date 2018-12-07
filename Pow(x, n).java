class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        if(n == Integer.MAX_VALUE){
            if(x == 1 || x == -1) return x;
            else return 0;
        }
        if(n == Integer.MIN_VALUE){
            if(x == 1 || x == -1) return 1;
            else return 0;
        }
        if(n < 0){
            n = -n;
            x = 1/x;
        }
        if(n % 2 == 0){
            return myPow(x * x, n / 2);
        }else{
            return x * myPow(x * x, n / 2);
        }
    }
}
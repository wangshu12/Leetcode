class Solution {
    public int countPrimes(int n) {
        if(n <= 1) return 0;
        int num = 2;
        int counter = 0;
        while(num < n){
            if(isPrime(num)){
                counter++;
            }
            num++;
        }
        return counter;
    }

    private boolean isPrime(int num){
        if(num == 2 || num == 3) return true;
        if(num % 2 == 0 || num % 3 == 0) return false;
        for(int i = 5; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}

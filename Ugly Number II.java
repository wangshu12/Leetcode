class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        TreeSet<Double> queue = new TreeSet<>();
        queue.add(2.0);
        queue.add(3.0);
        queue.add(5.0);
        while(n > 0 && !queue.isEmpty()){
            Double num = queue.pollFirst();
            n--;
            if(n == 1) return num.intValue();
            queue.add(num * 2);
            queue.add(num * 3);
            queue.add(num * 5);
        }
        return -1;
    }
}


// Because we want to find positive numbers whose prime facto include 2, 3, 5, 
// we know that the subsequent numbers equal to the previous numbers in the list mutiply 2, 3, or 5.
// First, I want to have a table to store the previous ugly number;
// Then I want to have three variables to point to the number that which number should multiply 2, which one should.....
// Besides, I want to have three variables to store the result of after multiplying 2, 3, or 5, 
// because I want to find the minimum number, and put it into the dp table.


class Solution {
    public int nthUglyNumber(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] table = new int[n];
        table[0] = 1;
        int index2 = 0;
        int min2 = 2;
        int index3 = 0;
        int min3 = 3;
        int index5 = 0;
        int min5 = 5;
        
        for(int i = 1; i < table.length; i++){
            int min = Math.min(Math.min(min2, min3), min5);
            table[i] = min;
            if(min == min2){
                index2++;
                min2 = 2 * table[index2];
            }
            
            if(min == min3){
                index3++;
                min3 = 3 * table[index3];
            }
            
            if(min == min5){
                index5++;
                min5 = 5 * table[index5];
            }
        }
        return table[n - 1];
    }
}
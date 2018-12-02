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
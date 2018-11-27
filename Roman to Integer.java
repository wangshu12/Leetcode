class Solution {
    public int romanToInt(String s) {
    	HashMap<Character, Integer> map = new HashMap<>();
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);

    	int prev = 0;
    	int next = 0;
    	int sum = map.get(s.charAt(s.length() - 1));
    	for(int i = 0; i < s.length(); i ++){
    		next = map.get(s.charAt(i));
    		if(prev < next) prev = -prev;
    		sum += prev;
    		prev = next;
    	}
    	return sum;
    }
}
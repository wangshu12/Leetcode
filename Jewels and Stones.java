class Solution {
    public int numJewelsInStones(String J, String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        int ret = 0;
        for(int i = 0; i < J.length(); i++){
            char j = J.charAt(i);
            if(map.containsKey(j)){
                ret += map.get(j);
            }
        }
        return ret;
    }
}
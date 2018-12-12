class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if(wall == null || wall.size() == 0 || wall.get(0).size() == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < wall.size(); i++){
            int length = 0;
            List<Integer> list = wall.get(i);
            for(int j = 0; j < list.size() - 1; j++){
                length += list.get(j);
                if(!map.containsKey(length)){
                    map.put(length, 0);
                }
                map.put(length, map.get(length) + 1);
                if(map.get(length) > count){
                    count = map.get(length);
                }
            }
        }
        return wall.size() - count;
    }
}
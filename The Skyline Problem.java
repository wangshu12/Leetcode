class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ret = new ArrayList<>();
        if(buildings == null) return ret;
        List<int[]> edgePoints = new ArrayList<>();
        for(int i = 0; i < buildings.length; i++){
            int[] building = buildings[i];
            edgePoints.add(new int[]{building[0], -building[2]});
            edgePoints.add(new int[]{building[1], building[2]});
        }
        Collections.sort(edgePoints, (a,b) ->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int prevHeight = 0;
        PriorityQueue<Integer> heights = new PriorityQueue<>((a, b) -> b - a);
        heights.add(0);
        for(int i = 0; i < edgePoints.size(); i++){
            int[] point = edgePoints.get(i);
            if(point[1] < 0){
                heights.add(-point[1]);
            }else{
                heights.remove(point[1]);
            }
            if(heights.peek() != prevHeight){
                ret.add(new int[]{point[0], heights.peek()});
                prevHeight = heights.peek(); // update to current highest height.
            }
        }
        return ret;
    }
}
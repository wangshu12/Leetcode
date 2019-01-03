class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> flights_map = new HashMap<>();
        for(int i = 0; i < flights.length; i++){
            int[] flight = flights[i];
            if(!flights_map.containsKey(flight[0])){
                flights_map.put(flight[0], new HashMap<>());
            }
            flights_map.get(flight[0]).put(flight[1], flight[2]);
        }
        
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        queue.add(new int[]{0, src, 0});
        while(!queue.isEmpty()){
            int[] record = queue.poll();
            int price = record[0];
            int city = record[1];
            int stops = record[2];
            if(city == dst) return price;
            Map<Integer, Integer> neighbors = flights_map.get(city);
            if(neighbors == null || stops > K) continue; //!! stops > K
            for(int des: neighbors.keySet()){
                queue.add(new int[]{price + neighbors.get(des), des, stops + 1});
            }
        }
        return -1;
    }
}
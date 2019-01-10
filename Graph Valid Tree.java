class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        HashMap<Integer, Set<Integer>> edges_map = new HashMap<>();
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        for(int i = 0; i < edges.length; i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if(!edges_map.containsKey(node1)) edges_map.put(node1, new HashSet<Integer>());
            if(!edges_map.containsKey(node2)) edges_map.put(node2, new HashSet<Integer>());
            edges_map.get(node1).add(node2);
            edges_map.get(node2).add(node1);
        }
        
        int[] v = new int[visited.length];
        if(hasCycleBFS(0, edges_map, visited, parent)) return false;
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                System.out.println(i);
                return false;
            }
        }
        return true;
    }
    
    private boolean hasCycle(int root, HashMap<Integer, Set<Integer>> edges_map, boolean[] visited, int[] parent){
        if(visited[root]) return true;
        
        visited[root] = true;
        Set<Integer> neighbors = edges_map.get(root);
        if(neighbors == null) return false;
        for(int neighbor: neighbors){
            if(parent[root] == neighbor) continue;
            parent[neighbor] = root;
            if(hasCycle(neighbor, edges_map, visited, parent)) return true;
        }
        return false;
    }
    
    private boolean hasCycleBFS(int root, HashMap<Integer, Set<Integer>> edges_map, boolean[] visited, int[] parent){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited[root] = true;
        while(!queue.isEmpty()){
            Integer cursor = queue.poll();
            if(edges_map.get(cursor) == null) continue;
            
            for(Integer nei: edges_map.get(cursor)){
                if(parent[cursor] == nei) continue;
                if(visited[nei]) return true;
                visited[nei] = true;
                parent[nei] = cursor;
                queue.add(nei);
            }
        }
        return false;
    }
    
//     private boolean hasCycleIterative(int root, HashMap<Integer, Set<Integer>> edges_map, boolean[] visited, int[] v){
//         Stack<int[]> stack = new Stack<>();
//         stack.push(new int[] {root, root});
        
//         while(!stack.isEmpty()){
//             int[] nodes = stack.pop();
//             int parent = nodes[1];
//             int node = nodes[0];
//             if(v[node] == 1) return true;
//             System.out.println(node);
//             if(v[node] == -1) return false;
//             System.out.println(node);
//             v[node] = 1;
//             for(int nei: edges_map.get(node)){
//                 stack.push(new int[]{nei, node});
//             }
//             v[node] = -1;
//         }
//         return false;
//     }
    
}
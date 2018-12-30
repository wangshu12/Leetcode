// dfs
class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        HashMap<Integer, List> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            if(!map.containsKey(edges[i][0])){
                List<Integer> list = new ArrayList<>();
                map.put(edges[i][0], list);
            }
            map.get(edges[i][0]).add(edges[i][1]);
            if(!map.containsKey(edges[i][1])){
                List<Integer> list = new ArrayList<>();
                map.put(edges[i][1], list);
            }
            map.get(edges[i][1]).add(edges[i][0]);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(visited, map, i);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(boolean[] visited, HashMap<Integer, List> map, int node){
        visited[node] = true;
        if(!map.containsKey(node)) return;
        List<Integer> neighbors = map.get(node);
        for(int i = 0; i < neighbors.size(); i++){
            int neighbor = neighbors.get(i);
            if(!visited[neighbor]){
                dfs(visited, map, neighbor);
            }
        }
    }
}

// union found
class Solution {
    public int countComponents(int n, int[][] edges) {
        // if(edges == null || n < 0) return -1;
        // if(n == 0 || edges.length == 0 || edges[0].length == 0) return 0;
        // if(n == 1 || edges.length == 1) return 1;
        
        // The reseon why we comment these code is because for loop can handle all of them, and for loop can handle a edge case
        // which is: if we a many elements, but there is no edges, then we need to return n instead of 0;
        
        int[] root = new int[n];
        for(int i = 0; i < n; i++) root[i] = i;
        for(int i = 0; i < edges.length; i++){
            int root1 = find(root, edges[i][0]);
            int root2 = find(root, edges[i][1]);
            if(root1 != root2){
                n--;
                root[root2] = root1;
                // careful: union find is to build parent-child case, and it is easy for each child to find its parent.
                // and each child has only one parent (because int[] cannot store multiple integer for one index)
                // so here should not be root[edges[i][0]] = edges[i][1]; because it may override the prevoid root of node 0.
                // in root[root2] = root1, because each node has no parent, it is safe to assign root1 to roo2's parent.
            }
        }
        return n;
    }
    
    private int find(int[] root, int id){
        while(root[id] != id){
            //path compression: make every other node in path point to its grandparent. // O(M + Mlogn) m -- number of operation.
            root[id] = root[root[id]];
            id = root[id];
        }
        return id;
    }
    //另一个improvement： 看每次substree的size，把小一点size的tree放到大tree下。avoid tall tree
}
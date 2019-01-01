/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return helper(node, map);
    }
    
    private UndirectedGraphNode helper(UndirectedGraphNode root, HashMap<UndirectedGraphNode, UndirectedGraphNode> map){
        if(root == null) return null;
        if(map.containsKey(root)){
            return map.get(root);
        }
        
        UndirectedGraphNode newRoot = new UndirectedGraphNode(root.label);
        newRoot.neighbors = new ArrayList<UndirectedGraphNode>();
        map.put(root, newRoot);
        for(UndirectedGraphNode nei: root.neighbors){
            newRoot.neighbors.add(helper(nei, map));
        }
        return newRoot;
    }
}


//dfs
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);
    }
    
    private UndirectedGraphNode dfs(UndirectedGraphNode root, HashMap<UndirectedGraphNode, UndirectedGraphNode> map){
        //if(root == null) return null;
        UndirectedGraphNode newNode = new UndirectedGraphNode(root.label);
        List<UndirectedGraphNode> neighbors = new ArrayList<>();
        newNode.neighbors = neighbors;
        map.put(root, newNode);
        
        for(UndirectedGraphNode nei: root.neighbors){
            if(map.containsKey(nei)){
                neighbors.add(map.get(nei));
            }else{
                neighbors.add(dfs(nei, map));
            }
        }
        
        return newNode;
    }
}

//bfs
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode head) {
        Queue<UndirectedGraphNode> unvisited = new LinkedList<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        if(head == null) return null;
        unvisited.add(head);
        while(!unvisited.isEmpty()){
            UndirectedGraphNode node = unvisited.poll();
            if(!map.containsKey(node)){
                map.put(node, new UndirectedGraphNode(node.label));
                map.get(node).neighbors = new ArrayList<UndirectedGraphNode>();
            }
            
            for(UndirectedGraphNode nei: node.neighbors){
                if(!map.containsKey(nei)){
                    map.put(nei, new UndirectedGraphNode(nei.label));
                    unvisited.add(nei);
                }
                map.get(node).neighbors.add(map.get(nei));
            }
        }
        return map.get(head);
    }
}

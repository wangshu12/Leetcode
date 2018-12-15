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
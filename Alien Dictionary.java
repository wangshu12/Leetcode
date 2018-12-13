class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        HashMap<Character, Set<Character>> edge_map = new HashMap<>();
        HashMap<Character, Integer> indegree_map = new HashMap<>();
        //initialization
        for(String word: words){
            for(char c: word.toCharArray()){
                indegree_map.put(c, 0);
            }
        }
        
        //BUILD DATA BASE
        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i + 1];
            //Because we want to find the edge between two strings, we just compare char one by one until reaching the end of one string.
            int length = Math.min(word1.length(), word2.length());
            for(int j = 0; j < length; j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1 != c2){
                    Set<Character> set = new HashSet<>();
                    if(edge_map.containsKey(c1)) set = edge_map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        edge_map.put(c1, set);
                        indegree_map.put(c2, indegree_map.get(c2) + 1);
                    }
                    //Once we find the different characters, and then we can break the inner loop
                    break;
                }
            }
        }
        
        //USING TOPOLOGICAL SORT, WE FIND THE LEXICALGRAPHICAL ORDER OF THE DICTIONARY.
        Queue<Character> q = new LinkedList<>();
        for(Character c: indegree_map.keySet()){
            if(indegree_map.get(c) == 0) q.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char c = q.poll();
            sb.append(c);
            if(edge_map.containsKey(c)){
                Set<Character> neighbors = edge_map.get(c);
                for(char nei: neighbors){
                    int degree = indegree_map.get(nei);
                    degree--;
                    indegree_map.put(nei, degree);
                    if(degree == 0){
                        q.add(nei);
                    }
                }
            }
        }
        if(sb.length() < indegree_map.size()) return "";
        return sb.toString();
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> indegree_map = new HashMap<>();
        HashMap<Integer, Set<Integer>> prereq_map = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            indegree_map.put(i, 0);
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            int course1 = prerequisites[i][1];
            int course2 = prerequisites[i][0];
            Set<Integer> set = new HashSet<>();
            if(prereq_map.containsKey(course1)) set = prereq_map.get(course1);
            set.add(course2);
            prereq_map.put(course1, set);
            indegree_map.put(course2, indegree_map.get(course2) + 1);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] order = new int[numCourses];
        int counter = 0;
        for(int course: indegree_map.keySet()){
            if(indegree_map.get(course) == 0){
                q.add(course);
            }
        }
        
        while(!q.isEmpty()){
            int c1 = q.poll();
            order[counter] = c1;
            counter ++;
            if(prereq_map.containsKey(c1)){ // be carefule about this step: what if the node is a leaf.
                Set<Integer> set = prereq_map.get(c1);
                for(int c2: set){
                    indegree_map.put(c2, indegree_map.get(c2) - 1);
                    if(indegree_map.get(c2) == 0) q.add(c2);
                }
            }
        }
        if(counter < numCourses) return new int[0];
        return order;
        
    }
}
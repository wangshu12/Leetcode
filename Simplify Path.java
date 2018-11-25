class Solution {
    public String simplifyPath(String path) {
        String[] path_arr = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for(int i = 0; i < path_arr.length; i++){
            String p = path_arr[i];
            if(p.equals("..")){
                deque.pollLast();
            }else if(p.equals(".") || p.equals("")){
                continue;
            }else{
                deque.add(p); //be carefule is add, not push
            }
        }
        StringBuilder sb = new StringBuilder();
        if(deque.size() == 0) sb.append("/");
        while(!deque.isEmpty()){
            sb.append("/" + deque.pollFirst());
        }
        return sb.toString();
    }
}
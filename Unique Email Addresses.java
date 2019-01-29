class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < emails.length; i++){
            String email = getEmail(emails[i]);
            if(!set.contains(email)){
                set.add(email);
            }
        }
        return set.size();
    }
    
    private String getEmail(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '+'){
                while(s.charAt(i) != '@'){
                    i++;
                }
                sb.append(s.substring(i));
                break;
            }else if(c == '.'){
                continue;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
// 
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0) return true;
        if(t == null || t.length() == 0) return false;
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        if(i == s.length()) return true;
        return false;
    }
}



// Follow up:
// If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, 
// and you want to check one by one to see if T has its subsequence. 
// In this scenario, how would you change your code?
// Preprocessing: O(t.length)
// BS: O(s.length * log(t.length))

class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0) return true;
        if(t == null || t.length() == 0) return false;
        
        List<Integer>[] list = new List[256];
        for(int i = 0; i < t.length(); i++){
            int index = (int)t.charAt(i);
            if(list[index] == null){
                list[index] = new ArrayList<Integer>();
            }
            list[index].add(i);
        }
        
        int prevIndex = -1;
        for(int i = 0; i < s.length(); i++){
            if(list[s.charAt(i)] == null) return false;
            int index = bs(list[s.charAt(i)], prevIndex);
            System.out.println("index is "+ index);
            if(index == -1){
                return false;
            } 
            prevIndex = index;
        }
        return true;
    }
    
    private int bs(List<Integer> list, int value){
        int ret = -1;
        if(list.size() == 1 && list.get(0) > value) return list.get(0);
        int i = 0;
        int j = list.size();
        while(i < j){
            int mid_index = i + (j - i)/2;
            int mid = list.get(mid_index);
            if(mid <= value){
                i = mid_index+1;
            }else if(mid > value){
                ret = mid;
                j = mid_index;
            }
        }
        return ret;
    }
}
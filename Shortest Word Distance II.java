//Here we use hashmap data structure, where the key is the string, and the value is a list of index value;
//when we build the data structure, we iterate the words array, if we meet a new key, we put key and a new arraylist in the hashmap, then we get the value by the key, and add the index of the string to the arraylist;

//when we find the shortest words distance, which means we find the shortest difference of index, first we get the list of index of specified string key, so we have two lists of index; because the list is sorted when we build the hashmap datastructure, so we can use merge sort to find the min difference of index

//also, if we find the shortlest distance is 1, then we could just return it because we cannot do better than 1.
class WordDistance {
    
    //data structure: O()
    private HashMap<String, ArrayList<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<String, ArrayList<Integer>>();
        helper(words);
    }
    
    //time: O(n)
    public void helper(String[] words){
        for(int i = 0; i < words.length; i++){
            String s = words[i];
            if(!map.containsKey(s)){
                map.put(s, new ArrayList<Integer>());
            }
            map.get(s).add(i);
        }
    }
    
    //space: O(1)
    //time: O(n) -- merge sort!!!! where n is sum of length of two index lists.
    public int shortest(String word1, String word2) {
        ArrayList<Integer> list1 = map.get(word1);
        ArrayList<Integer> list2 = map.get(word2);
        int i = 0, j = 0;
        int ret = Integer.MAX_VALUE;
        while(i < list1.size() && j< list2.size()){
            int index1 = list1.get(i);
            int index2 = list2.get(j);
            if(index1 > index2){
                ret = Math.min(ret, index1 - index2);
                j++;
            }else{
                ret = Math.min(ret, index2 - index1);
                i++;
            }
            if(ret == 1) return 1; //once we find the min difference is 1, we just return it, because we cannot do better than 1.
        }
        return ret;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
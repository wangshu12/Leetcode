class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph == null || banned == null) return null;
        if(paragraph.length() == 0) return "";
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < banned.length; i++){
            set.add(banned[i]);
        }
        
        char[] para = paragraph.toCharArray();
        for(int j = 0; j < para.length; j++){
            while(j < para.length && !Character.isLetter(para[j])){
                j++;
            }
            int start = j;
            while(j < para.length && Character.isLetter(para[j])){
                j++;
            }
            int end = j;
            if(end <= para.length){
                String word = new String(para, start, end - start).toLowerCase();
                if(!map.containsKey(word)) map.put(word, 0);
                map.put(word, map.get(word) + 1);
            }
        }
        
        int length = 0;
        String ret = "";
        for(String s: map.keySet()){
            if(set.contains(s)) continue;
            int fre = map.get(s);
            if(fre > length){
                ret = s;
                length = fre;
            }
        }
        return ret;
    }
}
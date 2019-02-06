class WordDictionary {
    TrieNode dumpHead;
    /** Initialize your data structure here. */
    public WordDictionary() {
        dumpHead = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null){
            dumpHead.isWord = true;
            return;
        }
        TrieNode cursor = dumpHead;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cursor.nodes[(int)(c - 'a')] == null){
                cursor.nodes[(int)(c - 'a')] = new TrieNode();
            }
            cursor = cursor.nodes[(int)(c - 'a')];
        }
        cursor.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfsSearch(dumpHead, word, 0);
        //return bfsSearch(word);
    }
    
//     private boolean bfsSearch(String word){
//         int index = 0;
//         Queue<TrieNode> queue = new LinkedList<>();
//         queue.add(dumpHead);
//         while(queue.size() > 0 && index < word.length()){
//             int size = queue.size();
//             char c = word.charAt(index);
//             for(int i = 0; i < size; i++){
//                 TrieNode cursor = queue.poll();
//                 //System.out.println("here");
//                 if(c != '.'){
//                     if(cursor.nodes[(int)(c - 'a')] != null){
//                         queue.add(cursor.nodes[(int)(c - 'a')]);
//                     }
//                 }else{
//                     for(int j = 0; j < cursor.nodes.length; j++){
//                         if(cursor.nodes[j] != null){
//                             queue.add(cursor.nodes[j]);
//                         }
//                     }
//                 }
//             }
//             index++;
//         }
        
//         if(index < word.length()) return false;
//         while(!queue.isEmpty()){
//             TrieNode node = queue.poll();
//             if(node.isWord) return true;
//         }
//         //System.out.println("here");
//         return false;
//     }
    
    private boolean dfsSearch(TrieNode node, String word, int index){
        if(index == word.length()) return node.isWord;
        char c = word.charAt(index);
        int i = (int)(c - 'a');
        if(c != '.'){
            if(node.nodes[i] == null) return false;
            return dfsSearch(node.nodes[i], word, index+1);
        }else{
            for(int j = 0; j < node.nodes.length; j++){
                if(node.nodes[j] != null && dfsSearch(node.nodes[j], word, index + 1)){
                    return true;
                }
            }
            return false;
        }
    }
    
    
    class TrieNode{
        TrieNode[] nodes;
        boolean isWord;
        
        public TrieNode(){
            nodes = new TrieNode[26];
            isWord = false;
        }
    }
    
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
class Trie {
    /** Initialize your data structure here. */
    Node head;
    public Trie() {
        head = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cursor = head;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(cursor.char_arr[index] == null){
                Node newNode = new Node();
                cursor.char_arr[index] = newNode;
            }
            cursor = cursor.char_arr[index];
        }
        cursor.isString = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cursor = head;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(cursor.char_arr[index] == null) return false;
            cursor = cursor.char_arr[index];
        }
        return cursor.isString;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cursor = head;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(cursor.char_arr[index] == null) return false;
            cursor = cursor.char_arr[index];
        }
        return true;
    }
    
    class Node{
        boolean isString;
        Node[] char_arr;
        public Node(){
            isString = false;
            char_arr = new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
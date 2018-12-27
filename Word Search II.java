class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || words == null || words.length == 0) return new ArrayList<String>();
        TrieNode root = buildTrieTree(words);
        List<String> ret = new ArrayList<String>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, root, ret, i, j);
            }
        }
        return ret;
    }
    
    public void dfs(char[][] board, TrieNode root, List<String> ret, int i, int j){
        if(board[i][j] == '#' || root.next[board[i][j] - 'a'] == null) return;
        if(root.next[board[i][j] - 'a'].word != null) {
            ret.add(root.next[board[i][j] - 'a'].word);
            root.next[board[i][j] - 'a'].word = null;
        }
        char c = board[i][j];
        if(root.next[c - 'a'] != null){
            board[i][j] = '#';
            if(i > 0) dfs(board, root.next[c - 'a'], ret, i - 1, j);
            if(j > 0) dfs(board, root.next[c - 'a'], ret, i, j - 1);
            if(i < board.length - 1)  dfs(board, root.next[c - 'a'], ret, i + 1, j);
            if(j < board[0].length - 1)  dfs(board, root.next[c - 'a'], ret, i, j + 1);
            board[i][j] = c;
        }
    }
    
    public TrieNode buildTrieTree(String[] words){
        TrieNode root = new TrieNode();
        for(String s: words){
            TrieNode temp = root;
            for(char c: s.toCharArray()){
                if(temp.next[c - 'a'] == null) temp.next[c - 'a'] = new TrieNode();
                temp = temp.next[c - 'a'];
            }
            temp.word = s;
        }
        return root;
    }
}

class TrieNode{
    public TrieNode[] next = new TrieNode[26];
    public String word;
    public TrieNode(){
    }
}
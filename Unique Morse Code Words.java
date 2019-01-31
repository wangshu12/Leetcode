class Solution {
    private static String[] morseCode = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
                                                      "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-",
                                                      "...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        if(words == null || words.length == 0) return 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < words.length; i++){
            set.add(convertToMorse(words[i].toLowerCase()));
        }
        return set.size();
    }
    
    private String convertToMorse(String word){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            sb.append(morseCode[c - 'a']);
        }
        return sb.toString();
    }
}
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int prev = 0;
        int cursor = 0;
        List<String> ret = new ArrayList<>();
        while(cursor < words.length){
            // determine which words can be put in one line. Becuase it needs one space to seperate words, we need to check width + words[cursor].length() + cursor - prev <= maxWidth.
            prev = cursor;
            int width = 0;
            while(cursor < words.length){
                if(width + words[cursor].length() + cursor - prev > maxWidth) break;
                width += words[cursor].length();
                cursor++;
            }
            ret.add(generateLine(prev, cursor, words, maxWidth, width));
        }
        return ret;
    }
    
    private String generateLine(int start, int end, String[]words, int maxWidth, int width){
        if(start == end) return "";
        StringBuilder sb = new StringBuilder();
        //left justified -- append one space between words and fill the rest position with space.
        if(end == words.length || end - start == 1){
            while(start < end-1){
                sb.append(words[start] + " ");
                start++;
            }
            sb.append(words[start]); //!!!don't forget to append the last word.
            for(int i = sb.toString().length(); i < maxWidth; i++){
                sb.append(" ");
            }
        // divide space evenly    
        }else{
            int count = end - start - 1; // represent how many places that we can insert space.
            int base = (maxWidth-width) / count; // how many space at least between each word.
            int addition = (maxWidth-width) % count; //how many extra space.
            String space = ""; // at least these many space between each word.
            while(base > 0){
                space += " ";
                base--;
            }
            while(start < end - 1){
                sb.append(words[start]);
                sb.append(space);
                if(addition > 0){
                    sb.append(" ");
                    addition--;
                }
                start++;
            }
            sb.append(words[start]);//!!!don't forget to append the last word.
        }
        return sb.toString();
    }
}
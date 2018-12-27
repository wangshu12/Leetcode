package Algo;

import java.util.ArrayList;
import java.util.List;

public class PossibleWord {
    public static void main(String[] args){
        List<String> ret = getPossibleWords("d");
        for(int i = 0; i < ret.size(); i++){
            System.out.println(ret.get(i));
        }
    }

    //O(n^2)
    public static List<String> getPossibleWords(String s){
        List<String> ret = new ArrayList<>(); // keep insertion order
        if(s == null) return null;
        if(s.length() == 0) return ret;

        ret.add(s);
        
        for(int i = 0; i < s.length(); i++){
            int size = ret.size();//size will change, so store it in a variable before using it.
            
            for(int j = 0; j < size; j++){
                String str = ret.get(j);
                char c = str.charAt(i);
                if(c != 'a'){
                    ret.add(str.substring(0, i) + (char)(c - 1) + str.substring(i+1)); //convert to char!
                }
                if(c != 'z'){
                    ret.add(str.substring(0, i) + (char)(c + 1) + str.substring(i+1));
                }
            }
        }
        return ret;
    }
}

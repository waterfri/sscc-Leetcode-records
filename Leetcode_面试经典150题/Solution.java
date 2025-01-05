// 哈希表
// 双向映射  
import java.util.HashMap;
import java.util.Map;

public class Solution{
    public boolean wordPattern(String pattern, String s){
        String[] words = s.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        Map<Character, String> chartoword = new HashMap<>();
        Map<String, Character> wordtochar = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++){
            char x = pattern.charAt(i);
            String word = words[i];
            if(chartoword.containsKey(x)){
                if(!chartoword.get(x).equals(word)){
                    return false;
                }
            }
            else{
                chartoword.put(x, word);
            }
            // HashMap能使用 字符串 作为 键 或 值
            if(wordtochar.containsKey(word)){
                if(!wordtochar.get(word).equals(x)){
                    return false;
                }
            }
            else{
                wordtochar.put(word, x);
            }
        }
        return true;
    }
}
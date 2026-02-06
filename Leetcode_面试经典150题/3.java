// #3 无重复字符的最长字串
// 滑动窗口
// 哈希表
// 思路：
// HashMap 用来记录每个字符最后一次出现时的下标，
// 遍历字符串，判断当前字符是否在 当前窗口出现过
// 若该字符曾出现且其位置仍在当前窗口内，
// 则说明发生重复，需要移动左指针；否则可以安全扩展窗口并更新最大长度。

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> map = new HashMap<>(); // 字符 -> 下标
        int l = 0; 
        int result = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(map.containsKey(c) && map.get(c) >= l){
                l = map.get(c) + 1; // update left point
            }

            map.put(c, i);
            
            result = Math.max(result, i - l + 1);
        }

        return result;
    }
}
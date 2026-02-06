// #49 字母异位词
// 哈希表
// 思路：将所有字符串转换成字符数组，排序，用 Map<String, List<String>> 分组

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution{
    public List<List<String>> groupAnagrams(String[] strs){

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            // 1. 排序生成 key
            char[] c = s.toCharArray(); // 字符串 转 字符数组
            Arrays.sort(c); // 排序

            String key = new String(c); // 字符数组 转 字符串
            
            List<String> value = map.getOrDefault(key, new ArrayList<>()); // 获取当前 key 对应的 list
            value.add(s); // 添加 当前字符串

            map.put(key, value);
        }

        return new ArrayList<>(map.values()); // 这个构造方法可以接收一个 Collection
    }
}
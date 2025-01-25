// #30 串联所有单词的字串
// 滑动窗口
// 哈希表
// 字符串 
// 字串
// 字符串频率
// 分块遍历
// 模拟多滑动窗口

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // 算法思想：滑动窗口+哈希表
        // 滑动窗口用于遍历字符串
        // 建立两个哈希表分别用于记录当前窗口单词出现频率和 words 单词的频率
        // 分块遍历用于模拟多个滑动窗口
        // 分块遍历字符串 s ，检查当前窗口单词的频率与 words 中的单词频率是否满足条件，满足则有效，记录串联字串开始索引
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0){
            return result;
        }
        //
        int wordlen = words[0].length();
        int wordcount = words.length;

        // 统计 words 单词频率
        Map<String, Integer> wordsfreq = new HashMap<>();
        for(String word : words){
            wordsfreq.put(word, wordsfreq.getOrDefault(word, 0) + 1); 
        }
        // 分块遍历：遍历所有可能的起始点
        for(int i = 0; i < wordlen; i++){
            int l = i; // 滑动窗口左右指针
            int r = i;
            int count = 0; // 当前匹配单词的数量
            Map<String, Integer> windowfreq = new HashMap<>();

            // 从当前起始点开始滑动窗口
            while(r + wordlen <= s.length()){
                // 当前单词
                String word = s.substring(r, r + wordlen); // 提取字串
                r = r + wordlen;
                // 检查单词是否在 words 中
                if(wordsfreq.containsKey(word)){
                    windowfreq.put(word, windowfreq.getOrDefault(word, 0) + 1);
                    count++; // 匹配单词数量++
                    // 当前某个单词频率超标时，不能形成有效字串，收缩滑动窗口并更新频率，同时减少匹配单词数量
                    while(wordsfreq.get(word) < windowfreq.get(word)){
                        String leftword = s.substring(l, l + wordlen);
                        windowfreq.put(leftword, windowfreq.get(leftword) - 1);
                        count--;
                        l = l + wordlen;
                    }
                    // 如果包含所有单词
                    if(count == wordcount){
                        result.add(l); // 记录起始索引
                    }
                }
                // 单词不在 words 中，重置窗口
                else{
                    windowfreq.clear();
                    count = 0;
                    l = r;
                }
            }
        }
        return result;
    }
}
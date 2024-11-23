// #383 赎金信
// 字符计数
// ASCII值
#include <stdio.h>
#include <stdbool.h>

bool canConstruct(char* ransomNote, char* magazine) {
    int array[26] = {0}; // 初始化字符计数数组

    int i = 0;
    for(; i < strlen(ransomNote); i++){ // 统计 ransomNote各个字符数量
        array[ransomNote[i] - 'a']++;
    }
    for(i = 0; i<strlen(magazine); i++){
        array[magazine[i] - 'a']--;
    }
    for(int j = 0; j<26; j++){
        if(array[j]>0){
            return false;
        }
    }
    return true;
}

// 二刷
bool canConstruct(char* ransomNote, char* magazine) {
    // 每个字符使用一次：字符计数
    // 维护记录26个小写英文字母数量的 array数组
    int array[26] = {0};
    int i = 0;
    // 统计 ransomNote 字符数量
    for(; i < strlen(ransomNote); i++){
        array[ransomNote[i] - 'a']++;
    }
    // 统计 magazine字符数量
    for(i = 0; i < strlen(magazine); i++){
        array[magazine[i] - 'a']--;
    }
    for(i = 0; i < 26; i++){
        if(array[i] > 0){
            return false; // 不能构成
        }
    }
    return true; // 能构成
}
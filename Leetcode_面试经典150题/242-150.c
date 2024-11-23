// #242 有效的字母异位词
// 字符计数
// 哈希表

// 1.计数法（推荐）
#include <stdbool.h>

bool isAnagram(char* s, char* t) {
    if(strlen(s) != strlen(t)){
        return false;
    }
    int len = strlen(s);
    int count[256] = {0};
    for(int i = 0; i < len; i++){
        count[s[i]]++;
        count[t[i]]--;
    }
    for(int i = 0; i < 256; i++){
        if(count[i] != 0){
            return false;
        }
    }
    return true;
}

// 2.排序法
// 如果排序后字符串相等，则是字母异位词
// #392 判断子序列
// 双指针
#include <stdbool.h>

bool isSubsequence(char* s, char* t) {
    int count = 0;
    int j = 0; // 用于循环遍历 s
    int len_s = strlen(s);
    int len_t = strlen(t);
    for(int i=0; i<len_t && j<len_s; i++){
        if(t[i] == s[j]){ // 匹配，检查 s的下一个字符
            j++;
        }
    }
    return j == len_s; // 遍历完 s则返回 true，否则 false
}
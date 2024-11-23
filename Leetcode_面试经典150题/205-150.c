// #205 同构字符串
// 哈希表
// 字符串
// ASCII：256个字符
// 映射 双向映射
// 算法思想：单映射无法保证双向唯一性，建立双向映射
#include <stdbool.h>
bool isIsomorphic(char* s, char* t) {
    if(strlen(s) != strlen(t)){
        return false;
    }
    // 需要双向映射
    char map_s_to_t[256] = {0};
    char map_t_to_s[256] = {0};

    for(int i = 0; s[i] != '\0'; i++){
        char sc = s[i];
        char tc = t[i];
        // 判断是否满足映射关系
        if(map_s_to_t[sc] != 0 && map_s_to_t[sc] != tc || map_t_to_s[tc] != 0 && map_t_to_s[tc] != sc){
            return false;
        }
        // 建立映射
        map_s_to_t[sc] = tc;
        map_t_to_s[tc] = sc;
    }
    return true;
}
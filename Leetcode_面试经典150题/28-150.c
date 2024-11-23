// #28. 找出字符串中第一个匹配项的下标
// 双指针
// 字符串匹配
int strStr(char* haystack, char* needle) {
    int count = 0;
    for(int i=0; i<strlen(haystack); i++){
        int j = 0;
        for(; j<strlen(needle); j++){
            if(needle[j] != haystack[i+j]){
                break;
            }
            if(j == strlen(needle)-1){
                return i;
            }
        }
    }
    return -1;
}
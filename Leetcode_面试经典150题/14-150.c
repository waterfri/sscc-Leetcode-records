// #14 最长公共前缀
// 动态数组分配
// 先判空
// 按列遍历
// 注意字符串结尾
char* longestCommonPrefix(char** strs, int strsSize) {
    if(strsSize == 0){
        return "";
    }
    char* result;
    int minlength = strlen(strs[0]);
    for(int i=1; i<strsSize; i++){ // 获取最小字符串长度
        if(strlen(strs[i]) < minlength){
            minlength = strlen(strs[i]);
        }
    } // 最长公共前缀 <= minlength
    result = (char*)malloc((minlength + 1) * sizeof(char)); // '\0'需要一个额外空间
    // 逐列遍历
    for(int j=0; j<minlength; j++){
        char c = strs[0][j];
        for(int i=0; i<strsSize; i++){
            if(strs[i][j] != c){
                result[j] = '\0';
                return result;
            }
        }
        result[j] = c;
    }
    result[minlength] = '\0';
    return result;
}
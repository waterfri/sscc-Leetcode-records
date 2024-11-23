// #151 反转字符串中的单词
// 注意下标越界
// 字符串结束符
char* reverseWords(char* s) {
    int length = strlen(s);
    char* newStr = (char*)malloc((length + 1) * sizeof(char)); // 为'\0'预留空间
    int index = 0; // 新字符串的下标
    int end = length - 1; // 指向当前单词的最后一个字符
    while (end >= 0){
        if(s[end] == ' '){ // 跳过空格
            end--;
            continue;
        } // end指向单词的最后一个字符
        // 找到当前单词的开头
        int start = end;
        while(start >=0 && s[start] != ' '){ // start >= 0 防止越界
            start--;
        } // start指向单词的第一个字符的前一个位置
        // 将单词复制到新数组
        for(int i=start+1; i<=end; i++){
            newStr[index++] = s[i];
        }
        // 在每个单词的后面添加空格
        if(start >= 0){
            newStr[index++] = ' ';
        }
        end = start; // 更新 end
    }
    // 去除最后多余的空格
    if(index >= 0 && newStr[index-1] == ' '){
        index--;
    }
    newStr[index] = '\0';
    return newStr;
}
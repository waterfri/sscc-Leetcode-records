// 58-150 计算最后一个单词长度
// 处理空格的核心思想是 跳过
int lengthOfLastWord(char* s) {
    int l = strlen(s);
    int len = 0;
    // 跳过空格
    while(l>0 && s[l-1]==' '){
        l--;
    }
    // l指向第一个不为零的字母，开始计算单词长度
    for(int i=l-1;i>=0;i--){
        if(s[i]!=' '){
            len++;
        }
        if(s[i]==' '){
            break;
        }
    }
    return len;
}
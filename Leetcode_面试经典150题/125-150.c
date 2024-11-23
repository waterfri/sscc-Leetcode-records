// #125 验证回文串
// 双指针
// ASCII字符范围
// tolower()函数
#include <stdbool.h>
// 在标准的 C语言(C90和 C99)中，没有内置的 bool类型
bool isPalindrome(char* s) {
    if(strlen(s) == 0){
        return true;
    }
    int a = 0;
    while(s[a] != '\0'){
        s[a] = tolower(s[a]);
        a++;
    }

    char* new = (char*)malloc(sizeof(char) * strlen(s));
    int count = 0;

    for(int i=0; i<strlen(s); i++){
        if(s[i] >= 'a' && s[i] <= 'z' || s[i] >= '0' && s[i] <= '9'){
            new[count++] = s[i];
        }
    }
    
    int i = 0;
    int j = count-1;
    for(int k=0; k<count; k++){
        if(i <= j && (new[i] != new[j])){
            return false;
        }
        else{
            i++;
            j--;
        }
    }
    return true;
}
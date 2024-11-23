// #12 整数转罗马数字
// 注意罗马数字的最大长度
// continue 必须放在循环内，所以使用 break。注意防止缺少 break带来的贯穿效应
// 字符使用单引号，字符串才使用双引号
// 注意加上字符串结束符

// 更优解：建立一张表，代码见末尾
char* intToRoman(int num) {
    char* result;
    int index1 = 0;
    int index2 = 0;
    int index3 = 0;
    int index4 = 0;
    int i = 0;
    //分配内存
    result = (char*)malloc(16*sizeof(char)); // 0-3999对应的最长的罗马数字为15位，加上'\0'一共16位
    // 计算千位
    index1 = (num / 1000) % 10;
    switch(index1){
        case 0:  break;
        case 1:  result[i] = 'M'; i++; break;
        case 2:  result[i] = 'M'; result[i+1] = 'M'; i = i + 2; break;
        case 3:  result[i] = 'M'; result[i+1] = 'M'; result[i+2] = 'M'; i = i + 3; break;
    }
    
    // 计算百位
    index2 = (num / 100) % 10;
    switch(index2){
        case 0:  break;
        case 1:  result[i] = 'C'; i++; break;
        case 2:  result[i] = 'C'; result[i+1] = 'C'; i = i + 2; break;
        case 3:  result[i] = 'C'; result[i+1] = 'C'; result[i+2] = 'C'; i = i + 3; break;
        case 4:  result[i] = 'C'; result[i+1] = 'D'; i = i + 2; break;
        case 5:  result[i] = 'D'; i++; break;
        case 6:  result[i] = 'D'; result[i+1] = 'C'; i = i + 2; break;
        case 7:  result[i] = 'D'; result[i+1] = 'C'; result[i+2] = 'C'; i = i + 3; break;
        case 8:  result[i] = 'D'; result[i+1] = 'C'; result[i+2] = 'C'; result[i+3] = 'C'; i = i + 4; break;
        case 9:  result[i] = 'C'; result[i+1] = 'M'; i = i + 2; break;
    }
    
    // 计算十位
    index3 = (num / 10) % 10;
    switch(index3){
        case 0:  break;
        case 1:  result[i] = 'X'; i++; break;
        case 2:  result[i] = 'X'; result[i+1] = 'X'; i = i + 2; break;
        case 3:  result[i] = 'X'; result[i+1] = 'X'; result[i+2] = 'X'; i = i + 3; break;
        case 4:  result[i] = 'X'; result[i+1] = 'L'; i = i + 2; break;
        case 5:  result[i] = 'L'; i++; break;
        case 6:  result[i] = 'L'; result[i+1] = 'X'; i = i + 2; break;
        case 7:  result[i] = 'L'; result[i+1] = 'X'; result[i+2] = 'X'; i = i + 3; break;
        case 8:  result[i] = 'L'; result[i+1] = 'X'; result[i+2] = 'X'; result[i+3] = 'X'; i = i + 4; break;
        case 9:  result[i] = 'X'; result[i+1] = 'C'; i = i + 2; break;
    }
    
    // 计算个位
    index4 = num % 10;
    switch(index4){
        case 0:  break;
        case 1:  result[i] = 'I'; i++; break;
        case 2:  result[i] = 'I'; result[i+1] = 'I'; i = i + 2; break;
        case 3:  result[i] = 'I'; result[i+1] = 'I'; result[i+2] = 'I'; i = i + 3; break;
        case 4:  result[i] = 'I'; result[i+1] = 'V'; i = i + 2; break;
        case 5:  result[i] = 'V'; i++; break;
        case 6:  result[i] = 'V'; result[i+1] = 'I'; i = i + 2; break;
        case 7:  result[i] = 'V'; result[i+1] = 'I'; result[i+2] = 'I'; i = i + 3; break;
        case 8:  result[i] = 'V'; result[i+1] = 'I'; result[i+2] = 'I'; result[i+3] = 'I'; i = i + 4; break;
        case 9:  result[i] = 'I'; result[i+1] = 'X'; i = i + 2; break;

    }
    result[i] = '\0';
    return result;
}

// 更优解
const char* thousands[] = {"", "M", "MM", "MMM"};
const char* hundreds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
const char* tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
const char* ones[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

char* intToRoman(int num) {
    char* roman = malloc(sizeof(char) * 16);
    roman[0] = '\0';
    strcpy(roman + strlen(roman), thousands[num / 1000]);
    strcpy(roman + strlen(roman), hundreds[num % 1000 / 100]);
    strcpy(roman + strlen(roman), tens[num % 100 / 10]);
    strcpy(roman + strlen(roman), ones[num % 10]);
    return roman;
}
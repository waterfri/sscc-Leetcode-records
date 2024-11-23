// #6. Z字形变换
// strncat() strcat()函数的使用
// 算法思路：设置一个变量用于控制方向、设置一个变量控制行数
// 动态数组分配空间
char* convert(char* s, int numRows) {
    if(numRows == 1){
        return s;
    }
    int len = strlen(s);
    int row = 0; // 当前行，控制行数
    int going = 1; // 方向变量，1为向下，-1为向上
    // 分配结果的存储空间
    char* result = (char*)malloc((len + 1) * sizeof(char));
    result[0] = '\0';
    // Z形矩阵采用二维数组结构
    char** matrix = (char**)malloc(numRows * sizeof(char*));
    for(int i=0; i<numRows; i++){ // 为每一行分配存储空间，并初始化
        matrix[i] = (char*)malloc((len + 1) * sizeof(char));
        matrix[i][0] = '\0';
    }
    // 将原数组的元素按规则复制到矩阵
    for(int i=0; i<len; i++){ // 使用字符串拼接函数 strncat()
        strncat(matrix[row], &s[i], 1);
        if(row == numRows-1){
            going = -1;
        }
        else if(row == 0){
            going = 1;
        }
        row = row + going;
    }
    // 复制结果
    for(row=0; row<numRows; row++){ // strcat()
        strcat(result, matrix[row]);
        free(matrix[row]);  
    }
    result[len] = '\0';
    free(matrix);
    return result;
}
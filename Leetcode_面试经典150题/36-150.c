// #36 有效的数独
// 矩阵
// 数组
// 哈希表
// 算法思想：建立三个数组判断是否出现重复元素；continue跳过空格

#include <stdbool.h>
bool isValidSudoku(char** board, int boardSize, int* boardColSize) {
    // 采用三个二维数组，记录行，列，九宫格中数字是否出现
    // 第一维索引：行索引 列索引 九宫格索引
    int row[9][9] = {false};
    int col[9][9] = {false};
    int boxes[9][9] = {false};

    for(int i = 0; i < 9; i++){
        for(int j = 0; j < 9; j++){
            if(board[i][j] == '.'){
                continue; // 跳过空格
            }
            int num = board[i][j] - '1'; // 将字符转换为数字索引
            // 计算九宫格的索引
            int box_index = (i / 3) * 3 + (j / 3);
            // 判断是否重复
            if(row[i][num] || col[j][num] || boxes[box_index][num]){
                return false;
            }
            row[i][num] = true;
            col[j][num] = true;
            boxes[box_index][num] = true;
        }
    }
    return true;
}
// #54 螺旋矩阵
// 二维数组
// 矩阵
// 边界判断
// 算法思想：从四个方向遍历矩阵，螺旋矩阵：需要额外判断两个边界条件 如：单行矩阵

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

#include <stdlib.h>

int* spiralOrder(int** matrix, int matrixSize, int* matrixColSize, int* returnSize) {
    // 判空
    if(matrixSize == 0 || *matrixColSize == 0){
        *returnSize = 0;
        return NULL;
    }

    // 螺旋矩阵：需要两个额外边界判断条件
    // 定义四个边界
    int top = 0;
    int bottom = matrixSize - 1;
    int right = *matrixColSize - 1;
    int left = 0;
    // 分配存储空间
    int total_elements = *matrixColSize * matrixSize;
    *returnSize = total_elements;
    int *result = (int*)malloc(sizeof(int) * total_elements);
    
    int index = 0;
    while(top <= bottom && left <= right){
        // 从左至右
        for(int i = left; i <= right; i++){
            result[index++] = matrix[top][i];
        }
        top++;
        // 从上往下
        for(int i = top; i <= bottom; i++){
            result[index++] = matrix[i][right];
        }
        right--;
        // 从右往左
        // 特殊矩阵：如单行矩阵时，为了防止重复访问，需要额外判断
        if(top <= bottom){ // 检查是否还有行需要处理
            for(int i = right; i >= left; i--){
                result[index++] = matrix[bottom][i];
            }
            bottom--;
        }
        // 从下往上
        if(left <= right){ // 检查是否还有列需要处理
            for(int i = bottom; i >= top; i--){
                result[index++] = matrix[i][left];
            }
            left++;
        }
    }
    return result;
}
// #48 旋转矩阵
// 二维数组
// 矩阵
// 算法思想：顺时针旋转 90度 = 转置矩阵 + 每行反转
class Solution {
    public void rotate(int[][] matrix) {
        // 矩阵顺时针旋转 90度实现步骤：1.转置矩阵 2.每行反转
        int n = matrix.length;
        // 1.转置矩阵
        // 只需遍历上三角区域
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        // 2. 每行反转
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = t;
            }
        }
    }
}
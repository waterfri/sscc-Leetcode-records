// #73 矩阵置零
// 二维数组
// 矩阵
// 算法思想：原地修改时，用第一行第一列作为标志，标记需要置零的行和列，单独处理第一行第一列
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false; // 用于标记第一行是否需要清零
        boolean firstColZero = false;

        // 检查第一行和第一列是否需要清零
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                firstRowZero = true;
                break;
            }
        }
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                firstColZero = true;
                break;
            }
        }
        // 遍历矩阵修改标记
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // 根据标记将矩阵置为零
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        // 额外处理第一行第一列
        if(firstRowZero){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
        if(firstColZero){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
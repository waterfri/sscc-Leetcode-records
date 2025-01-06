// #289 生命游戏
// 二维数组
// 矩阵
// 方向数组
// 状态编码
// 算法思想：原地修改时，使用状态编码保存 旧状态->新状态 的信息，依据旧状态来确定存活邻居数量，从而确定新状态
// 两次遍历：第一次创建状态编码 第二次更新矩阵
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // 方向数组用于查找当前点的邻居坐标
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; // 行方向的变化量
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1}; // 列方向

        // 创建状态编码，用于保存旧状态
        // 0:死亡->死亡
        // 1:存活->存活
        // 2:存活->死亡
        // 3:死亡->存活
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int livingneighbour = 0;
                for(int k = 0; k < 8; k++){
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if(x >= 0 && x < m && y >= 0 && y < n){
                        if(board[x][y] == 1 || board[x][y] == 2){
                            livingneighbour++;
                        }
                    }
                }
                if((livingneighbour < 2 || livingneighbour > 3) && board[i][j] == 1){
                    board[i][j] = 2; // 2:活->死亡
                }
                if(livingneighbour == 3 && board[i][j] == 0){
                    board[i][j] = 3; // 3:死亡->存活
                }
                // 这里不需要修改生存状态不会发生变化的细胞了，因为状态没发生变化，最后不需要修改 0和 1的值
            }
        }
        // 根据状态编码原地修改
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }
}
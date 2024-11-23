// #42 接雨水
// 基本原理：在一个位置上存储的雨水量取决于这个位置左右两侧的最高柱子中的较低一方
// 算法思想核心：某个柱子能接到的水 = min(它左侧最高柱子高度，右侧最高柱子高度) 减去 该柱子高度

// 暴力解：O(n^2) （不推荐）
//
int trap(int* height, int heightSize) {
    // 某个柱子能接到的水 = min(它左侧最高柱子高度，右侧最高柱子高度) 减去 该柱子高度
    // 遍历每个柱子，计算水量
    int total = 0;
    for(int i=0; i<heightSize; i++){
        int leftmax = 0; // 左侧最高柱子高度
        int rightmax = 0; // 右侧最高柱子高度
        // 求 leftmax
        for(int j=0; j<i; j++){
            if(height[j]>leftmax){
                leftmax = height[j];
            }
        }
        // 求 rightmax
        for(int j=i+1; j<heightSize; j++){
            if(height[j]>rightmax){
                rightmax = height[j];
            }
        }
        // 水量大于 0时，计算到总和里
        int diff = (leftmax - rightmax) > 0 ? rightmax : leftmax;
        int water = diff - height[i]; 
        total += water > 0 ? water : 0;
    }
    return total;
}

// 最优解: 双指针 或 单调栈

// 最优解 1: 双指针
//水量的计算是基于局部最小值的原则，而不是等待所有柱子都被遍历完才开始计算，这使得双指针法高效且正确

int trap(int* height, int heightSize) {
    // 当前位置水量 = min(左侧最高柱子高度， 右侧最高柱子高度) 减去 当前柱子高度
    int total = 0;
    int left = 0; // 使用 left和 right作为下标来遍历每一个位置
    int right = heightSize-1;
    int leftmax = 0; // 当前柱子左侧最高柱子的高度
    int rightmax = 0;

    while(left <= right){
        if(height[left] < height[right]){ // 当前 left水量由 leftmax决定 短板效应
            if(height[left] < leftmax){
                total += leftmax - height[left]; // 可以存水
            }
            else{
                leftmax = height[left]; // 无法存水，更新最大高度
            }
            left++;
        }
        else{
            if(height[right] < rightmax){
                total += rightmax - height[right];
            }
            else{
                rightmax = height[right];
            }
            right--;
        }
    }
    return total;
}

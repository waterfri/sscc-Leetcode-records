// #45 跳跃游戏 II
// 贪心算法
// 每一步局部最优 = 全局最优
// 在当前可选择的每个位置都尝试更新最大可跳跃距离，直至找到最大可跳跃距离(当前能到的位置都尝试一遍后),执行跳跃实现局部最优，跳跃后更新 跳跃边界
int jump(int* nums, int numsSize) {
    int maxReach = 0;
    int count = 0;
    int end = 0; // 跳跃边界
    for(int i=0; i<numsSize-1; i++){
        maxReach = (maxReach > nums[i] + i) ? maxReach: nums[i] + i;
        if(i == end){
            count++;
            end = maxReach; // 执行跳跃使得本次跳跃为局部最优
        }
    }
    return count;
}
// #55 跳跃游戏
// 算法思想：维持 当前可达最远距离 变量
// 如 当前位置超过该变量，则逻辑错误，不断尝试前进，直至当前可达最远距离>=终点下标
#include <stdbool.h>

bool canJump(int* nums, int numsSize) {
    int MaxReach = 0; // 当前可到达的最大距离
    // i为当前位置
    for(int i=0;i<numsSize;i++){
        if(i>MaxReach){ // i超出能到达的范围
            return false;
        }
        // 更新最远可到达距离，能前进则前进
        MaxReach = (nums[i]+i)> MaxReach ? nums[i]+i : MaxReach; // 包含判 0
        if(MaxReach>=numsSize-1){
            return true;
        }
    }
    return false;
}
// #219 存在重复元素
//

// 使用哈希表需要自己实现，代码复杂，建议使用 Java



// 不使用哈希表
// 该算法最差时间复杂度 O(n^2) 超时了
#include <stdbool.h>

bool containsNearbyDuplicate(int* nums, int numsSize, int k){
    if(k <= 0){
        return false;
    }
    int *window = malloc(sizeof(int) * (k + 1));
    int windowsize = 0; // 当前窗口大小
    // 检查窗口中是否有重复元素
    for (int i = 0; i < numsSize; i++){
        for (int j = 0; j < windowsize; j++){
            if(window[j] == nums[i]){
                free(window);
                return true;
            }
        }
        // 添加到滑动窗口
        if(windowsize < k){
            window[windowsize++] = nums[i];
        }
        else{
            for (int i = 1; i < windowsize; i++){
                window[i - 1] = window[i];
            }
            window[windowsize - 1] = nums[i];
        }
    }
    free(window);
    return false;
}
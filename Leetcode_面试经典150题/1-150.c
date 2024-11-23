// #1 两数之和
// 数组动态分配
// 哈希表
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

#include <stdlib.h>

int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    int* result = (int*)malloc(sizeof(int)*2);
    *returnSize = 2;
    for(int i = 0; i < numsSize; i++){
        for(int j = i + 1; j < numsSize; j++){
            if(nums[i] + nums[j] == target){
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
    }
    free(result);
    return NULL;
}
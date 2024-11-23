// #167 两数之和 II-输入有序数组
// 双指针

#include <stdlib.h>
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* numbers, int numbersSize, int target, int* returnSize) {
    int* result = (int*)malloc(sizeof(int) * 2);

    *returnSize = 2;
    int i = 0;
    int j = numbersSize - 1;
    while(i<j){
        int sum = numbers[i] + numbers[j];
        if(sum == target){
            result[0] = i+1;
            result[1] = j+1;
            return result;
        }
        else if(sum < target){
            i++;
        }
        else{
            j--;
        }
    }
    free(result);
    return NULL;
}
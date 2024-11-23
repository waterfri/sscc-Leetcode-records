// #238 除自身以外数组的乘积
// 算法思想：两次相向遍历计算前缀乘积和后缀乘积，从而避免除法，是解决除自身以外元素乘积的好方法
// 巧妙：在计算某个结果之后，更新后缀乘积，再进行下次计算
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* productExceptSelf(int* nums, int numsSize, int* returnSize) {
    *returnSize = numsSize;
    int suffix = 1; // 后缀乘积初始化
    int* answer = (int*)malloc(sizeof(int) * numsSize);
    answer[0] = 1; //  前缀乘积初始化
    for(int i=1; i<numsSize; i++){
        answer[i] = answer[i-1] * nums[i-1]; // answer暂时存储前缀乘积
    }

    for(int i=numsSize-1; i>=0; i--){
        answer[i] = answer[i] * suffix; // 前缀乘积 与 后缀乘积 相乘
        suffix = suffix * nums[i]; // 每次得到结果后，更新后缀乘积，计算下个结果

    }
    return answer;
}
// #209 长度最小的子数组
// 滑动窗口：由双指针构成
// 算法思想：维护最小长度变量
// 注意判空条件
int minSubArrayLen(int target, int* nums, int numsSize) {
    // 滑动窗口：由双指针实现
    if(strlen(nums) == 0){
        return 0;
    }
    int minlen = numsSize + 1; // 维护变量：子数组最小长度
    int l = 0;
    int r = 0; 
    int sum = 0; // 子数组的总和
     
    for(; r < numsSize; r++){
        // 求和
        sum += nums[r];
        // 总和大于等于 target时，尝试更新 minlen，需要移动左指针
        while(sum >= target){
            // 判断最小长度是否更新
            int length = r - l + 1; // 当前子数组长度
            if(length < minlen){
                minlen = length;
            }
            sum -= nums[l];
            l++;
        }
    }
    // 判断是否存在这样的子数组
    return (minlen == numsSize + 1) ? 0: minlen;
}
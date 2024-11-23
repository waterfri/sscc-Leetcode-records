// #26 删除数组重复元素I
int removeDuplicates(int* nums, int numsSize){
    if(numsSize==0){
        return 0;
    }
    int k=1;
    for(int i=1;i<numsSize;i++){
        if(nums[i]!=nums[k-1]){
            nums[k]=nums[i];
            k++;
        }
    }
    return k;
}

/*int removeDuplicates(int* nums, int numsSize) {
    if (numsSize == 0) return 0; // 如果数组为空，返回0

    int k = 1; // 第一个元素总是保留，所以从1开始计数

    for (int i = 1; i < numsSize; i++) {
        if (nums[i] != nums[k - 1]) { // 如果当前元素和上一个保留的元素不同
            nums[k] = nums[i]; // 将当前元素移动到k位置
            k++; // 增加不重复元素的计数
        }
    }

    return k; // 返回不重复元素的个数
}
*/
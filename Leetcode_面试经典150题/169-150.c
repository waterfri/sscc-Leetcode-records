// #169 数组多数元素
/*
著名的 Boyer-Moore投票算法
算法思想：遍历数组的过程中更新两个变量candidate、count，在前进过程中更新count值
candidate用于储存候选元素
count作为计数器

此题目给出的数组非空且一定具有多数元素
*/
int majorityElement(int* nums, int numsSize) {
    int candidate=0;
    int count=0;
    for(int i=0;i<numsSize;i++){
        if(count==0){
            candidate=nums[i];
        }
        if(nums[i]==candidate){
            count++;
        }
        else{
            count--;
        }
    }
    return candidate;
}
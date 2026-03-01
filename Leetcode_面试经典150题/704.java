// #704 二分查找
// 数组
// O(logN)查找
// 二分查找

class Solution{
    public int search(int nums[], int target){
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){

            int mid = l + (r - l) / 2; // 防止整数 l+r 溢出变成负数
            int value = nums[mid];

            if(value == target){
                return mid;
            }
            else if(value < target){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }

        return -1;
    }
}

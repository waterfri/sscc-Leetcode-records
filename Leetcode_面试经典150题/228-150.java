// #228 汇总区间
// 数组
// 双指针
// 算法思想：两个指针分别记录区间开头和区间结尾

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int start = nums[i];
            // 找到连续区间的末尾
            while(i + 1 < n && nums[i+1] == nums[i] + 1){
                i++;
            }
            // 单个数字成区间时
            if(nums[i] == start){
                list.add(Integer.toString(start));
            }
            else{
                list.add(start + "->" + nums[i]); // 自动类型转换由 Java编译器隐式完成
            }
        }
        return list;
    }
}
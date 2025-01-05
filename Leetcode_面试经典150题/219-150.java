// #219 存在重复元素 II
// 哈希表
// 滑动窗口(C)
package Leetcode_repository.Leetcode_面试经典150题;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 使用哈希表建立键值对：值 -> 下表
        Map<Integer, Integer> map = new HashMap<>(); // Diamond Syntax
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
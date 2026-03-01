// #128 最长连续序列
// 哈希表
// HashSet
// 思路：用 HashSet 使查找变为 O(1), 遍历每个序列起点，更新最大长度

// 时间复杂度： O(n+n) = O(n)
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int x : nums){
            set.add(x);
        }

        int result = 0;

        for(int x : set){
            if(set.contains(x - 1)){ // 当前数不为序列起点
                continue;
            }

            int currentNum = x;
            int currentLength = 1;
            while(set.contains(currentNum + 1)){
                currentLength++;
                currentNum++;
            }

            result = Math.max(result, currentLength);
        }
        return result;
    }
}
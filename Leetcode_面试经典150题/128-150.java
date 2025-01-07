// #128 最长连续序列
// 哈希表
// 数组
// 序列起点
// 算法思想：使用哈希表去重，针对每个序列起点，遍历每个连续序列，维护最大长度变量
import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        // 使用哈希表存储不重复元素
        HashSet<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }

        int longestStreak = 0; // 最长序列长度

        // 在哈希表中寻找每一个序列起点，遍历序列维护最长序列长度变量
        for(int num : numSet){
            if(!numSet.contains(num - 1)){ // 只处理序列起点：num - 1 的值不存在时，该点为序列起点
                int currentStreak = 1;
                int currentNum = num; 
                // 为了遍历原数组所有元素，这里不能使用 num 自增，需要新建变量 currentNum 指向当前序列元素

                while(numSet.contains(currentNum + 1)){
                    currentStreak++;
                    currentNum++;
                }
                // 更新最长长度
                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }
        return longestStreak;
    }
}
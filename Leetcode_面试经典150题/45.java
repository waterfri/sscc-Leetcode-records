// #45 跳跃游戏 II
// 贪心
// O(n)

class Solution {
    public int jump(int[] nums) {
        int counts = 0; 

        int currentEnd = 0; // 当前可达边界
        int farthest = 0; // 当前区间内可达的最远处

        for(int i = 0; i < nums.length - 1; i++){
            farthest = Math.max(farthest, i + nums[i]);

            if(i == currentEnd){ // 必须跳了
                counts++;
                currentEnd = farthest; // 更新边界
            }
        }

        return counts;
    }
}

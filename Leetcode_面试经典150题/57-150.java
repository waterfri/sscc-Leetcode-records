// #57 插入区间
// 区间
// 二维数组
// 区间重叠判断
// 算法思想：创建新数组存储结果，遍历每个区间，判断 newInterval 与当前区间的位置关系，如果重叠则合并为一个区间，将所有区间加入结果数组

import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 使用新数组存储结果
        // 遍历每个区间，
        // 当前区间在 newInterval之前，直接将当前区间加入结果数组
        // 当前区间与 newInterval有重叠，则合并它们
        // 当前区间在 newInterval之后，先将 newInterval加入结果数组，再将剩余区间加入
        // 如果遍历结束后，newInterval还未加入，则将其加入
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();

        // 把所有在 newInterval之前的区间全部加入结果
        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        // 合并重叠区间
        while(i < n && intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);

        // 把所有在 newInterval之后的区间全部加入结果
        while(i < n){
            result.add(intervals[i]);
            i++;
        }

        // 转换为二维数组并返回
        return result.toArray(new int[result.size()][]);
    }
}
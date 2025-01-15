// #452 用最少数量的箭引爆气球
// 二维数组
// 区间
// 贪心
// 排序
// 算法思想：将区间按结尾坐标排序，覆盖当前区间的同时，尽可能覆盖后面更多的区间
import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        // 贪心算法
        // 将数组按结束坐标排序，在每个区间的结束处射箭，保证射中当前区间的同时，尽可能地覆盖后面更多的区间
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1])); // 按结束坐标排序

        // 初始化计数器和箭的初始位置
        int arrows = 1; // 至少需要一支箭
        int currentEnd = points[0][1];

        // 遍历
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > currentEnd){ // 需要额外射箭
                arrows++;
                currentEnd = points[i][1];
            }
        }    
        return arrows;
    }
}
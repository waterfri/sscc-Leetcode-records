// #739 每日温度
// 栈
// 单调栈
// monotonic stack
// 寻找右侧第一个更大元素
// 思路：
// 从左到右遍历温度数组，用栈保存还没找到更高温度的下标；当前温度如果更高，就不断弹出栈顶并计算等待天数，否则把当前下标入栈等待未来解决。
import java.util.Stack;

class Solution{
    public int[] dailyTemperatures(int[] temperatures){

        int n = temperatures.length;

        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];
        for(int i = 0; i < n; i++){

            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){ // 处理所有能解决的索引
                int diff = i - s.peek(); // 天数差
                result[s.pop()] = diff;

            }

            s.push(i); // 暂时没找到更高温度的天数，把索引入栈

        } // 遍历温度

        return result;
    }
}
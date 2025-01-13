// #71 简化路径
// 栈
// 路径问题
// 算法思想：使用栈存储结果，有效目录则压栈，上一级目录则弹栈，无效目录跳过
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String simplifyPath(String path) {
        // 分割路径
        String[] parts = path.split("/");
        // 使用栈模拟路径操作
        Deque<String> stack = new LinkedList<>();

        // 遍历每部分
        for(String part : parts){
            if(part.isEmpty() || part.equals(".")){
                continue; // 忽略空部分和目录
            }
            else if(part.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop(); // 返回上一级目录
                }
            }
            else{
                stack.push(part); // 有效目录入栈
            }
        }

        // 构建简化路径
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.insert(0, "/" + stack.pop());
        }

        // 如果结果为空，返回 "/"
        return result.length() == 0 ? "/" : result.toString();
    }
}
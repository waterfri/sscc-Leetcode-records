// #20 有效的括号
// 栈
// 括号匹配
// 算法思想：遍历整个字符串，左括号入栈，右括号检查栈顶元素是否匹配，遍历结束栈空则有效，否则无效
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            // 如果是左括号，入栈
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            // 如果是右括号，检查栈顶
            else{
                if(stack.isEmpty()){
                    return false;
                }
                // 栈顶元素
                char top = stack.pop();
                if((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')){
                    return false;
                }
            }
        }
        // 遍历结束应该栈空
        return stack.isEmpty();
    }
}
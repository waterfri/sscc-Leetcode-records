// #20 有效括号
// 栈
// 思路：左括号入栈，右括号匹配，遍历结束栈空则有效，否则无效

import java.util.Stack;

class Solution{
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            // 左括号
            if(c == '{' || c == '[' || c == '('){
                stack.push(c); // 入栈
                continue;
            }

            // 右括号
            else{
                if(stack.isEmpty()){ // 无可匹配的左括号
                    return false;
                }

                char top = stack.pop();
                if(top == '{' && c != '}') return false;
                if(top == '[' && c != ']') return false;
                if(top == '(' && c != ')') return false;
            }
        }

        return stack.isEmpty();
    }
}
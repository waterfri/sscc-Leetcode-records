// #150 逆波兰表达式求值
// 栈
// 后缀表达式
// 算法思想：后缀表达式可使用一个栈来储存运算数，遍历表达式，遇运算符则弹栈两次，计算结果后压栈，最终栈只保存最终值
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        // 后缀表达式可使用一个栈计算结果
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                if(token.equals("+")){
                    stack.push(num1 + num2);
                }
                else if(token.equals("-")){
                    stack.push(num1 - num2);
                }
                else if(token.equals("*")){
                    stack.push(num1 * num2);
                }
                else{
                    stack.push(num1 / num2);
                }
            }
            else{ // 数字转换成 int 类型压栈
                stack.push(Integer.parseInt(token));
            }
        }
        // 剩下一个数字为结果
        return stack.pop();
    }
}
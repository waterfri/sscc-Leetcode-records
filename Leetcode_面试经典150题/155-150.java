// #155 最小栈
// 栈
// 辅助栈
// 算法思想：主栈 (stack) 来存储正常的栈数据，使用 辅助栈 (minStack) 来存储栈中每一步的最小值
import java.util.Stack;

class MinStack {
    // 算法思想：创建两个栈
    private Stack<Integer> stack; // 主栈
    private Stack<Integer> minStack; // 辅助栈：栈顶元素为当前主栈最小元素

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){ // 如果辅助栈空，或当前元素小于最小元素
            minStack.push(val);
        }
    }
    
    public void pop() {
        int removed = stack.pop();
        if(removed == minStack.peek()){ // 最小元素弹栈，辅助栈同步弹栈
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
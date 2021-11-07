package LeetCode;

import java.util.Hashtable;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。
 * 执行push、pop和min操作的时间复杂度必须为O(1)。
 */
public class Problem03_02 {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        //System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());

    }
}
class MinStack {
    Stack<Integer> mainStack ;
    Stack<Integer> minStack ;
    /** initialize your data structure here. */
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (minStack.size() == 0 ||  minStack.peek()>=x){
            minStack.push(x);
        }
    }

    public void pop() {
        if (mainStack.size() == 0)
            return;
        int pop = mainStack.pop();
        if (minStack.peek()==pop)
            minStack.pop();

    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

package Offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数
 * 和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 输入：
 * ["Offer.CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 */
public class Nine {
    public static void main(String[] args) {

    }
}

class CQueue {
    Stack<Integer> stackFirst;
    Stack<Integer> stackSecond;
    int size;

    public CQueue() {
        stackFirst = new Stack<>();
        stackSecond = new Stack<>();
        size = 0;
    }

    public void appendTail(int value) {
        while (!stackFirst.isEmpty()) {
            stackSecond.push(stackFirst.pop());
        }
        stackFirst.push(value);
        while (!stackSecond.isEmpty()) {
            stackFirst.push(stackSecond.pop());
        }
        size++;
    }

    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        size--;
        return stackFirst.pop();
    }

}

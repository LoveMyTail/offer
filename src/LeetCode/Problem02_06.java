package LeetCode;

import com.sun.java.accessibility.util.AccessibilityListenerList;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 */
public class Problem02_06 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head = node;
        for (int i = 2; i < 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        for(int i =4;i>=1;i--){
            node.next = new ListNode(i);
            node = node.next;
        }
        System.out.println(new SolutionProblem02_06().isPalindrome(head));
    }
}

class SolutionProblem02_06 {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode midNode = findMidNode(head);//获取中间节点
        ListNode secondHalfHead = reverseLinked(midNode.next);
        //参数是中间节点的下一个节点，也就是右链表的第一个节点（翻转后的尾jiedianjiedian）
        ListNode curr1 = head;
        ListNode curr2 = secondHalfHead;//翻转后的右节点

        boolean palindrome = true;
        while(palindrome && curr2 != null){//两个链表的节点对比，右链表只有一半
            //所以结束以右链表为主
            if(curr1.val != curr2.val)
                palindrome = false;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return palindrome;
    }

    /* 反转链表 */
    private ListNode reverseLinked(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        //翻转链表------将第一个节点指向null，然后第一个节点的下一个节点指向第一个节点，以此类推
        return prev;
    }

    /* 快慢指针寻找中间节点 */
    private ListNode findMidNode(ListNode head){
        ListNode fast = head;
        ListNode low = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }

}

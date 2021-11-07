package Job.YuanFuDao.Test;

import LeetCode.ListNode;

public class TwoListSum {
    public static void main(String[] args) {

    }
}

class SolutionTwoListSum {
    public ListNode TwoListSum(ListNode rootA, ListNode rootB) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = rootA, q = rootB, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

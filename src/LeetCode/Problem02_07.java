package LeetCode;

/**
 * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，
 * 而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是
 * 同一节点（引用完全相同），则这两个链表相交。
 */
public class Problem02_07 {
    public static void main(String[] args) {

    }
}
class SolutionProblem02_07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lenA = 0, lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA!=null){
            lenA++;
            curA = curA.next;
        }
        while(curB!=null){
            lenB++;
            curB = curB.next;
        }
        if (lenA>lenB)
            return method(headA,headB,lenA,lenB);
        else
            return method(headB,headA,lenB,lenA);

    }
    // headA长度大于headB
    private ListNode method(ListNode headA, ListNode headB, int lenA, int lenB) {
        for(int i =0;i<lenA-lenB;i++){
            headA = headA.next;
        }
        while (headA!=null && headB!=null){
            if (headA == headB)
                return headA;
            else{
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

}

package Offer;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 */
public class FiftyTwo {
    public static void main(String[] args) {

    }
}
// 先让两个链表尾部对其，然后再同时向后移动
class SolutionFiftyTwo {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0,countB = 0;
        ListNode curA = headA,curB = headB;
        while (curA!=null){
            curA = curA.next;
            countA++;
        }
        while (curB!=null){
            curB = curB.next;
            countB++;
        }
        if (countA>countB){
            for (int i = 0;i<countA-countB;i++){
                headA = headA.next;
            }
        }else if (countA<countB){
            for (int i =0;i<countB - countA;i++){
                headB = headB.next;
            }
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}

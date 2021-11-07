package Offer;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *
 */
public class ThirtyFive {
    public static void main(String[] args) {

    }
}

/**
 * 三种方法
 * 第一种：可以将该链表根据next完整复制一次，然后再遍历一次原链表来复制random
 * 第二种：在根据next复制时将<原节点，新节点>存入哈希表，然后第二次遍历原链表是可以快速找到需要的节点
 * 第三种，可以在原链表的基础上复制一次，例如1→2→3→4复制为：1→1'→2→2'→3→3'→4→4'
 */
class SolutionThirtyFive {
    public Node copyRandomList(Node head) {
        if (head==null)
            return null;
        Node cur = head;
        while (cur!=null){
            Node copyNode = new Node(cur.val);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = cur.next.next;
        }
        cur = head;
        while (cur!=null){
            if (cur.random!=null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        Node copyHead = head.next;
        cur = head;
        Node curCopy = head.next;
        while (cur!=null) {
            cur.next = cur.next.next;
            cur = cur.next;
            if (curCopy.next!=null){
                curCopy.next = curCopy.next.next;
                curCopy = curCopy.next;
            }
        }
        return copyHead;
    }
}

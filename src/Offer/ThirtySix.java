package Offer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class ThirtySix {
    public static void main(String[] args) {

    }
}
class SolutionThirtySix {
    Node pre;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node p = root, q = root;
        while (p.left != null)
            p = p.left;
        while (q.right!=null)
            q = q.right;
        inorder(root);
        p.left = q;
        q.right = p;
        return p;
    }

    private void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        root.left = pre;
        if (pre!=null)
            pre.right  = root;
        pre = root;
        inorder(root.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}

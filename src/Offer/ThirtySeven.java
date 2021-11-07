package Offer;

import sun.plugin.javascript.navig.Link;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 */
public class ThirtySeven {
    public static void main(String[] args) {
        CodecThirtySeven c = new CodecThirtySeven();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(5);
        String serialize = c.serialize(node);
        System.out.println(serialize);

    }
}

/**
 * 该题测试的是序列化可反序列化是否可逆，因此“序列化列表的形式”并未限制，所以只需要两个函数可逆即可
 * 序列化以后会产生更多的null也不影响，只要可以反序列化为原树就可以了
 */
class CodecThirtySeven {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer s = new StringBuffer("[");
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                s.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                s.append("null,");
            }
        }
        s.deleteCharAt(s.length() - 1);
        s.append("]");
        return s.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.contains("[]"))
            return null;
        String[] cur = data.substring(1, data.length() - 1).split(",");
        TreeNode node = new TreeNode(Integer.parseInt(cur[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int i =1;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (!cur[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(cur[i]));
                queue.add(poll.left);
            }
            i++;
            if (!cur[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(cur[i]));
                queue.add(poll.right);
            }
            i++;
        }
        return node;
    }
}

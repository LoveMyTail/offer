package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件
 * 或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 示例: 
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * 序列化为 "[1,2,3,null,null,4,5]"
 */
public class Problem297 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(5);
        CodecProblem297 c = new CodecProblem297();
        String serialize = c.serialize(node);
        System.out.println(serialize);
        TreeNode deserialize = c.deserialize(serialize);
    }
}
/**
 * 该题测试的是序列化可反序列化是否可逆，因此“序列化列表的形式”并未限制，所以只需要两个函数可逆即可
 * 序列化以后会产生更多的null也不影响，只要可以反序列化为原树就可以了
 */
class CodecProblem297 {

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
        for (String s : cur) {
            System.out.print(s+" ");
        }
        TreeNode node = new TreeNode(Integer.parseInt(cur[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int i =1;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (!cur[i].equals("null")){
                poll.left = new TreeNode(Integer.parseInt(cur[i]));
                queue.add(poll.left);
            }
            i++;
            if (!cur[i].equals("null")){
                poll.right = new TreeNode(Integer.parseInt(cur[i]));
                queue.add(poll.right);
            }
            i++;
        }
        return node;
    }
}

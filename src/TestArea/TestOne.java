package TestArea;



import java.util.*;

public class TestOne {

    public static void main(String[] args) {

        ThreadLocal<String> local = new ThreadLocal<>();
        Object o = new Object();
        char[] a = "1234567".toCharArray();
        char[] b = "abcdefg".toCharArray();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                local.set("234");
                local.set("567");
                System.out.println(Thread.currentThread() + local.get());
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                local.set("123");
                System.out.println(Thread.currentThread() + local.get());
            }
        });
//        thread.start();
//        thread1.start();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    for (char c : a) {
                        System.out.print(c);
                        try {
                            o.notify();
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    o.notify();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    for (char c : b) {
                        System.out.print(c);
                        try {
                            o.notify();
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    o.notify();
                }
            }
        });

//        threadA.start();
//        threadB.start();

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next = new ListNode(5);
        System.out.println(new Solution56().deleteDuplication(head));

    }
}

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] preorder;
    int[] inorder;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length != in.length || pre.length == 0 || in.length == 0)
            return null;
        // hashmap用来存储中序遍历各个节点的位置与值的对应关系
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        this.inorder = inorder;
        this.preorder = preorder;
        return method(0, pre.length - 1, 0, in.length - 1);

    }

    public TreeNode method(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode treeNode = new TreeNode(preorder[preStart]);
        int num = preorder[preStart];
        treeNode.left = method(preStart + 1, preStart + 1 + map.get(num) - inStart, inStart, map.get(num) - 1);
        treeNode.right = method(preStart + (map.get(num) - inStart + 1), preEnd, map.get(num) + 1, inEnd);
        return treeNode;
    }
}

// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
// 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
class Solution13 {
    public void reOrderArray(int[] array) {
        int len = array.length;
        if (len <= 1)
            return;
        int i = 0;
        while (i < len) {
            int j = i + 1;
            if (array[i] % 2 == 0) {
                while (array[j] % 2 == 0) {
                    if (j == len - 1)
                        return;
                    j++;
                }
                int count = j - i;
                int temp = array[i];
                array[i] = array[j];
                while (count > 1) {
                    array[i + count] = array[i + count - 1];
                    count--;
                }
                array[i + 1] = temp;
            }
            i++;
        }
    }
}

// 找到链表的倒数第k个节点
class Solution14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode tail = head;
        int count = 0;
        while (tail != null) {
            count++;
            tail = tail.next;
        }
        if (count < k) return null;

        ListNode p = head;
        for (int i = 0; i < count - k; i++) {
            p = p.next;
        }
        return p;
    }
}

// 反转链表
class Solution15 {
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode start = new ListNode(-1);
        while (head.next != null) {
            ListNode cur = head.next;
            head.next = start.next;
            start.next = head;
            head = cur;
        }
        head.next = start.next;
        start.next = head;
        return start.next;
    }
}

// 合并两个单调递增的链表
class Solution16 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode node = new ListNode(-1);
        ListNode cur = node;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        cur.next = list1 == null ? list2 : list1;
        return node.next;
    }
}

// 树的子结构：输入两棵二叉树A，B，判断B是不是A的子结构（空树不是任意一棵树的子结构）
class Solution17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return method(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean method(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        return root1.val == root2.val && method(root1.left, root2.left) && method(root1.right, root2.right);
    }
}

// 操作给定的二叉树，将其变换为源二叉树的镜像
class Solution18 {
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode cur = root.left;
        root.left = root.right;
        root.right = cur;
        Mirror(root.left);
        Mirror(root.right);
    }
}

// 顺时针打印矩阵
class Solution19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length == 0)
            return list;
        // m为行号，n为列号
        int m = 0, n = 0, cur = 0;
        // x为行的长度，y为列的长度
        int y = matrix[0].length - 1, x = matrix.length - 1;
        int[] res = new int[(x + 1) * (y + 1)];
        while (true) {
            for (int i = n; i <= y; i++)
                list.add(matrix[m][i]);

            if (++m > x)
                break;
            for (int i = m; i <= x; i++)
                list.add(matrix[i][y]);
            if (--y < n)
                break;
            for (int i = y; i >= n; i--)
                list.add(matrix[x][i]);
            if (--x < m)
                break;
            for (int i = x; i >= m; i--)
                list.add(matrix[i][n]);
            if (++n > y)
                break;
        }
        return list;
    }
}

// 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
//注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
class Solution20 {
    Stack<Integer> stackA = new Stack<>();
    Stack<Integer> stackB = new Stack<>();

    public void push(int node) {
        stackA.add(node);
        if (stackB.isEmpty() || node <= stackB.peek())
            stackB.add(node);
    }

    public void pop() {
        if (stackA.pop() == stackB.peek())
            stackB.pop();
    }

    public int top() {
        return stackA.peek();
    }

    public int min() {
        return stackB.peek();
    }
}

// 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
// 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈
// 序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
class Solution21 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int sizeOne = pushA.length;
        int sizeTwo = popA.length;
        if (sizeOne != sizeTwo)
            return false;
        int j = 0;
        for (int i = 0; i < sizeOne; i++) {
            stack.push(pushA[i]);
            while (!stack.empty() && j < sizeTwo && popA[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}

// 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
class Solution22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            list.add(poll.val);
        }
        return list;
    }
}

// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
// 假设输入的数组的任意两个数字都互不相同。
class Solution23 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return method(sequence, 0, sequence.length - 1);
    }

    private boolean method(int[] postorder, int i, int j) {
        if (i >= j)
            return true;
        int p = i;
        while (postorder[p] < postorder[j])
            p++;
        int m = p;
        while (postorder[p] > postorder[j])
            p++;
        return p == j && method(postorder, i, m - 1) && method(postorder, m, j - 1);
    }
}

// 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
class Solution24 {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return list;
        ArrayList<Integer> cur = new ArrayList<>();
        method(cur, root, target);
        return list;
    }

    private void method(ArrayList<Integer> cur, TreeNode root, int target) {
        if (root == null)
            return;
        cur.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            list.add(new ArrayList<>(cur));
        } else {
            method(cur, root.left, target);
            method(cur, root.right, target);
        }
        cur.remove(cur.size() - 1);

    }
}


// 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random
// 指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参
// 数中的节点引用，否则判题程序会直接返回空）
class Solution25 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode copyNode = new RandomListNode(cur.label);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = cur.next.next;
        }
        cur = pHead;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        RandomListNode copyHead = pHead.next;
        cur = pHead;
        RandomListNode curCopy = pHead.next;
        while (cur != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            if (curCopy.next != null) {
                curCopy.next = curCopy.next.next;
                curCopy = curCopy.next;
            }
        }
        return copyHead;
    }
}

// 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
// 要求不能创建任何新的结点，只能调整树中结点指针的指向。
class Solution26 {
    TreeNode cur;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        TreeNode p = pRootOfTree;
        TreeNode q = pRootOfTree;
        while (p.left != null)
            p = p.left;
        while (q.right != null)
            q = q.right;
        method(pRootOfTree);
        p.left = q;
        q.right = p;
        return p;
    }

    private void method(TreeNode root) {
        if (root == null)
            return;
        method(root.left);
        root.left = cur;
        if (cur != null)
            cur.right = root;
        cur = root;
        method(root.right);
    }
}

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
class Solution27 {
    ArrayList<String> list = new ArrayList<>();
    char[] chars;

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return list;
        chars = str.toCharArray();
        Arrays.sort(chars);
        dfs(0);
        return list;
    }

    private void dfs(int x) {
        if (x == chars.length - 1) {
            list.add(String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i]))
                continue;
            set.add(chars[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    private void swap(int i, int x) {
        char temp = chars[i];
        chars[i] = chars[x];
        chars[x] = temp;
    }
}

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
class Solution28 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(array);
        int len = array.length / 2 + 1;
//        if (array.length%2==0)
//            len = array.length/2;
//        else
//            len = array.length/2+1;

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
            if (map.get(array[i]) >= len) {
                return array[i];
            }
        }
        return 0;
    }
}

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
class Solution29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length < k || k == 0)
            return null;
        Arrays.sort(input);
        for (int i = 0; i < input.length; i++) {
            if (list.contains(input[i]))
                continue;
            else
                list.add(input[i]);
            if (list.size() == k)
                break;
        }
        return list;

    }
}

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例
 * 如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
class Solution30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int ans = array[0];
        int sum = 0;
        for (int num : array) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
            System.out.println("当前最大值为：" + ans);
        }
        return ans;
    }
}

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字
 * 有1、10、11、12、13因此共出现6次, * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次 * 数（从1 到 n 中1出现的次数）。
 */
class Solution31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        return method(n);
    }

    private int method(int n) {
        if (n <= 0)
            return 0;
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length() - 1);
        int last = n - high * pow;
        if (high == 1) {
            return method(pow - 1) + last + method(last) + 1;
        } else {
            return pow + high * method(pow - 1) + method(last);
        }
    }
}


/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
class Solution32 {
    public String PrintMinNumber(int[] numbers) {
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            strs[i] = String.valueOf(numbers[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }
}

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 */
class Solution33 {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0)
            return 0;
        int a = 0, b = 0, c = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2)
                a++;
            if (dp[i] == n3)
                b++;
            if (dp[i] == n5)
                c++;
        }
        return dp[index - 1];
    }
}

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
class Solution34 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null)
            return -1;
        if (str.length() == 1)
            return 0;
        char[] chars = str.toCharArray();
        HashMap<Character, Boolean> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], true);
            } else {
                map.put(chars[i], false);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (!map.get(chars[i])) {
                min = Math.min(min, i);
            }
        }
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }
}

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 */
class Solution35 {
    // 此处需要采取归并排序的思想
    public int InversePairs(int[] array) {
        int len = array.length;
        if (len < 2)
            return 0;
        int[] copy = new int[len];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp) % 1000000007;
    }

    // nums[left...right]计算逆序个数并且排序
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right)
            return 0;
        int mid = (left + right) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    // nums[left...mid]有序 nums[mid+1...right]有序
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}

/**
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他
 * 方式显示的，保证传入数据是正确的）
 */
class Solution36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        int len2 = 0;
        ListNode cur1 = pHead1, cur2 = pHead2;
        while (cur1 != null) {
            cur1 = cur1.next;
            len1++;
        }
        while (cur2 != null) {
            cur2 = cur2.next;
            len2++;
        }
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                pHead1 = pHead1.next;
            }
        } else if (len1 < len2) {
            for (int i = 0; i < len2 - len1; i++) {
                pHead2 = pHead2.next;
            }
        }
        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;

    }
}


/**
 * 统计一个数字在排序数组中出现的次数。
 * 既然提出这种问题了，那么最好的方法肯定是二分
 */
class Solution37 {
    public int GetNumberOfK(int[] array, int k) {
        int left = 0, right = array.length - 1;
        int count = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] >= k)
                right = mid;
            else if (array[mid] < k)
                left = mid + 1;
        }
        while (left < array.length) {
            if (array[left] == k) {
                count++;
                left++;
            } else {
                break;
            }
        }
        return count;
    }
}


/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）
 * 形成树的一条路径，最长路径的长度为树的深度。
 */
class Solution38 {
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(TreeDepth(root.left) + 1, TreeDepth(root.right) + 1);
    }
}

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 */
class Solution39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        return IsBalanced_Solution(root.left)
                && IsBalanced_Solution(root.right)
                && (Math.abs(method(root.left) - method(root.right)) <= 1);
    }

    // 返回以当前节点为根的树的深度
    private int method(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(method(root.left) + 1, method(root.right) + 1);
    }
}

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
class Solution40 {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length < 2)
            return;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int flag = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                if (flag == 0) {
                    num1[0] = entry.getKey();
                    flag++;
                } else if (flag == 1)
                    num2[0] = entry.getKey();
            }
        }
    }
}

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
class Solution41 {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum == 1)
            return list;
        int left = 0, right = 0;
        int num = 0;
        while (right < sum) {
            if (num < sum) {
                right++;
                num += right;
            } else if (num > sum) {
                left++;
                num -= left;
            } else if (num == sum) {
                method(left + 1, right);
                right++;
                num += right;
            }
        }
        return list;
    }

    private void method(int left, int right) {
        ArrayList<Integer> cur = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            cur.add(i);
        }
        list.add(new ArrayList<>(cur));
    }
}

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，
 * 输出两个数的乘积最小的。
 */
class Solution42 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = array.length;
        int left = 0, right = len - 1;
        int min = Integer.MAX_VALUE;
        while (left < right) {
            if (array[left] + array[right] == sum) {
                if (array[left] * array[right] < min) {
                    min = array[left] * array[right];
                    list.clear();
                    list.add(array[left]);
                    list.add(array[right]);
                }
                right--;
            } else if (array[left] + array[right] > sum)
                right--;
            else if (array[left] + array[right] < sum)
                left++;
        }
        return list;
    }
}

/**
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
class Solution43 {
    public String LeftRotateString(String str, int n) {
        int len = str.length();
        if (n == 0 || len <= 1)//空串和单字符串左移无意义
            return str;
        int num = n % len;
        return str.substring(num, len) + str.substring(0, num);
    }
}

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
class Solution44 {
    public String ReverseSentence(String str) {
        if (str == null || str.trim().length() == 0)
            return str;
        char[] chars = str.toCharArray();
        reverseChars(chars, 0, str.length() - 1);
        // 利用滑动窗口
        // 遇到' '执行翻转
        int l = 0;
        int r = 0;
        while (l < str.length()) {
            if (chars[r] == ' ') {
                reverseChars(chars, l, r - 1);
                // 交换完之后,一起跳过' '
                r++;
                l = r;
            }
            if (r == str.length() - 1) {
                reverseChars(chars, l, r);
                // 到了最后交换玩就break，否则r会出现越界，可以在while中加对r的判断
                break;
            }
            r++;
        }
        return String.valueOf(chars);
    }

    private void reverseChars(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }
}


/**
 * 扑克牌顺子
 */
class Solution45 {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length < 5 || numbers == null)
            return false;
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : numbers) {
            if (num == 0)
                continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if (repeat.contains(num))
                return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 */
class Solution46 {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0)
            return -1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }
}

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
class Solution47 {
    public int Sum_Solution(int n) {
        return (int) (Math.pow(n, 2) + n) >> 1;
    }
}

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
class Solution48 {
    public int Add(int num1, int num2) {
        //a^b是不考虑进位的加法
        //a&b<<1是进位
        //一直递归，运算&最终会导致进位为0，递归结束
        return num2 == 0 ? num1 : Add(num1 ^ num2, (num1 & num2) << 1);
    }
}

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 */
class Solution49 {
    public int StrToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0)
            return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (chars[0] == '-')
            sign = -1;
        else if (chars[0] != '+')
            i = 0;
        for (int j = i; j < chars.length; j++) {
            if (chars[j] < '0' || chars[j] > '9')
                break;
            if (res > bndry || res == bndry && chars[j] > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (chars[j] - '0');
        }
        return sign * (int) res;
    }
}

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 */
class Solution50 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (set.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            } else {
                set.add(numbers[i]);
            }

        }
        return false;
    }
}


/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
class Solution55 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null)
            return null;
        HashSet<ListNode> set = new HashSet<>();
        while (pHead != null) {
            if (pHead == null)
                return null;
            if (set.contains(pHead)) {
                return pHead;
            } else {
                set.add(pHead);
                pHead = pHead.next;
            }
        }
        return null;
    }
}

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
class Solution56 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 自己构建辅助头结点
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                // 相同结点一直前进
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续前进
                cur = cur.next;
                // pre 连接新结点
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;

    }
}



/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
class Solution58 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return method(pRoot.left, pRoot.right);
    }

    private boolean method(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null && right != null)
            return false;
        if (left != null && right == null)
            return false;
        return left.val == right.val && method(left.left, right.right) && method(left.right, right.left);
    }
}

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
class Solution59 {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (pRoot == null)
            return list;
        else
            deque.add(pRoot);
        boolean flag = true;
        while (!deque.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                // 从左向右打印
                TreeNode node = deque.removeFirst();
                cur.add(node.val);
                // 先左后右加入下层节点
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            list.add((ArrayList<Integer>) cur);
            if (deque.isEmpty()) break; // 若为空则提前跳出
            // 打印偶数层
            cur = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                // 从右向左打印
                TreeNode node = deque.removeLast();
                cur.add(node.val);
                // 先右后左加入下层节点
                if (node.right != null) deque.addFirst(node.right);
                if (node.left != null) deque.addFirst(node.left);
            }
            list.add((ArrayList<Integer>) cur);
        }
        return list;
    }
}


/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
class Solution60 {
    ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null)
            return levels;
        method(pRoot,0);
        return levels;
    }

    private void method(TreeNode root, int level) {
        if (levels.size()==level){
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(root.val);
        if (root.left!=null){
            method(root.left,level+1);
        }
        if (root.right!=null){
            method(root.right,level+1);
        }
    }

}


/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，
 * 我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
class Solution67 {
    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        }
        else if (target == 3) {
            return 2;
        }
        int[] f = new int[target+1];
//        vector<int> f(target + 1, -1);
        for (int i = 1; i <= 4; ++i) {
            f[i] = i;
        }
        for (int i = 5; i <= target; ++i) {
            for (int j = 1; j < i; ++j) {
                f[i] = Math.max(f[i], j * f[i - j]);
            }
        }
        return f[target];
    }
}


/**
 * 求二叉树中的最长路径（叶子节点到叶子节点）
 */
class SolutionTheLongestPathInTree {
    // 最长路径要么存在于你的左子树内，要么存在于你的右子树内，要么就是以你作为根节点的子树内
    public int theLongestPathInTree(TreeNode root) {
        if (root == null)
            return 0;
        int left = longestPath(root.left);
        int right = longestPath(root.right);
        int now = left + right + root.val;
        return Math.max(now, Math.max(theLongestPathInTree(root.left), theLongestPathInTree(root.right)));
    }

    private int longestPath(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + Math.max(longestPath(root.left), longestPath(root.right));
    }
}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

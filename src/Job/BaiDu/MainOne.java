package Job.BaiDu;

import LeetCode.TreeNode;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainOne implements Runnable{
    // 两个线程交替打印数字
    public static void main(String[] args) {
        MainOne one = new MainOne();
        new Thread(one).start();
        new Thread(one).start();
    }

    int i = 1;
    @Override
    public void run() {
        while (true) {
            /*指代的为TestThread,因为使用的是implements方式。若使用继承Thread类的方式，慎用this*/
            synchronized (this) {
                /*唤醒另外一个线程，注意是this的方法，而不是Thread*/
                notify();
                try {
                    /*使其休眠100毫秒，放大线程差异*/
                    Thread.currentThread();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                    try {
                        /*放弃资源，等待*/
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

// 二叉树深度
class SolutionOne {
    public int methodOne(TreeNode root) {
        if (root == null)
            return 0;
        else
            return 1 + Math.max(methodOne(root.left), methodOne(root.right));
    }
}
// 判断回文字符串
class SolutionTwo {
    public boolean methodTwo(String str) {
        int len = str.length();
        for (int left = 0,right = len-1;left<=right;){
            if (str.charAt(left) == str.charAt(right)){
                left++;right--;
            }else{
                return false;
            }
        }
        return true;
    }
}

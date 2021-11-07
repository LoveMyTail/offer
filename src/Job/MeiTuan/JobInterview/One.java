package Job.MeiTuan.JobInterview;

import LeetCode.TreeNode;

public class One {
    public static void main(String[] args) {

    }
}

class Solution{
    public int depthOfThree(TreeNode root){
        if(root == null)
            return 0;
        else{
            return 1 + Math.max(depthOfThree(root.left),depthOfThree(root.right));
        }
    }
}

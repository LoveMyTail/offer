package LeetCode;

public class Problem1095 {

}

class SolutionProblem1095 {
    public int findInMountainArray(int target, MountainArray mountainArray) {
        int peek = findPeek(mountainArray);
        int ans = binSearch1(mountainArray, 0, peek, target);
        return ans >= 0 ? ans : binSearch2(mountainArray, peek, mountainArray.length(), target);
    }

    //左边升序区间查找
    int binSearch1(MountainArray A, int l, int rr, int t) {
        int r = rr;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (A.get(m) < t)
                l = m + 1;
            else
                r = m;
        }
        return l < rr && A.get(l) == t ? l : -1;
    }

    //右边降序区间查找
    int binSearch2(MountainArray A, int l, int rr, int t) {
        int r = rr;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (A.get(m) > t)
                l = m + 1;
            else
                r = m;
        }
        return l < rr && A.get(l) == t ? l : -1;
    }

    //查找峰
    int findPeek(MountainArray A) {
        int l = 0, r = A.length();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (m + 1 < A.length() && A.get(m) < A.get(m + 1))
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
}

class MountainArray {
    public int get(int index) {
        return 0;
    }

    public int length() {
        return 0;
    }
}

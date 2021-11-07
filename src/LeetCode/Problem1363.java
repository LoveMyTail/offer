package LeetCode;

/**
 * 给你一个整数数组 digits，你可以通过按任意顺序连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。
 * 由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。
 * 如果无法得到答案，请返回一个空字符串。
 * 示例 1：
 * 输入：digits = [8,1,9]
 * 输出："981"
 * 示例 2：
 * 输入：digits = [8,6,7,1,0]
 * 输出："8760"
 */
public class Problem1363 {
    public static void main(String[] args) {

    }
}

/**
 * 首先我们需要了解一个结论：
 * 一个数能被 3 整除，当且仅当它的各位数字之和能被 3 整除。例如数 981，它的各位数字之和为 9 + 8 + 1 = 18
 * 能被 3 整除，同时 981 也能被 3 整除。
 * 那么对于给定的数组 digits，记数组中所有元素之和为 S，那么就有以下的三种情况：
 *
 * 若 S 是 3 的倍数，那么选择数组 digits 中的所有元素，它们任意组成的数都能被 3 整除，
 * 因此我们只需要将其从大到小排序再连接成一个数即可；
 *
 * 若 S 模 3 余 1，那么我们需要从数组 digits 从删除若干个元素，它们的和模 3 也余 1。
 * 为了使得最后得到的数尽可能大，最优的方法一定是从 digits 中删除一个最小的模 3 余 1 的数（例如 1，4，7）。
 * 如果 digits 中没有这样的数，我们可以退而求其次，删除两个最小的模 3 余 2 的数（例如 2，5，8）。
 * 会不会也没有这样的数呢？如果 digits 中既没有模 3 余 1 的数，也最多只有一个模 3 余 2 的数，
 * 那么 digits 中所有元素之和要么是 3 的倍数（此时没有模 3 余 2 的数），
 * 要么模 3 余 2（此时有一个模 3 余 2 的数），不可能得到模 3 余 1 的结果。
 * 因此我们一定能通过删除一个模 3 余 1 的数或者两个模 3 余 2 的数，使得 digits 中所有元素之和
 * 变为 3 的倍数。在这之后，我们同样从大到小进行排序再连接成一个数；
 *
 * 若 S 模 3 余 2，与上面的情况类似，我们从 digits 中删除一个最小的模 3 余 2 的数，如
 * 果没有这样的数，就删除两个最小的模 3 余 1 的数。
 */
class SolutionProblem1363 {
    int sum = 0; //数组中所有数字的和
    int[] cnt = new int[10]; //对应0~9在数组中的出现次数
    int[] modulo = new int[3]; //统计数组中对应模3结果的元素个数

    public String solution(int[] digits) {
        for (int digit : digits) {
            sum += digit;
            cnt[digit]++;
            modulo[digit % 3]++;
        }
        if (sum % 3 == 1) {
            if (modulo[1] > 0) {
                delete(1, 1);
            } else {
                delete(2, 2);
            }
        } else if (sum % 3 == 2) {
            if (modulo[2] > 0) {
                delete(2, 1);
            } else {
                delete(1, 2);
            }
        }
        return solve();
    }

    /*
     * 根据数组和的分类情况进行删除数字
     * 目标：删除%3=mod最小的num个数
     * @parm: int mod, int num
     * @return: void
     */
    private void delete(int mod, int num) {
        for (int i = 0; i <= 9; i++) { //按照升序删除
            while (i % 3 == mod && cnt[i] > 0 && num > 0) { //删除
                cnt[i]--;
                num--;
            }
            if (num == 0) {
                return;
            }
        }
    }

    /*
     * 根据cnt数组将所有数字按照降序拼接成一个合法的数
     * @parm: void
     * @return: String ret
     */
    private String solve() {
        String ret = "";
        for (int i = 9; i >= 0; i--) { //按照降序拼接
            while (cnt[i] != 0) {
                ret += i;
                cnt[i]--;
            }
        }
        if (ret.length() == 0) {
            return "";
        } else if (ret.charAt(0) == '0') {
            return "0";
        } else {
            return ret;
        }
    }
}

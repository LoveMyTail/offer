package Offer;

/**
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 */
public class SixtySeven {
    public static void main(String[] args) {
        System.out.println(new SolutionSixtySeven().strToInt("42"));
    }
}

class SolutionSixtySeven {
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0)
            return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (c[0] == '-')
            sign = -1;
        else if (c[0] != '+')
            i = 0;
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9')
                break;
            if (res > bndry || res == bndry && c[j] > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * (int) res;

    }
}

package LeetCode;

/**
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或IPv6 地址。
 * IPv4地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为0 -255，用(".")分割。
 * 比如，172.16.254.1；
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址172.16.254.01 是不合法的。
 * IPv6地址由8组16进制的数字来表示，每组表示16 比特。这些组数字通过 (":")分割。
 * 比如,2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。
 * 而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。
 * 所以，2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址
 * (即，忽略 0 开头，忽略大小写)。
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。
 * 比如，2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如，02001:0db8:85a3:0000:0000:8a2e:0370:7334
 * 是无效的。
 * 说明:你可以认为给定的字符串里没有空格或者其他特殊字符。
 * 示例 1:
 * 输入: "172.16.254.1"
 * 输出: "IPv4"
 * 解释: 这是一个有效的 IPv4 地址, 所以返回 "IPv4"。
 * 示例 2:
 * 输入: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * 输出: "IPv6"
 * 解释: 这是一个有效的 IPv6 地址, 所以返回 "IPv6"。
 * 示例 3:
 * 输入: "256.256.256.256"
 * 输出: "Neither"
 * 解释: 这个地址既不是 IPv4 也不是 IPv6 地址。
 */
public class Problem468 {
    public static void main(String[] args) {

    }
}

class SolutionProblem468 {
    public String validateIPv4(String IP) {
        // 根据特殊字符进行分割需要加双反斜杠
        String[] nums = IP.split("\\.", -1);
        for (String x : nums) {
            // Validate integer in range (0, 255):
            // 1. length of chunk is between 1 and 3
            if (x.length() == 0 || x.length() > 3)
                return "Neither";
            // 2. no extra leading zeros
            if (x.charAt(0) == '0' && x.length() != 1)
                return "Neither";
            // 3. only digits are allowed
            for (char ch : x.toCharArray()) {
                if (!Character.isDigit(ch))
                    return "Neither";
            }
            // 4. less than 255
            if (Integer.parseInt(x) > 255)
                return "Neither";
        }
        return "IPv4";
    }

    public String validateIPv6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x : nums) {
            // Validate hexadecimal in range (0, 2**16):
            // 1. at least one and not more than 4 hexdigits in one chunk
            if (x.length() == 0 || x.length() > 4)
                return "Neither";
            // 2. only hexdigits are allowed: 0-9, a-f, A-F
            for (Character ch : x.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1)
                    return "Neither";
            }
        }
        return "IPv6";
    }

    public String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(IP);
        } else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(IP);
        } else
            return "Neither";
    }
}


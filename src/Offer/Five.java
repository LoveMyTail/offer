package Offer;

/**
 * 实现一个函数，把字符串中的每个空格替换成“%20”。
 * 例如：
 * 输入：“We are happy”
 * 输出：“We%20are%20happy”
 */
public class Five {
    public static void main(String[] args) {
        String str = "sd    sd";
        String s = method(str);
        System.out.println(s);
    }

    /**
     * 时间复杂度O(n),空间复杂度O(n)
     * @param str
     * @return
     */
    public static String method(String str){
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c != ' '){
                stringBuffer.append(c);
            }else{
                stringBuffer.append("%20");
            }
        }
        return stringBuffer.toString();
    }
}

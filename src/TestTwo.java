import JavaConcurrentProgramming.Basics.ThreadLocalTest;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class TestTwo implements Runnable{
    static int num = 0;

    static {

    }

    public void increase(){
        num++;
    }


    @Override
    public void run(){
        for (int j =0 ; j<10000;j++){
            synchronized (this){
                increase();
            }
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        TestTwo testTwo = new TestTwo();
//        Thread thread = new Thread(testTwo);
//        Thread thread2 = new Thread(testTwo);
//        thread.start();
//        thread2.start();
//        thread.join();
//        thread2.join();
//        System.out.println(num);


        String str = "-12355312231";
        System.out.println(new Solution().method(str));
    }

}

/**
 * 字符转数字
 */
class Solution{
    public int method(String str){
        str = str.trim();
        char[] chars = str.toCharArray();
        int flag = 1;
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]<'0' || chars[i]>'9'){
                if (i==0){
                    if (chars[i]=='-')
                        flag = -1;
                    else if (chars[i]=='+')
                        flag = 1;
                    else {
                        flag = 0;
                        break;
                    }
                }else{
                    flag = 0;
                    break;
                }
            }else{
                if (num>Integer.MAX_VALUE/10){
                    return 0;
                }else{
                    int cur = chars[i]-'0';
                    num = num*10+cur;
                }
            }
        }
        System.out.println(num+"*"+flag);
        return num*flag;
    }
}

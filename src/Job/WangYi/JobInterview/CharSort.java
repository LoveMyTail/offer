package Job.WangYi.JobInterview;

public class CharSort {
    public static void main(String[] args) {
        char[] array = new char[]{'a', 'A', 'c', 'B', 'd', 'C'};
        new SolutionCharSort().sortChar(array);
        for (char c : array) {
            System.out.print(c + " ");
        }
    }
}

class SolutionCharSort {
    public void sortChar(char[] array) {
        if (array == null) {
            return;
        }
        //用于保存52个字符出现的次数，小写字母保存在下标为偶数的位置，大写字母保存在奇数的位置
        int[] charCount = new int[52];
        for (int i = 0; i < array.length; i++) {
            //对小写字母出现的次数进行计数
            if (array[i] >= 'a' && array[i] <= 'z') {
                charCount[(array[i] - 'a') * 2]++;
                //对大写字母出现的次数进行计数
            } else if (array[i] >= 'A' && array[i] <= 'Z') {
                charCount[(array[i] - 'A') * 2 + 1]++;
            }
        }
        //根据各个字符出现的次数按顺序生成排序后的字符数组
        int index = 0;
        for (int i = 0; i < charCount.length; i++) {
            //这个字符在原始字符数组中存在
            if (charCount[i] != 0) {
                //小写字母
                if (i % 2 == 0) {
                    for (int j = 0; j < charCount[i]; j++) {
                        array[index++] = (char) (i / 2 + 'a');
                    }
                    //大写字母
                } else {
                    for (int j = 0; j < charCount[i]; j++) {
                        array[index++] = (char) ((i - 1) / 2 + 'A');
                    }
                }
            }
        }
    }
}

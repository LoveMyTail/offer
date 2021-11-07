package TestArea.HuffmanCompress;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        HuffmanCompress demo = new HuffmanCompress();
        File file = new File("D:\\Users\\孙杨帆\\Desktop\\测试文件集合\\测试文件五.txt");
        File outPutFile = new File("D:\\Users\\孙杨帆\\Desktop\\测试文件集合\\测试文件五（Huf）.txt");

        demo.compress(file,outPutFile);
    }
}

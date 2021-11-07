package TestArea.LZW;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class lzw {
    public static void main(String[] args) {
        FileInputStream input = null;
        FileOutputStream output = null;

        try {
            input = new FileInputStream("D:\\Users\\孙杨帆\\Desktop\\测试文件集合\\测试文件五.txt");
        } catch (FileNotFoundException fnfe) {
            System.out.println("Unable to open input file: " );
            System.exit(1);
        }

        try {
            output = new FileOutputStream("D:\\Users\\孙杨帆\\Desktop\\测试文件集合\\测试文件五（LZW）.txt");
        } catch (FileNotFoundException fnfe) {
            System.out.println("Unable to open output file compressed.lzw ");
            System.exit(1);
        }

        LZWCompression lzw = new LZWCompression(input, output);

        lzw.compress();        /* compress the file */

        try {
            input.close();
            output.close();
        } catch (IOException ioe) {
            System.out.println("IOException in main().");
            System.exit(1);
        }

        System.out.println("Done! Compressed file: compressed.lzw");
    }
}

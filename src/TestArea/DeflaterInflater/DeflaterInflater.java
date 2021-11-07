package TestArea.DeflaterInflater;

import java.io.*;
import java.util.Random;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class DeflaterInflater {

    public static String uncompress(byte[] input) throws IOException {
        Inflater inflater = new Inflater();
        inflater.setInput(input);
        ByteArrayOutputStream baos = new ByteArrayOutputStream(input.length);
        try {
            byte[] buff = new byte[1024];
            while (!inflater.finished()) {
                int count = inflater.inflate(buff);
                baos.write(buff, 0, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baos.close();
        }
        inflater.end();
        byte[] output = baos.toByteArray();
        return new String(output, "UTF-8");
    }

    public static byte[] compress(byte[] data) throws IOException {
        byte[] output;
        Deflater compress = new Deflater();

        compress.reset();
        compress.setInput(data);
        compress.finish();
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length);
        try {
            byte[] buf = new byte[1024];
            while (!compress.finished()) {
                int i = compress.deflate(buf);
                bos.write(buf, 0, i);
            }
            output = bos.toByteArray();
        } catch (Exception e) {
            output = data;
            e.printStackTrace();
        } finally {
            bos.close();
        }
        compress.end();
        return output;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Users\\孙杨帆\\Desktop\\测试文件集合\\测试文件四.txt");
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        reader = new BufferedReader(new FileReader(file));
        String tempStr;
        while ((tempStr = reader.readLine()) != null) {
            sbf.append(tempStr);
        }
        reader.close();
        String s1 = sbf.toString();

        byte[] compress = compress(s1.getBytes());
        System.out.println(compress.length + " : " + s1.getBytes().length);
        System.out.println("压缩率为："+Double.valueOf((compress.length/1024d)/(s1.length()/1024d)));

        String res = uncompress(compress);
        System.out.println("uncompress! \n" + s1 + "\n" + res);
    }
}

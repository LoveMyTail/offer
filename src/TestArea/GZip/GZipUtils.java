package TestArea.GZip;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZipUtils  {
    public static final String GZIP_ENCODE_UTF_8 = "UTF-8";
    public static final String GZIP_ENCODE_ISO_8859_1 = "ISO-8859-1";
    public static final String testJson = " {\"data\":{\"_id\":136675072,\"fileName\":\"测试文件三\",\"charts\":[{\"option\":{\"title\":{\"text\":\"测试标题\",\"subtext\":\"测试子标题\"},\"tooltip\":{\"trigger\":\"axis\"},\"legend\":{\"x\":\"center\",\"type\":\"scroll\",\"top\":\"8%\",\"data\":[\"本日入厂煤量\",\"本日库存煤量\",\"本日耗煤量\"]},\"toolbox\":{\"show\":true,\"orient\":\"vertical\",\"x\":\"right\",\"y\":\"center\",\"feature\":{\"mark\":{\"show\":true},\"dataView\":{\"show\":true,\"readOnly\":true},\"magicType\":{\"show\":true,\"type\":[\"line\",\"bar\",\"stack\",\"tiled\"]},\"restore\":{\"show\":true},\"saveAsImage\":{\"show\":true}}},\"calculable\":true,\"xAxis\":[{\"type\":\"category\",\"boundaryGap\":false,\"data\":[\"2019-1-1\",\"2019-1-2\",\"2019-1-3\",\"2019-1-4\",\"2019-1-5\",\"2019-1-6\",\"2019-1-7\",\"2019-1-8\",\"2019-1-9\",\"2019-1-10\",\"2019-1-11\",\"2019-1-12\",\"2019-1-13\",\"2019-1-14\",\"2019-1-15\",\"2019-1-16\",\"2019-1-17\",\"2019-1-18\",\"2019-1-19\",\"2019-1-20\",\"2019-1-21\",\"2019-1-22\",\"2019-1-23\",\"2019-1-24\",\"2019-1-25\",\"2019-1-26\",\"2019-1-27\",\"2019-1-28\",\"2019-1-29\",\"2019-1-30\",\"2019-1-31\"]}],\"yAxis\":[{\"type\":\"value\",\"name\":\"吨\"}],\"series\":[{\"name\":\"本日入厂煤量\",\"data\":[2420.3,10099.9,10022,7653.5,12425.46,10473.48,12232.96,8586.46,3755.06,2296.32,6682.92,11050.92,9894.08,7313.96,9538.96,6883.88,13634.09,13435.69,12240.12,13105.5,10496.25,12009.68,11046.56,13104.96,4252.42,0,9192.42,8567.64,10201.92,11547.3,14031.02],\"type\":\"line\",\"smooth\":true,\"itemStyle\":{\"normal\":{\"areaStyle\":{\"type\":\"default\"}}}},{\"name\":\"本日库存煤量\",\"data\":[125537.75,126286.65,127174.65,125701.15,129098.61,130688.09,133838.05,133887.51,128695.57,122153.89,120189.81,122527.73,124533.81,123221.77,124407.73,122956.61,128386.7,133587.39,137296.51,142681.01,145785.26,150541.94,154453.5,159450.46,155498.88,149725.88,153258.3,155970.94,160096.86,165475.16,173553.18],\"type\":\"line\",\"smooth\":true,\"itemStyle\":{\"normal\":{\"areaStyle\":{\"type\":\"default\"}}}},{\"name\":\"本日耗煤量\",\"data\":[8957,9351,9134,9127,9028,8884,9083,8537,8947,8838,8647,8713,7888,8626,8353,8335,8204,8235,8531,7721,7392,7253,7135,8108,8204,5773,5660,5855,6076,6169,5953],\"type\":\"line\",\"smooth\":true,\"itemStyle\":{\"normal\":{\"areaStyle\":{\"type\":\"default\"}}}}]},\"updateItem\":{\"update\":false,\"dateType\":\"null\",\"forSearch\":{\"tableCode\":\"V_HEAD_DRSJ\",\"xCoordinateRange\":[{\"startDate\":\"2019-01-01\",\"endDate\":\"2019-01-31\",\"xCoordinate\":\"YWRQ\"}],\"classification\":[{\"attributeCode\":\"FCMC\",\"data\":[\"国电青山热电有限公司\"]}],\"attributes\":[\"BRKCML\",\"BRRCML\",\"BRHML\"],\"dataType\":\"DEFAULT\"},\"radio\":\"DEFAULT\",\"lastUpdateDate\":\"2021-03-02T06:43:46.968Z\",\"chartCode\":\"A2\"}},{\"option\":{\"title\":{\"text\":\"近三年月平均\",\"subtext\":\"\"},\"tooltip\":{\"trigger\":\"axis\"},\"legend\":{\"x\":\"center\",\"type\":\"scroll\",\"top\":\"8%\",\"data\":[\"本日库存煤量\",\"当日入厂煤量\"]},\"toolbox\":{\"show\":true,\"orient\":\"vertical\",\"x\":\"right\",\"y\":\"center\",\"feature\":{\"mark\":{\"show\":true},\"dataView\":{\"show\":true,\"readOnly\":true},\"magicType\":{\"show\":true,\"type\":[\"line\",\"bar\",\"stack\",\"tiled\"]},\"restore\":{\"show\":true},\"saveAsImage\":{\"show\":true}}},\"calculable\":true,\"xAxis\":[{\"type\":\"category\",\"data\":[\"2018-3\",\"2018-4\",\"2018-5\",\"2018-6\",\"2018-7\",\"2018-8\",\"2018-9\",\"2018-10\",\"2018-11\",\"2018-12\",\"2019-1\",\"2019-2\",\"2019-3\",\"2019-4\",\"2019-5\",\"2019-6\",\"2019-7\",\"2019-8\",\"2019-9\",\"2019-10\",\"2019-11\",\"2019-12\",\"2020-1\"]}],\"yAxis\":[{\"type\":\"value\",\"name\":\"吨\"}],\"series\":[{\"name\":\"本日库存煤量\",\"data\":[\"88578.63\",\"102238.97\",\"111774.23\",\"175233.62\",\"126653.37\",\"159415.30\",\"129775.45\",\"107156.48\",\"141401.35\",\"148438.56\",\"138279.40\",\"174812.54\",\"101151.51\",\"125901.79\",\"138967.75\",\"173480.68\",\"178368.54\",\"177587.14\",\"188872.20\",\"178045.13\",\"169519.63\",\"133583.12\",110324.88],\"type\":\"bar\"},{\"name\":\"当日入厂煤量\",\"data\":[\"402830.50\",\"224472.40\",\"159382.98\",\"493104.27\",\"278441.86\",\"608580.36\",\"269144.95\",\"362540.64\",\"401574.42\",\"359411.77\",\"570244.05\",\"410483.88\",\"248531.07\",\"582630.17\",\"195836.27\",\"363014.20\",\"398525.24\",\"422728.18\",\"416772.28\",\"245953.42\",\"295480.11\",\"465597.51\",19487.52],\"type\":\"bar\"}]},\"updateItem\":{\"update\":true,\"dateType\":\"LAST_THREE_YEAR\",\"forSearch\":{\"tableCode\":\"V_HEAD_RJK_RCBD\",\"xCoordinateRange\":[{\"startDate\":\"2018-01-12\",\"endDate\":\"2021-01-11\",\"xCoordinate\":\"YWRQ\"}],\"classification\":[{\"attributeCode\":\"FCMC\",\"data\":[\"国电青山热电有限公司\"]}],\"attributes\":[\"BRRCML\",\"BRKCML\"],\"dataType\":\"AVERAGE_MONTH\"},\"radio\":\"AVERAGE_MONTH\",\"lastUpdateDate\":\"2021-03-16T01:41:00.141Z\",\"chartCode\":\"B1\"}}],\"__v\":0}} ";

    public static byte[] compress(String str, String encoding) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(str.getBytes(encoding));
            gzip.close();
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    public static byte[] compress(String str) throws IOException {
        return compress(str, GZIP_ENCODE_UTF_8);
    }

    public static byte[] uncompress(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    public static String uncompressToString(byte[] bytes, String encoding) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toString(encoding);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String uncompressToString(byte[] bytes) {
        return uncompressToString(bytes, GZIP_ENCODE_UTF_8);
    }

    public static void main(String[] args) throws IOException {
        String s = testJson;

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
        System.out.println(s1);


        System.out.println("原文件大小："+file.length());
        System.out.println("原文件大小："+s1.length());
        byte[] compress = compress(s1);
        System.out.println("压缩后："+Double.valueOf(compress.length/1024d));
        System.out.println("压缩率为："+Double.valueOf((compress.length/1024d)/(s1.length()/1024d)));

        System.out.println("解压后："+uncompress(compress(s1)).length);

        System.out.println("解压字符串后：："+uncompressToString(compress(s1)).length());

    }
}

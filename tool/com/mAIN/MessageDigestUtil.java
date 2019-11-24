import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public final class MessageDigestUtil {
    /**
     * 使用指定哈希算法计算摘要信息
     * @param content 内容
     * @param algorithm 哈希算法
     * @return 内容摘要
     */
    public static String getMD5Digest(String content,String algorithm){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(content.getBytes("utf-8"));
            return bytesToHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 将字节数组转换成16进制字符串
     * @param bytes 即将转换的数据
     * @return 16进制字符串
     */
    private static String bytesToHexString(byte[] bytes){
        StringBuffer sb = new StringBuffer(bytes.length);
        String temp = null;
        for (int i = 0;i< bytes.length;i++){
            temp = Integer.toHexString(0xFF & bytes[i]);
            if (temp.length() <2){
                sb.append(0);
            }
            sb.append(temp);
        }
        return sb.toString();
    }

    public  static void  main(String[] args){
      //  File file = new File("C:\\Users\\Administrator\\Desktop\\1.txt");
        File file = new File(args[0]);
        try {
            String content = FileUtils.readFileToString(file);
            String a=getMD5Digest(content,"SHA-256");
            System.out.println("summary: " + a);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

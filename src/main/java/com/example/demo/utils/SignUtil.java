package com.example.demo.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 接口参数签名，即将除“sign”以外的所有请求参数按key进行字典升序后，以“key1=value1&key2=value2…”的形式拼接起来，
 * 依次进行HMAC-SHA1和BASE64两步加密后得出的密文。
 *
 * Created by nob.
 */
public class SignUtil {
    protected static Logger logger = LoggerFactory.getLogger(SignUtil.class);

    private static char[] base64EncodeChars = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /**
     * 签名函数
     * @param params
     * @param appSecret
     * @return
     */
    public static String sign(Map<String, String> params, String appSecret) {
        try {

            StringBuilder sbParam = new StringBuilder();
            Map<String, String> sortMap = new TreeMap<String, String>();

            //使用sortmap排序
            for (Map.Entry<String, String> param : params.entrySet()) {
                if (!StringUtils.isBlank(param.getKey())) {
                    sortMap.put(param.getKey(), param.getValue());
                }
            }

            //拼接成k1=v1&k2=v2，如果value为空则不参与拼接
            for (Map.Entry<String, String> item : sortMap.entrySet()) {
                if (!StringUtils.isBlank(item.getKey())) {
                    /*if (0 < sbParam.length()) {
                        sbParam.append("&");
                    }*/
                    if (!StringUtils.isBlank(item.getValue())) {
                        if (sbParam.length() > 0) {
                            sbParam.append("&");
                        }
                        sbParam.append(item.getKey()).append("=").append(item.getValue());
                    }
                }
            }

            byte[] hmacSHA1Bytes = hmacSHA1Encrypt(sbParam.toString(), appSecret);
            String sign = toHexString(hmacSHA1Bytes);
            logger.info("sign signstr = {}, appSecret = {}, sign = "+ sign, sbParam.toString(), appSecret);
            return sign;
        } catch (Exception var5) {
            var5.printStackTrace();
            return "error";
        }
    }

    private static byte[] hmacSHA1Encrypt(String encryptText, String encryptKey) throws Exception {
        String MAC_NAME = "HmacSHA1";
        String ENCODING = "UTF-8";
        byte[] data = encryptKey.getBytes(ENCODING);
        SecretKey secretKey = new SecretKeySpec(data, MAC_NAME);
        Mac mac = Mac.getInstance(MAC_NAME);
        mac.init(secretKey);
        byte[] text = encryptText.getBytes(ENCODING);
        return mac.doFinal(text);
    }

    private static String encryptBASE64(byte[] key) throws Exception {
        return new String(base64Encode(key));
    }

    private static String base64Encode(byte[] data) {
        StringBuffer sb = new StringBuffer();
        int len = data.length;
        int i = 0;

        while(i < len) {
            int b1 = data[i++] & 255;
            if(i == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[(b1 & 3) << 4]);
                sb.append("==");
                break;
            }

            int b2 = data[i++] & 255;
            if(i == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[(b1 & 3) << 4 | (b2 & 240) >>> 4]);
                sb.append(base64EncodeChars[(b2 & 15) << 2]);
                sb.append("=");
                break;
            }

            int b3 = data[i++] & 255;
            sb.append(base64EncodeChars[b1 >>> 2]);
            sb.append(base64EncodeChars[(b1 & 3) << 4 | (b2 & 240) >>> 4]);
            sb.append(base64EncodeChars[(b2 & 15) << 2 | (b3 & 192) >>> 6]);
            sb.append(base64EncodeChars[b3 & 63]);
        }

        return sb.toString();
    }

    /**
     * byte数组转为16进制字符串
     * @param bytes
     * @return
     */
    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    public static void main(String[] args) {
        String appSecret =  "123456";
        Map<String, String> params = new HashMap<String, String>();
        params.put("key1", "value1");
        params.put("key2", "value2");

        System.out.println(SignUtil.sign(params, appSecret));
    }
}

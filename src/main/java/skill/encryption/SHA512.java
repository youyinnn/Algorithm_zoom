package skill.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/10/24
 */
public class SHA512 {

    public static final String KEY_SHA = "SHA-512";

    public static byte[] decryptBASE64(String key) {
        return Base64.getDecoder().decode(key);
    }

    public static String encryptBASE64(byte[] key) {
        return Base64.getEncoder().encodeToString(key);
    }

    public static String encryptSHA512(String text) {
        String encode = null;

        if (text != null && text.length() > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);

                messageDigest.update(text.getBytes());

                byte[] byteBuffer = messageDigest.digest();

                StringBuffer strHexString = new StringBuffer();

                for (int i = 0; i < byteBuffer.length; ++i) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                encode = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return encode;
    }


}

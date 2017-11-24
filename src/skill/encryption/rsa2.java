package skill.encryption;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/10/24
 */
public class rsa2 extends SHA512{

    private static final int N = 323;
    private static final int E = 5;
    private static final int D = 29;

    public static int[] RsaEncode(byte[] plainText){

        int[] cipherText = new int[plainText.length];

        int i = 0 ;
        for (byte b : plainText) {
            BigInteger pow = new BigInteger(b+"").pow(E);
            cipherText[i] = Integer.valueOf(pow.mod(new BigInteger(N+"")).toString());
            i++;
        }

        return cipherText;
    }

    public static int[] RsaDecode(int[] cipherText) {

        int[] plainText = new int[cipherText.length];

        int i = 0 ;
        for (int b : cipherText) {
            BigInteger pow = new BigInteger(b+"").pow(D);
            plainText[i] = Integer.valueOf(pow.mod(new BigInteger(N+"")).toString());
            i++;
        }

        return plainText;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String plainText = "CODE";
    }
}

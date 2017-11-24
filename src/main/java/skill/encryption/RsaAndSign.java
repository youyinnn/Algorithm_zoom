package skill.encryption;

import sun.security.rsa.RSAPublicKeyImpl;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * The type Rsa and sign.
 *
 * @description:
 * @author: youyinnn
 * @date: 2017 /10/25
 */
public class RsaAndSign extends SHA512{

    private static PublicKey publicKey;
    private static PrivateKey privateKey;

    private static final String KEY_ALGORITHM = "RSA";

    /**
     * 传入key size生成公钥密钥对
     *
     * @param keySize the key size
     */
    public static void genKey(int keySize) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);

            keyPairGenerator.initialize(keySize);

            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            RSAPublicKey pk = (RSAPublicKey) keyPair.getPublic();

            RSAPrivateKey pv = (RSAPrivateKey) keyPair.getPrivate();

            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(pv.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(pk.getEncoded());
            keyFactory=KeyFactory.getInstance("RSA");
            publicKey= keyFactory.generatePublic(x509EncodedKeySpec);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取密钥的字符串
     *
     * @return the private key
     */
    public static String getPrivateKey() {
        return encryptBASE64(privateKey.getEncoded());
    }

    /**
     * 获取公钥的字符串
     *
     * @return the public key
     */
    public static String getPublicKey() {
        return encryptBASE64(publicKey.getEncoded());
    }

    /**
     * 使用密钥加密
     *
     * @param plainText  the plain text
     * @param privateKey the private key
     * @return the string
     */
    public static String encryptWithPriKey(String plainText, PrivateKey privateKey) {

        try {
            Cipher cipher = Cipher.getInstance("RSA");

            cipher.init(Cipher.ENCRYPT_MODE,privateKey);

            byte[] encodeBytes = cipher.doFinal(plainText.getBytes("UTF-8"));

            return encryptBASE64(encodeBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 使用SHA512生成消息摘要
     *
     * @param plainText the plain text
     * @return the msg digest with sha 512
     */
    public static String getMsgDigestWithSHA512(String plainText) {
        return encryptSHA512(plainText);
    }

    /**
     * 使用公钥解密
     *
     * @param cipherText the cipher text
     * @param publicKey  the public key
     * @return the string
     */
    public static String decryptWithPubKey(String cipherText,PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");

            cipher.init(Cipher.DECRYPT_MODE,publicKey);

            byte[] bytes = cipher.doFinal(decryptBASE64(cipherText));

            return new String(bytes,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 签名认证
     *
     * @param plainTextA the plain text a
     * @param cipherText the cipher text
     * @param pk         the pk
     * @param msgDigestA the msg digest a
     */
    public static void signValidation(String plainTextA,String cipherText,String pk,String msgDigestA) {
        RSAPublicKey senderPk = generatePk(pk);

        // 接收方使用密文和发送方公钥进行解密 得出发送方生成的消息摘要A
        String msgDigestB = decryptWithPubKey(cipherText, senderPk);
        System.out.println("接收方使用密文解密出消息摘要：\n"+msgDigestB);

        System.out.print("对比消息摘要：");
        if (msgDigestA.equals(msgDigestB)) {
            System.out.println("比对一致，签名验证通过！");
        } else {
            System.out.println("比对不一致，签名验证不通过！");
        }
    }

    /**
     * 使用公钥字符串生成公钥对象
     *
     * @param pk the pk
     * @return the rsa public key
     */
    private static RSAPublicKey generatePk(String pk) {
        RSAPublicKey publicKey = null;
        try {
            publicKey = new RSAPublicKeyImpl(decryptBASE64(pk));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    public static void main(String[] args) {
        // 发送方操作 ：
        // 生成密匙对
        genKey(1105);
        String plainText = "Information Security";
        // 使用SHA512生成消息摘要
        String msgDigest = getMsgDigestWithSHA512(plainText);
        // 使用密钥加密摘要成密文
        String cipherText = encryptWithPriKey(msgDigest, privateKey);
        // 发送方的公钥
        String senderPk = getPublicKey();

        System.out.println("明文：\n"+plainText);
        System.out.println("消息摘要：\n"+msgDigest);
        System.out.println("摘要密文：\n"+cipherText);
        System.out.println("发送方公钥：\n"+ senderPk);

        System.out.println("===========================================================");
        // 接收方操作
        // 使用SHA512生成消息摘要
        String msgDigest2 = getMsgDigestWithSHA512(plainText);
        System.out.println("接收方：\n使用明文生成消息摘要：\n"+msgDigest);
        // 使用消息摘要和发送方公钥和明文进行签名验证
        signValidation(plainText,cipherText,senderPk,msgDigest2);
    }
}

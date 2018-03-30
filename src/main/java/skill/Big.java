package skill;

import java.math.BigInteger;

/**
 * @author youyinnn
 */
public class Big {

    public static void main(String[] args) {
        BigInteger i =
                new BigInteger("1000000000000000000000000000" +
                "000000000000000000000000000000000000000" +
                "000000000000000000000000000000000000000" +
                "000000000000000000000000000000000000000" +
                "000000000000000000000000000000000000000" +
                "000000000000000000000000000000000000000" +
                "00000000000000000000000000000000");
        BigInteger add = i.add(BigInteger.ONE);
        System.out.println(add);
    }

}

package skill.encryption;

import java.math.BigInteger;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/10/18
 */
public class Rsa {

    /**
     * RSA-768
     * p = 33478071698956898786044169848212690817704794983713768568912431388982883793878002287614711652531743087737814467999489
     * q = 36746043666799590428244633799627952632279158164343087642676032283815739666511279233373417143396810270092798736308917
     * n = 123018668453011775513049495838496272077285356959533479219732245215172640050726
           365751874520219978646938995647494277406384592519255732630345373154826850791702
           6122142913461670429214311602221240479274737794080665351419597459856902143413
     */
    private static final BigInteger P = new BigInteger("33478071698956898786044169848212690817704794983713768568912431388982883793878002287614711652531743087737814467999489");

    private static final BigInteger Q = new BigInteger("36746043666799590428244633799627952632279158164343087642676032283815739666511279233373417143396810270092798736308917");

    private static final BigInteger N = P.multiply(Q);

    /**
     * 768bit length
     * @return
     */
    private static int getKeyLength() {
        return N.bitLength();
    }

    /**
     * 123018668453011775513049495838496272077285356959533479219732245215172640050726365751874520219978646
       938995647494277399362180982680083708916492790042786446704216899485660545884075063880359778008999321
       6805951869422866239629243697835008
     * @return (p-1)*(q-1)
     */
    private static BigInteger getMagic() {
        return (P.subtract(BigInteger.ONE)).multiply(Q.subtract(BigInteger.ONE));
    }

    /**
     * 要求e1和(p-1)*(q-1)互质
     * getMagic().mod(new BigInteger("7")) = 6
     * 首先7是质数 然后(p-1)*(q-1)不是7的倍数 所以互质
     */
    private static BigInteger E1 = new BigInteger("7");

    /**
     * 17574095493287396501864213691213753153897908137076211317104606459310
       37715010376653598207431713980670557080678489677133745442609715481555
       94989700061123495291738427836657922691535805543371111441427602400850
       267060409462804177671119287
     *
     * getE2() 求得
     */
    private static BigInteger E2 = new BigInteger("175740954932873965018642136912137531538979081370762113171046064593103" +
            "7715010376653598207431713980670557080678489677133745442609715481555949897000611234952917384278366579226915358055" +
            "43371111441427602400850267060409462804177671119287");


    private static BigInteger getE2() {

        return getMagic().add(BigInteger.ONE).divide(E1);
    }

    private static boolean checkPrime(BigInteger number) {
        return number.isProbablePrime(1);
    }

    private static BigInteger bigPower(BigInteger e, BigInteger p){

        BigInteger result = BigInteger.ONE;

        if (p.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        if (p.equals(BigInteger.ONE)) {
            return e;
        }

        BigInteger two = new BigInteger("2");

        while (p.compareTo(BigInteger.ONE) > 0) {
            if (!p.mod(two).equals(BigInteger.ZERO)) {
                result = result.multiply(e);
            }
            e = e.multiply(e);
            p = p.divide(two);
        }

        return e.multiply(result);
    }

    public static void main(String[] args) {
        System.out.println(bigPower(new BigInteger("113"), E2));
    }

}


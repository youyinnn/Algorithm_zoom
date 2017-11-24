package skill.encryption;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/10/18
 */
public class PrimeNumber {

    public static boolean check(long number) {

        for (int i = 2 ; i < number ; ++i) {
            if (number % i == 0) {
                //System.out.println(i);
                return false;
            }
        }

        return true;
    }

    public static long getMaxPrimeNumber(long number) {
        for (long i = number ; i > 0 ; --i) {
            if (check(i)) {
                return i;
            }
        }
        return number;
    }

    public static void main(String[] args) {

        System.out.println(getMaxPrimeNumber(100));

    }

}

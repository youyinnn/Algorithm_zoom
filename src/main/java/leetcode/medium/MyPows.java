package leetcode.medium;

/**
 * @author youyinnn
 * Date 3/27/2019
 */
public class MyPows {

    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            double sub = 1 / x;
            return myPow(sub, Integer.MAX_VALUE) * sub;
        }
        if (n < 0) {
            return myPow(1 / x, -n);
        }
        if (n == 2) {
            return x * x;
        } else {
            if (n % 2 == 0) {
                int sub = n / 2;
                double subPow = myPow(x, sub);
                if (subPow == 0.0) {
                    return 0;
                } else {
                    return subPow * subPow;
                }
            } else {
                return myPow(x, n - 1) * x;
            }
        }
    }

}

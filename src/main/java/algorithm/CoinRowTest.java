package algorithm;

import java.util.Arrays;

/**
 * @author youyinnn
 * Date 9/5/2018
 */
public class CoinRowTest {

    public static void main(String[] args) {
        int[] coins = new int[]{5, 1, 2, 10, 6, 2};
        System.out.println(coinRowMemo(coins));
        System.out.println(coinRowDp(coins));
    }

    private static int coinRowMemo(int[] coins) {
        int[] maxCoin = new int[coins.length + 1];
        maxCoin[0] = 0;
        maxCoin[1] = coins[0];
        for (int i = 2; i < maxCoin.length; i++) {
            maxCoin[i] = Math.max(maxCoin[i - 1], maxCoin[i - 2] + coins[i - 1]);
        }
        System.out.println(Arrays.toString(maxCoin));
        return maxCoin[maxCoin.length - 1];
    }

    private static int coinRowDp(int[] coins) {
        int n = 2;
        int f2 = 0;
        int f1 = coins[0];
        int fn = 0;
        while (n < coins.length + 1) {
            fn = Math.max(f1, f2 + coins[n - 1]);
            f2 = f1;
            f1 = fn;
            n += 1;
        }
        return fn;
    }

}

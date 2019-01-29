package algorithm;

/**
 * 有硬币d1-dj，且d1 < d2 < d3 < ... < dj，其中d1=1
 * 需要找零n，求最少的硬币数
 *
 * @author youyinnn
 * Date 9/9/2018
 */
public class ChangeMakingTest {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 3 ,4};
        System.out.println(changeMaking(coins, 6));
        System.out.println(changeMaking(coins, 9));
    }

    private static int changeMaking(int[] coins, int n) {
        int[] fn = new int[n + 1];
        fn[0] = 0;
        fn[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int temp = n;
            int coinIndex = 0;
            while (coinIndex < coins.length && i >= coins[coinIndex]) {
                temp = Math.min(fn[i - coins[coinIndex]], temp);
                coinIndex++;
            }
            fn[i] = temp + 1;
        }
        return fn[n];
    }

}

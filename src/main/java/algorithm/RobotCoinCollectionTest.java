package algorithm;

/**
 * @author youyinnn
 * Date 9/10/2018
 */
public class RobotCoinCollectionTest {

    public static void main(String[] args) {
        int[][] coinMap = {{0,0,0,0,1,0},{0,1,0,1,0,0},{0,0,0,1,0,1},{0,0,1,0,0,1},{1,0,0,0,1,0}};
        System.out.println(collectionMemo(coinMap));
        System.out.println(collectionDp(coinMap));
    }

    private static int collectionMemo(int[][] coinMap) {
        int[][] fn = new int[coinMap.length][coinMap[0].length];
        fn[0][0] = coinMap[0][0];
        for (int i = 0; i < coinMap.length; i++) {
            for (int j = 0; j < coinMap[0].length; j++) {
                int n1 = 0;
                int m1 = 0;
                if (i != 0) {
                    n1 = fn[i - 1][j];
                }
                if (j != 0) {
                    m1 = fn[i][j - 1];
                }
                fn[i][j] = Math.max(n1, m1) + coinMap[i][j];
            }
        }
        return fn[coinMap.length - 1][coinMap[0].length - 1];
    }

    private static int collectionDp(int[][] coinMap) {
        int[] preFn = new int[coinMap[0].length];
        preFn[0] = coinMap[0][0];
        for (int i = 1; i < preFn.length; i++) {
            preFn[i] = preFn[i - 1] + coinMap[0][i];
        }
        int m1;
        int fn = 0;
        for (int i = 1; i < coinMap.length; i++) {
            m1 = preFn[0];
            for (int j = 1; j < coinMap[0].length; j++) {
                fn = Math.max(m1, preFn[j]) + coinMap[i][j];
                m1 = fn;
                preFn[j] = fn;
            }
        }
        return fn;
    }
}

package algorithm.dp;

import org.junit.Test;

/**
 * @author youyinnn
 * Date 3/10/2019
 */
public class PackageProblem {

    @Test
    public void test(){
        int[] w = new int[]{2,1,3,2};
        int[] v = new int[]{12,10,20,15};
        System.out.println(mostValuableLoading(w, v, 5));
    }

    public int mostValuableLoading(int[] iw, int[] iv, int w) {
        int[] tmp = new int[w + 1];
        int[] next = new int[w + 1];
        tmp[0] = 0;
        for (int i = 1; i < tmp.length; i++) {
            if (i >= iw[0]) {
                tmp[i] = iv[0];
            }
        }
        // F (i, j) = / max(F(i - 1, j), Vi + F(i - 1, j - Wi))    j - Wi >= 0
        //            \ F(i - i, j)                                j - Wi < 0
        // i represent as item number
        // j represent as weight
        for (int i = 1; i < iw.length; i++) {
            for (int j = 0; j < next.length; j++) {
                if (j - iw[i] < 0) {
                    next[j] = tmp[j];
                } else {
                    next[j] = Math.max(tmp[j], iv[i] + tmp[j - iw[i]]);
                }
            }
            System.arraycopy(next, 0, tmp, 0, w + 1);
        }
        return next[w];
    }

}

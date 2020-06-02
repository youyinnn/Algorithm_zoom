package offer;

import java.util.Arrays;

import org.junit.Test;

public class q66 {

    /**
     * 3ms beat 18.89%
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        int[] forward = new int[a.length];
        if (a.length == 0) 
            return b;
        forward[0] = a[0];
        for (int i = 1; i < a.length; i++){
            forward[i] = forward[i - 1] * a[i];
        }
        int[] backward = new int[a.length];
        backward[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            backward[i] = backward[i + 1] * a[i];
        }
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                b[i] = backward[i + 1];
            } else if (i == a.length - 1) {
                b[i] = forward[i - 1];
            } else {
                b[i] = forward[i - 1] * backward[i + 1];
            }

        }
        return b;
    }

    @Test
    public void test1() {
        int[] a = {1, 2, 3, 4, 5};
        System.err.println(Arrays.toString(constructArr(a)));
    }

}
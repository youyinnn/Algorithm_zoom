package skill;

import java.util.Arrays;

/**
 * @author youyinnn
 */
public class ArrayTest {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        double[] b = {1.1, 1.2};
        float[] c = new float[3];
        for (int i : a) {
            System.out.println(i);
        }
        int[] d = new int[3];

        System.arraycopy(a, 0, d, 0, a.length);

        System.out.println(Arrays.toString(d));

        System.out.println(Arrays.binarySearch(b, 1.0));

        int[] e = {4,66,234,32,4,1,23,3,0};
        Arrays.sort(e);
        System.out.println(Arrays.toString(e));
    }

}

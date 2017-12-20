package algorithm_class.ex_2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: youyinnn
 */
public class SortCompareTest {

    private static int[] arr = {15,1,86,13,32,45,0,-9,11};

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length -1) {
                break;
            } else {
                for (int j = 0 ; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j+1]) {
                        arr[j] += arr[j+1];
                        arr[j+1] = arr[j] - arr[j+1];
                        arr[j] -= arr[j+1];
                    }
                }
            }
        }
    }

    @Test
    public void testBubble(){
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}

package algorithm_class.ex_2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: youyinnn
 */
public class SortCompareTest {

    public static int[] arr ;

    public static int[] getRandomArr(int arrLength){
        arr = new int[arrLength];
        for (int i = 0 ; i < arrLength ; ++i) {
            arr[i] = (int) (Math.random()* 1000);
        }
        return arr;
    }

    public static int[] getUnRandomArr(int arrLength) {
        arr = new int[arrLength];
        for (int i = 0; i < arrLength ; ++i) {
            if (i < arrLength / 2) {
                arr[i] = 1;
            } else {
                arr[i] = 2;
            }
        }
        return arr;
    }

    public static long compareCount = 0;

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 冒泡排序
     * n个元素 i = 0开始
     * 相邻元素之间两两比较，按照大小顺序作为交换，每一轮比较都把最大的元素安排到当前轮次的最后面
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 0 ; j < arr.length - 1 - i; ++j) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
                compareCount++;
            }
        }
    }

    /**
     * 选择排序
     * n个元素 从i = 0 开始扫描
     * 每次扫描后n-i个元素 选出当前参与扫描的最小值，扫描结束后把最小值放置当前轮次的最前面
     * @param arr
     */
    public static void selectionSort(int[] arr){
        int min;
        for (int i = 0 ; i < arr.length - 1; ++i) {
            min = i;
            for (int j = i + 1 ; j < arr.length ; ++j) {
                if (arr[min] > arr[j]){
                    min = j;
                }
                compareCount++;
            }
            if (i == min) {
                break;
            } else {
                swap(arr, i, min);
            }
        }
    }

    /**
     * 直接插入排序
     * 将数组分为两部分，一部分是已经排序好的，另一部分是待插入的数组
     * 每次从待插入的数组中取出元素和有序数组从后往前进行比较，待插入一个一个往前挤，直到找到合适的位置
     * 直到待插入部分元素为0
     * @param arr
     */
    public static void straightInsertionSort(int[] arr){
        for (int i = 1 ; i < arr.length ; ++i) {
            int v = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > v) {
                arr[j+1] = arr[j];
                j = j - 1;
                arr[j + 1] = v;
                compareCount++;
            }
        }
    }

    /**
     * 归并排序
     * 对于需要排序的数组，把它一分为二，递归分
     * 分到不可再分为止就开始合并，并且是有序地合并
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int[] brr = new int[arr.length/2];
            int[] crr = new int[arr.length - arr.length/2];
            for (int i = 0 ; i < arr.length / 2 ; ++i) {
                brr[i] = arr[i];
            }
            for (int i = 0 ; i < arr.length - arr.length/2 ; ++i) {
                crr[i] = arr[arr.length/2 + i];
            }

            mergeSort(brr);
            mergeSort(crr);
            merge(brr, crr, arr);
        }
    }

    private static void merge(int[] brr, int[] crr, int[] arr){
        int p = brr.length;
        int q = crr.length;
        int i = 0, j = 0, k = 0;
        while (i < p && j < q) {
            if (brr[i] <= crr[j]) {
                arr[k] = brr[i];
                i++;
            } else {
                arr[k] = crr[j];
                j++;
            }
            k++;
            compareCount++;
        }
        int n = k;
        if (i == p) {
            for (int m = j ; m < q ; ++m) {
                arr[n] = crr[m];
                n++;
            }
        } else {
            for (int m = i ; m < p ; ++m) {
                arr[n] = brr[m];
                n++;
            }
        }
    }

    /**
     * 快速排序
     * 以arr[l]为左界，arr[r]为右界，选择当前界限内的第一个元素作为分裂点
     * 从两界向中间扫描为分裂点寻找一个合适的位置，使得分裂点左边的元素都小于等于分裂点
     * 右边的元素都大于等于分裂点，再递归以分裂点对左右两边的子数组进行划分排序
     * @param arr
     * @param l
     * @param r
     */
    public static void quickSort(int[] arr, int l, int r) {
        int s;
        if (l < r) {
            s = hoarePartition(arr, l, r);
            quickSort(arr, l, s - 1);
            quickSort(arr, s + 1, r);
        }
    }

    private static int hoarePartition(int[] arr, int l, int r) {
        int p = arr[l];
        int i = l;
        int j = r + 1;
        do {
            do {
                i++;
                compareCount++;
            } while (arr[i] < p && i < arr.length - 1);
            do {
                j--;
                compareCount++;
            } while (arr[j] > p);
            swap(arr, i, j);
        } while (i < j);
        swap(arr, i, j);
        swap(arr, l, j);

        return j;
    }

    /**
     * 堆排序
     * 分两步：
     *  （1）堆化
     * @param arr
     */
    public static void heapSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            myBuildHeap(arr, arr.length - i);
            swap(arr,0, arr.length - i - 1);
        }
    }

    private static void myBuildHeap(int[] arr, int heapLength) {
        int lastParentIndex = (heapLength - 2)/ 2;

        for (int i = lastParentIndex ; i >= 0 ; --i) {
            changeChild(arr, i, heapLength);
        }
    }

    private static void changeChild(int[] arr, int parentIndex, int heapLength){
        int leftChildIndex = parentIndex * 2 + 1;
        int rightChileIndex = leftChildIndex + 1;

        int bigChildIndex = leftChildIndex;
        if (rightChileIndex <= heapLength -1) {
            bigChildIndex = arr[rightChileIndex] > arr[leftChildIndex] ? rightChileIndex : leftChildIndex;
            compareCount++;
        }

        if (arr[bigChildIndex] > arr[parentIndex]) {
            int temp = arr[bigChildIndex];
            arr[bigChildIndex] = arr[parentIndex];
            arr[parentIndex] = temp;
            //if (bigChildIndex <= (heapLength - 2) / 2) {
            //    changeChild(arr, bigChildIndex, heapLength);
            //}
        }
        compareCount++;
    }

    @Test
    public void testBubble(){
        System.out.println(Arrays.toString(getRandomArr(1000)));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(compareCount);
    }

    @Test
    public void testSelectSort(){
        System.out.println(Arrays.toString(getRandomArr(1000)));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(compareCount);
    }

    @Test
    public void testStraightInsertionSort(){
        System.out.println(Arrays.toString(getRandomArr(1000)));
        straightInsertionSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(compareCount);
    }

    @Test
    public void testMergeSort(){
        System.out.println(Arrays.toString(getRandomArr(1000)));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(compareCount);
    }

    @Test
    public void testQuickSort(){
        System.out.println(Arrays.toString(getRandomArr(1000)));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(compareCount);
    }

    @Test
    public void testHeapSort(){
        System.out.println(Arrays.toString(getRandomArr(1000)));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(compareCount);
    }
}

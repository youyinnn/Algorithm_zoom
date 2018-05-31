package algorithm_class.ex_2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: youyinnn
 */
public class SortCompareTest {

    public static int[] arr ;

    public static int[] getRandomArr(int arrLength){
        Random random = new Random();
        arr = new int[arrLength];
        for (int i = 0 ; i < arrLength ; ++i) {
            arr[i] = (random.nextInt(9999));
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
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
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
        for (int i = 0 ; i < arr.length - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1 ; j < arr.length ; ++j) {
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
                compareCount++;
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
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
        for (int i = 1 ; i < arr.length ; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                compareCount++;
                j--;
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
            System.arraycopy(arr, 0, brr, 0, arr.length / 2);
            if (arr.length - arr.length / 2 >= 0) {
                System.arraycopy(arr, arr.length / 2, crr, 0, arr.length - arr.length / 2);
            }

            mergeSort(brr);
            mergeSort(crr);
            merge(brr, crr, arr);
        }
    }

    private static void merge(int[] brr, int[] crr, int[] arr){
        int bLength = brr.length;
        int cLength = crr.length;
        int aIndex = 0, cIndex = 0, bIndex = 0;
        while (bIndex < bLength && cIndex < cLength) {
            if (brr[bIndex] <= crr[cIndex]) {
                arr[aIndex++] = brr[bIndex++];
            } else {
                arr[aIndex++] = crr[cIndex++];
            }
            compareCount++;
        }
        while (cIndex < cLength) {
            arr[aIndex++] = crr[cIndex++];
        }
        while (bIndex < bLength) {
            arr[aIndex++] = brr[bIndex++];
        }
    }

    /**
     * 快速排序
     * 以arr[l]为左界，arr[r]为右界，选择当前界限内的第一个元素作为分裂点
     * 从两界向中间扫描为分裂点寻找一个合适的位置，使得分裂点左边的元素都小于等于分裂点
     * 右边的元素都大于等于分裂点，再递归以分裂点对左右两边的子数组进行划分排序
     * @param arr
     * @param left
     * @param right
     */
    public static void easyQuickSort(int[] arr, int left, int right) {
        if (left < right) {
            int s = hoarePartition(arr, left, right);
            easyQuickSort(arr, left, s - 1);
            easyQuickSort(arr, s + 1, right);
        }
    }

    private static int hoarePartition(int[] arr, int left, int right) {
        int p = arr[left];
        int i = left;
        int j = right + 1;
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
        swap(arr, left, j);
        return j;
    }

    /**
     * 堆排序
     * 分两步：
     *  （1）堆化
     *  （2）删除最大键
     * @param arr
     */
    public static void heapSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 堆化
            int heapLength = arr.length - i;
            int lastParentIndex = (heapLength - 2)/ 2;
            for (int j = lastParentIndex ; j >= 0 ; --j) {
                int leftChildIndex = j * 2 + 1;
                int rightChileIndex = leftChildIndex + 1;
                int bigChildIndex = leftChildIndex;

                if (rightChileIndex <= heapLength -1) {
                    bigChildIndex = arr[rightChileIndex] > arr[leftChildIndex] ? rightChileIndex : leftChildIndex;
                    compareCount++;
                }
                if (arr[bigChildIndex] > arr[j]) {
                    swap(arr, bigChildIndex, j);
                }
                compareCount++;
            }
            // 删除最大键
            swap(arr,0, arr.length - i - 1);
        }
    }

    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     * @param arr
     */
    public static void shellSort1(int []arr){
        //增量gap，并逐步缩小增量
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i = gap; i < arr.length; i++){
                int j = i;
                while(j - gap >= 0 && arr[j] < arr[j - gap]){
                    //插入排序采用交换法
                    swap(arr,j,j - gap);
                    compareCount++;
                    j -= gap;
                }
            }
        }
    }

    /**
     * 希尔排序 针对有序序列在插入时采用移动法。
     * @param arr
     */
    public static void shellSort2(int []arr){
        //增量gap，并逐步缩小增量
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i = gap;i < arr.length; i++){
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j - gap]){
                    while(j - gap >= 0 && temp < arr[j - gap]){
                        //移动法
                        arr[j] = arr[j - gap];
                        compareCount++;
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
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
        System.out.println(Arrays.toString(getRandomArr(10)));
        straightInsertionSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(compareCount);
    }

    @Test
    public void testMergeSort(){
        System.out.println(Arrays.toString(getRandomArr(999)));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(compareCount);
    }

    @Test
    public void testQuickSort(){
        System.out.println(Arrays.toString(getRandomArr(1000)));
        easyQuickSort(arr, 0, arr.length - 1);
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

    @Test
    public void testShellSort1(){
        System.out.println(Arrays.toString(getRandomArr(21)));
        shellSort1(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(compareCount);
    }

    @Test
    public void testShellSort2(){
        System.out.println(Arrays.toString(getRandomArr(10)));
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(compareCount);
    }

    public static void main(String[] args) {
        System.out.println("xixi");
    }
}

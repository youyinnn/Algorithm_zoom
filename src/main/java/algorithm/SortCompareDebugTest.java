package algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: youyinnn
 */
@SuppressWarnings("ALL")
public class SortCompareDebugTest {

    public static int[] arr ;

    public static int[] getRandomArr(int arrLength){
        Random random = new Random();
        arr = new int[arrLength];
        for (int i = 0 ; i < arrLength ; ++i) {
            arr[i] = (random.nextInt(99));
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
        System.out.println("-----------开始排序");
        for (int i = 0; i < arr.length - 1; ++i) {
            System.out.println("for循环A：此时 i = " + i + ", 当前数组为" + Arrays.toString(arr));
            for (int j = 0 ; j < arr.length - 1 - i; ++j) {
                System.out.println("\t\tfor循环B：此时 i = " + i + " j = " + j + ", 当前数组为" + Arrays.toString(arr));
                if (arr[j] > arr[j + 1]) {
                    System.out.println("\t\t\t\tarr[j] = " + arr[j] + " 大于 arr[j + 1] = " + arr[j + 1] + ", 需要冒泡 " + arr[j] + " 和 " + arr[j + 1]);
                    swap(arr, j, j + 1);
                    System.out.println("\t\t\t\t冒泡完, 当前数组为" + Arrays.toString(arr));
                } else {
                    System.out.println("\t\t\t\tarr[j] = " + arr[j] + " 不大于 arr[j + 1] = " + arr[j + 1] + ", 不需要冒泡, 当前数组为" + Arrays.toString(arr));
                }
            }
            System.out.println();
        }
        System.out.println("结束排序-----------");
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
        System.out.println("-----------开始排序");
        for (int i = 1 ; i < arr.length ; i++) {
            int j = i;
            String s = arr[j] < arr[j - 1] ? ", a[j] = " + arr[j] + "是小于" + "a[j - 1] = " + arr[j - 1] + "的, 进入while循环": " a[j] = " + arr[j] + "是大于" + "a[j - 1] = " + arr[j - 1] + "的, 跳过while循环";
            System.out.println("for循环：此时 i = " + i + " j = " + j + s);
            while (j >= 0 && arr[j] < arr[j - 1]) {
                System.out.println("\t\twhile循环：此时j = " + j +  ", 元素a[j] = " + arr[j] + "往前挤, 挤完j--, 当前数组为" + Arrays.toString(arr));
                swap(arr, j, j - 1);
                j--;
            }
            System.out.println("for循环i = " + i + "完毕, i++, 已排好前" + i + "个元素, 当前数组为" + Arrays.toString(arr));
            System.out.println();
        }
        System.out.println("结束排序-----------");
    }

    /**
     * 二分插入排序
     *
     * 直接插入排序是将带插入元素从后往前比较和移动
     * 目的是为了在以排序序列中找到自己该插入的位置
     * 二分插入排序就是在查找该插入位置的时候，使用二分法去查找
     * 而不是逆序查找，这样查找的次数就少了很多
     * @param arr
     */
    public static void binaryInsertionSort(int[] arr) {
        for (int i = 1 ; i < arr.length ; i++) {
            int key = arr[i];
            int low = 0,high = i - 1 , mid;
            while (low <= high) {
                mid = (low + high) >>> 1;
                if (key < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (high + 1 != i) {
                for (int j = i ; j > high + 1 ; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[high + 1] = key;
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
            int half = arr.length >>> 1;
            int[] brr = new int[half];
            int[] crr = new int[arr.length - (half)];
            System.arraycopy(arr, 0, brr, 0, half);
            System.arraycopy(arr, half, crr, 0, arr.length - (half));

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
        int var = arr[left];
        // 在一次快速排序中只要left的值比right小，我们就应该去移动，因为当前这次排序还没有完成
        while (left < right) {
            // 表示只有当前指针没有重合并且当前right指向的值大于val时，才会向左移动right
            while (left < right && arr[right] >= var) {
                right--;
            }
            // 将比val小的值赋到left
            arr[left] = arr[right];
            while (left < right && arr[left] <= var) {
                left++;
            }
            // 将比val小的值赋到right
            arr[right] = arr[left];
        }
        // 找到了所属的位置，并且将我们选定的值val赋到这个位置上去
        arr[left] = var;
        return right;
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
        System.out.println("源数组：" + Arrays.toString(getRandomArr(5)));
        bubbleSort(arr);
        System.out.println("结果：" + Arrays.toString(arr));
    }

    @Test
    public void testSelectSort(){
        System.out.println(Arrays.toString(getRandomArr(5)));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(compareCount);
    }

    @Test
    public void testStraightInsertionSort(){
        System.out.println("源数组：" + Arrays.toString(getRandomArr(5)));
        straightInsertionSort(arr);
        System.out.println("结果：" + Arrays.toString(arr));
    }

    @Test
    public void testBinaryInsertionSort(){
        System.out.println(Arrays.toString(getRandomArr(5)));
        binaryInsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testMergeSort(){
        System.out.println(Arrays.toString(getRandomArr(5)));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(compareCount);
    }

    @Test
    public void testEasyQuickSort(){
        System.out.println(Arrays.toString(getRandomArr(50)));
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
        System.out.println(Arrays.toString(getRandomArr(7)));
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
}

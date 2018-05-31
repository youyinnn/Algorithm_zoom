package skill.permutation;

import java.util.Arrays;

/**
 * @author youyinnn
 */
public class Permutation1 {

    /**
     * s表示，从array[start]后的数据进行全排列
     * @param array
     * @param start
     */
    public static void permute(int[] array,int start){
        // 输出
        if(start==array.length){
            System.out.println(Arrays.toString(array));
        }
        else {
            for(int i=start;i<array.length;++i){
                //  交换元素
                swap(array,start,i);
                //交换后，再进行全排列算法
                permute(array,start+1);
                //还原成原来的数组，便于下一次的全排列
                swap(array,start,i);
            }
        }
    }

    private static void swap(int[] array,int s,int i){
        int t=array[s];
        array[s]=array[i];
        array[i]=t;
    }
    public static void main(String[] args){
        int[] array=new int[]{1,2,3};
        permute(array,0);
    }
}

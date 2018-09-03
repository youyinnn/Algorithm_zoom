package lanqiaobei.Programming.q12;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/4/1
 */
public class Main {

    /**
     * 实现思路：
     *          我们真正需要做的就是在123456789这9个数字之间的8个空位填充符号，
     *          填充的可能性有：+，-，或者不填
     *          三种，所以所有的结果共有3^8次方中可能，
     *          我们把每一种可能填充好之后，再计算字符串表达的和，等于
     *          110就输出这个可能。
     * @param args
     */
    public static void main(String[] args) {
        String[] field = new String[8];
        String[] op = {"+","","-"};

        getResult(0,op,field);
    }

    //计算字符串表示的和
    public static int sum(String s){
        //123+4+5+67-89
        String[] ss = s.split("");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(ss));
        int len = arrayList.size();
        StringBuffer sb = new StringBuffer();
        int sum  = 0 ;
        for (int i = 0 ; i < len; ++i) {
            if (arrayList.get(i).equals("+") || arrayList.get(i).equals("-")) {
                sum = sum + Integer.parseInt(sb.toString());
                sb.delete(0,sb.length());
            }
            sb.append(arrayList.get(i));
            if (i == len-1){
                sum = sum + Integer.parseInt(sb.toString());
            }
        }
        return sum;
    }

    //将得到的加减符号的填充数组填入1-9个数字里面 返回一个填充好的字符串
    public static String inject(String[] field){
        StringBuilder s = new StringBuilder("1*2*3*4*5*6*7*8*9");
        int i = 0;
        while (true){
            int index = s.indexOf("*");
            s.replace(index,index+1,field[i]);
            i++;
            if (i == 8) break;
        }
        return s.toString();
    }

    //递归求出8个填充符填加号减号或者不填的所有情况 使用sum方法和inject方法求和 符合要求则打印出符合要求的组合
    public static void getResult(int index,String[] op,String[] field){
        if (index == field.length){
            String result = inject(field);
            if ( sum(result) == 110) {
                System.out.println(result);
            }
            return ;
        }

        for (int i = 0 ; i < op.length ; ++i){
            field[index] = op[i];
            getResult(index+1,op,field);
            field[index] = op[0];
        }
    }
}

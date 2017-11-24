package _20170328.done.Programming.q13;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/4/1
 */
public class Main {

    /**
     * 实现思路：
     *          我们得到一个有循环的小数之后，先把小数部分截取出来，然后就判断是否有重复的串
     *          在判断的同时判断当前选定的串中最后两位是否是同一个数，如果是同一个数就代表着
     *          这个数就是循环节，因为如果两个数相同且相邻，就代表这个已经进入循环节的部分
     *          如果没有相同且相邻的数就继续判断是否有重复的串，一旦出现重复的串就说明已经找
     *          到了循环节，题解。
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s1 = input.next();

        String[] s2 = s1.split(",");

        BigDecimal f = new BigDecimal(s2[0]);
        BigDecimal n = new BigDecimal(s2[1]);

        String result = f.divide(n,50,BigDecimal.ROUND_UP).toEngineeringString();

        String[] results = result.split("\\.");

        String s3 = results[1];

        String base = null;
        int p;
        for (int i = 1 ; i < s3.length()/2 ; ++i){
            base = s3.substring(0,i);
            p = i;
            String v = s3.substring(p, 2*p);
            if (s3.charAt(p) == s3.charAt(p-1)) {
                base = s3.charAt(p)+"";
                break;
            }
            if (v.equals(base)) {
                break;
            }
        }

        System.out.println(base);

        if(base != null){
            StringBuffer stringBuffer = new StringBuffer(result.substring(0,result.indexOf(base)));
            stringBuffer.append("[").append(base).append("]");
            System.out.println(stringBuffer);
        }

    }
}

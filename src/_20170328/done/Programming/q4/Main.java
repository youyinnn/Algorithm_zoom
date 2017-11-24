package _20170328.done.Programming.q4;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/28
 */

public class Main {
    public static void main(String[] args) {
        HashMap<Character,Integer> R_number = new HashMap<>();
        R_number.put('I',1);
        R_number.put('V',5);
        R_number.put('X',10);
        R_number.put('L',50);
        R_number.put('C',100);
        R_number.put('D',500);
        R_number.put('M',1000);

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        StringBuffer[] s = new StringBuffer[n];
        int[] num = new int[n];

        for(int i = 0;i<n;++i){
            int sum;
            s[i] = new StringBuffer(input.next());
            char p_char = s[i].charAt(s[i].length()-1); //获取输入的罗马数字的最后一个字母
            sum = R_number.get(p_char); //以被吃掉的字母为sum的基数
            s[i].deleteCharAt(s[i].length()-1); //删除获取的字母
            //当所有的字母被吃掉之后就退出循环
            while (s[i].length() != 0){
                //获取当前串的末尾字母
                char last_char = s[i].charAt(s[i].length()-1);
                //如果刚刚吃掉的字母last_char比之前吃掉的p_char小
                // 就用sum减去last_char对应的数 否则加上对应的数
                if (R_number.get(last_char) < R_number.get(p_char)){
                    sum -= R_number.get(last_char);
                }else {
                    sum += R_number.get(last_char);
                }
                //p_char等于last_char 并删除last_char
                p_char = last_char;
                s[i].deleteCharAt(s[i].length()-1);
            }
            num[i] = sum;
        }

        for (int i : num) {
            System.out.println(i);
        }
    }
}

package _20170328.done.Programming.q8;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/30
 */
public class Main {

    private static HashMap<String,String> map = new HashMap<>();
    static {
        map.put("1","A");
        map.put("2","B");
        map.put("3","C");
        map.put("4","D");
        map.put("5","E");
        map.put("6","F");
        map.put("7","G");
        map.put("8","H");
        map.put("9","I");
        map.put("10","J");
        map.put("11","K");
        map.put("12","L");
        map.put("13","M");
        map.put("14","N");
        map.put("15","O");
        map.put("16","P");
        map.put("17","Q");
        map.put("18","R");
        map.put("19","S");
        map.put("20","T");
        map.put("21","U");
        map.put("22","V");
        map.put("23","W");
        map.put("24","X");
        map.put("25","Y");
        map.put("26","Z");
    }

    /**
     * 实现思路：
     *          列数对26求商就是第一个字母 对26求余就是第二个字母 如 255/26就是9
     *          9对应的字母就是I，255%26就是21,21对应的字母就是U
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        String[] in = new String[n];
        String[] result = new String[n];

        for (int i = 0 ; i < n ;++i){
            in[i] = input.next();
        }

        for (int i = 0 ; i < n ; ++i) {
            String[] ss = in[i].split("C");
            String row = ss[0].substring(1,ss[0].length());
            String s_column = ss[1];

            if (map.get(s_column) != null){
                result[i] = map.get(s_column) + row;
            }else {
                int num_column = Integer.parseInt(s_column);
                String pre = map.get(String.valueOf(num_column/26));
                String next = map.get(String.valueOf(num_column%26));

                result[i] = pre + next + row;
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
}

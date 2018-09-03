package lanqiaobei.Programming.q7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/30
 */
public class Main {

    private static HashMap<String,String> numbers = new HashMap<String,String>();

    static {
        numbers.put("1","壹");
        numbers.put("2","贰");
        numbers.put("3","叁");
        numbers.put("4","肆");
        numbers.put("5","伍");
        numbers.put("6","陆");
        numbers.put("7","柒");
        numbers.put("8","捌");
        numbers.put("9","玖");
    }

    /**
     * 实现思路：
     *          按照中文大写的习惯，每个数都可以分割为若干个千位数的组合，如：[148759063]可以分割为
     *          [1，4875，9063]其中第一个逗号就是亿，第二个就是万，所以我如果要转换任意一个数为大写
     *          我只要分割成千位数的组合，然后用递归求出千位数的大写就行了。
     * @param s_nums
     * @return
     */
    public static String A(ArrayList s_nums){

        String s_character = "";
        int size = s_nums.size();

        if (size == 1){
            s_character = numbers.get(s_nums.get(0).toString());
            return s_character;
        }


        if (size == 2){
            if (s_nums.get(0).toString().equals("0")){
                if (s_nums.get(1).toString().equals("0")){
                    return "";
                }else {
                    s_character = "零"+numbers.get(s_nums.get(1).toString());
                    return s_character;
                }
            }
            s_character = numbers.get(s_nums.get(0).toString()) +"拾";
            if (!s_nums.get(1).toString().equals("0")){
                s_character += numbers.get(s_nums.get(1).toString());
            }
            return s_character;
        }

        if (size == 3){
            if (s_nums.get(0).toString().equals("0")){
                if (!s_nums.get(1).toString().equals("0")){
                    s_nums.remove(0);
                    s_character += A(s_nums);
                    return "零"+s_character;
                }
                s_nums.remove(0);
                s_character += A(s_nums);
                return s_character;
            }
            s_character = numbers.get(s_nums.get(0).toString()) +"佰";
            s_nums.remove(0);
            s_character += A(s_nums);
            return s_character;
        }

        if (size == 4){
            if (s_nums.get(0).toString().equals("0")){
                if (!s_nums.get(1).toString().equals("0")){
                    s_nums.remove(0);
                    s_character += A(s_nums);
                    return "零"+s_character;
                }
                s_nums.remove(0);
                s_character += A(s_nums);
                return s_character;
            }
            s_character = numbers.get(s_nums.get(0).toString()) + "仟";
            s_nums.remove(0);
            s_character += A(s_nums);
            return s_character;
        }

        //如果数字大于万，那就需要分割，分为千万和千
        if (size > 4 && size <9){
            //在万位上加逗号
            s_nums.add(size-4,",");
            StringBuilder s = new StringBuilder();
            for (Object s_num : s_nums) {
                s.append(s_num);
            }

            //根据逗号分割
            String[] ss = s.toString().split(",");
            String ws = ss[0];
            String[] wss = ws.split("");
            String qs = ss[1];
            String[] qss = qs.split("");

            //求出千万档
            ArrayList<String> wsl = new ArrayList<String>(Arrays.asList(wss));
            //求出千档
            ArrayList<String> qsl = new ArrayList<String>(Arrays.asList(qss));

            String c;

            c = "万";

            if (ws.equals("0000")){
                c = "";
            }

            if (wsl.get(wsl.size()-1).equals("0") && !qsl.get(0).equals("0")){
                c = "万零";
            }

            s_character =  A(wsl) + c + A(qsl);
            return s_character;
        }

        //如果上亿 那就再分割 然后递归
        if (size == 9){
            String e = numbers.get(s_nums.get(0).toString());
            s_nums.remove(0);
            s_character = e + "亿" +A(s_nums);
        }

        return s_character;
    }

    public static void main(String[] args) {
        String[] ss = String.valueOf(940500681).split("");
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(ss));
        System.out.println(A(arrayList));
    }
}

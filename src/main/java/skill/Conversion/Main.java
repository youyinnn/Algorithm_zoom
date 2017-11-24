package skill.Conversion;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/4/7
 */
public class Main {

    public static void main(String[] args) {
        int a = 6;

        //a是10进制数 把a转换为3进制数的String类型
        String b = Integer.toString(a,3);

        System.out.println(b);

        //把String类型的b当作3进制数转换为10进制数
        int c = Integer.parseInt(b,3);

        System.out.println(c);
    }
}

package _20170328.done.Field.q15;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/4/2
 */
public class Main {

    public static void main(String[] args) {
        int n = 8765;
        int m = 0;
        while(n>0)
        {
            m = m*10+n%10;
            n = n / 10;
        }
        System.out.println(m);
    }
}

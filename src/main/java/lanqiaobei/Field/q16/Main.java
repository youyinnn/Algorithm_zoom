package lanqiaobei.Field.q16;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/4/2
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(getDistance(100, 1500, 0.8));
    }

    public static double getDistance(int begin, int end, double d)
    {
        return (end-begin) * Math.PI * d/1000;
    }
}

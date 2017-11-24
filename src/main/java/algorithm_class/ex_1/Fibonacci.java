package algorithm_class.ex_1;

/**
 * The type Fibonacci.
 *
 * @description:
 * @author: youyinnn
 * @date: 2017 /11/15
 */
public class Fibonacci {

    /**
     * 递归法(recursion) 指数时间
     *
     * @param n the n
     * @return the long
     */
    public static int recursion2FibonacciForInt(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return recursion2FibonacciForInt(n-1) + recursion2FibonacciForInt(n-2);
    }

    /**
     * 递归法(recursion) 指数时间
     *
     * @param n the n
     * @return the long
     */
    public static long recursion2FibonacciForLong(int n) {
        if (n == 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        return recursion2FibonacciForLong(n-1) + recursion2FibonacciForLong(n-2);
    }

    /**
     * 迭代法(iteration)
     *
     * @param n the n
     * @return long int
     */
    public static int iteration2FibonacciForInt(int n){

        int fibonacci = 0;
        int fa = 1;
        int fb = fibonacci;

        if (n == 1) {
            return fa;
        } else if (n == 0) {
            return fb;
        }


        for (int i = 2; i <= n ; ++i) {
            fibonacci = fa + fb;
            fb = fa;
            fa = fibonacci;
        }

        return fibonacci;
    }

    /**
     * 迭代法(iteration)
     *
     * @param n the n
     * @return long long
     */
    public static long iteration2FibonacciForLong(long n){

        long fibonacci = 0L;
        long fa = 1L;
        long fb = fibonacci;

        if (n == 1) {
            return fa;
        } else if (n == 0) {
            return fb;
        }


        for (long i = 2; i <= n ; ++i) {
            fibonacci = fa + fb;
            fb = fa;
            fa = fibonacci;
        }

        return fibonacci;
    }

    /**
     * Limit fibonacci for int int.
     *
     * the limit fibonacci for int is 46
     * @return the int
     */
    public static int limitFibonacciForInt(){
        int i = 1;
        while (true) {
            long fibonacci = iteration2FibonacciForInt(i);
            if (fibonacci < 0) {
                return i -1;
            }
            i++;
        }
    }

    /**
     * Limit fibonacci for long int.
     *
     * the limit fibonacci for int is 92
     * @return the int
     */
    public static int limitFibonacciForLong(){
        int i = 1;
        while (true) {
            long fibonacci = iteration2FibonacciForLong(i);
            if (fibonacci < 0) {
                return i -1;
            }
            i++;
        }
    }

    /**
     * Time fibonacci for int long.
     *
     * 9k ms 左右
     * @return the long
     */
    public static long timeFibonacciForInt(){

        long before = System.nanoTime();

        recursion2FibonacciForInt(46);

        long after = System.nanoTime();
        return after - before;
    }

    /**
     * Time fibonacci for int long.
     *
     * 8822
     * @return the long
     */
    public static long timeFibonacciForLong(int n){

        long before = System.nanoTime();

        recursion2FibonacciForLong(n);

        long after = System.nanoTime();
        return after - before;
    }

    public static long maxFibonacciLimitWithTime(int m){
        long fibonacci = 0L;
        long fa = 1L;
        long fb = fibonacci;

        while (true) {
            fibonacci = fa + fb;
            fb = fa;
            fa = fibonacci;
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //System.out.println(limitFibonacciForInt());
        //System.out.println(limitFibonacciForLong());

        //System.out.println(timeFibonacciForInt());

        int i = 0;
        while (true) {
            System.out.println("计算第"+i+"个斐波那契需要："+timeFibonacciForLong(i) * 0.000000001+" s");
            i++;
        }
    }

}

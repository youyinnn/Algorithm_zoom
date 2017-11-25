package algorithm_class.ex_1;

import org.junit.Test;

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
     * int级迭代法(iteration)
     *
     * @param n the n
     * @return long int
     */
    public static int iteration2FibonacciForInt(long n){

        int fibonacci = 0;
        int fa = 1;
        int fb = fibonacci;

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
     * long级迭代法(iteration)
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
     * int级最大斐波那契数
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
     * long级最大斐波那契数
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
     * 递归法计算最大Int需要多长时间
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
     * 递归法计算long级以内的第n个斐波那契数需要多长时间
     *
     * 8822
     * @return the long
     */
    public static long FibonacciTimeForLongWithRecursion(int n){

        long before = System.nanoTime();

        recursion2FibonacciForLong(n);

        long after = System.nanoTime();
        return after - before;
    }

    /**
     * 递归法计算long级以内的第n个斐波那契数需要多长时间
     *
     * 8822
     * @return the long
     */
    public static long FibonacciTimeForLongWithIteration(long n){

        long before = System.nanoTime();

        iteration2FibonacciForInt(n);

        long after = System.nanoTime();
        return after - before;
    }


    @Test
    public void q2(){

        System.out.println(limitFibonacciForInt());

        System.out.println(limitFibonacciForLong());
    }

    @Test
    public void q3(){

        System.out.println(timeFibonacciForInt() * 0.000000001 );

    }

    @Test
    public void q4_1(){

        // 递归法

        // 1s
        //System.out.println(FibonacciTimeForLongWithRecursion(41) * 0.000000001);

        // 5s
        //System.out.println(FibonacciTimeForLongWithRecursion(44) * 0.000000001);

        // 10s
        //System.out.println(FibonacciTimeForLongWithRecursion(46) * 0.000000001);

        // 50s
        System.out.println(FibonacciTimeForLongWithRecursion(49) * 0.000000001);

    }

    @Test
    public void q4_2(){

        // 迭代法

        //1s
        //System.out.println(FibonacciTimeForLongWithIteration(360000000L) * 0.000000001);

        //5s
        //System.out.println(FibonacciTimeForLongWithIteration(4000000000L) * 0.000000001);


        //10s
        //System.out.println(FibonacciTimeForLongWithIteration(3977777777L) * 0.000000001);

        //50s
        System.out.println(FibonacciTimeForLongWithIteration(17700000000L) * 0.000000001);
    }

    public double getFibonacciByFormula(int n) {

        double sqrtFive = Math.sqrt(5.0);

        double a = 1 / sqrtFive;

        double b = Math.pow(((1.0 + sqrtFive) / 2.0), n);

        double c = Math.pow(((1.0 - sqrtFive) / 2.0), n);

        return a * (b - c);
    }

}

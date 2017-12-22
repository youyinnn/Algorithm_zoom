package servlet;

import algorithm_class.ex_1.Fibonacci;
import algorithm_class.ex_2.SortCompareTest;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: youyinnn
 */
@WebServlet("/exam")
public class ExamServlet extends HttpServlet {

    private Class thisClass = this.getClass();

    private static ExamServlet instance;

    private ExamServlet instance(){
        if (instance == null) {
            instance = new ExamServlet();
        }
        return instance;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String route = req.getParameter("route");
        String n = req.getParameter("n");

        Method routeMethod;
        String s = null;
        try {
            if (n == null) {
                routeMethod = thisClass.getMethod(route);
                routeMethod.invoke(instance());
            } else {
                routeMethod = thisClass.getMethod(route, long.class);
                routeMethod.invoke(instance(), Long.parseLong(n));
            }
            s = JSON.toJSONString(MsgChannel.readMsg());
            MsgChannel.clearMsgChannel();
        } catch (Exception ignore) {
            ignore.printStackTrace();
            System.out.println("Not such method");
        }

        resp.getWriter().print(s);
    }

    public void f1(){
        int fibonacciForInt = Fibonacci.limitFibonacciForInt();

        MsgChannel.addMsgLine("Java中Int类型支持的最大斐波那契数是：" + fibonacciForInt);
    }

    public void f2(){
        int fibonacciForLong = Fibonacci.limitFibonacciForLong();

        MsgChannel.addMsgLine("Java中Long类型支持的最大斐波那契数是：" + fibonacciForLong);
    }
    public void f3(){
        double timeFibonacciForInt = Fibonacci.timeFibonacciForInt() * 0.000000001;

        MsgChannel.addMsgLine("递归计算最大int斐波那契数需要时间：" + timeFibonacciForInt  );
    }
    public void f4(){
        double timeFibonacciForLong = Fibonacci.timeFibonacciForLong() * 0.000000001;

        MsgChannel.addMsgLine("递归计算最大long斐波那契数需要时间：" + timeFibonacciForLong);
    }
    public void f5(long n){
        double time = Fibonacci.FibonacciTimeForLongWithRecursion((int) n) * 0.000000001;

        MsgChannel.addMsgLine("递归计算第" + n + "个斐波那契数所需时间：" + time);
        System.out.println(MsgChannel.readMsgInRaw());
    }
    public void f6(long n){
        double time = Fibonacci.FibonacciTimeForLongWithIteration(n) * 0.000000001;

        MsgChannel.addMsgLine("迭代计算第" + n + "个斐波那契数所需时间：" + time);
        System.out.println(MsgChannel.readMsgInRaw());
    }
    public void f7(long n){
        double a = Fibonacci.getFibonacciByFormula((int) n);

        MsgChannel.addMsgLine("公式法计算第" + n + "个斐波那契数值为：" + a);
    }

    public void randomArr(long n){
        int[] initedArr = SortCompareTest.getInitedArr((int) n);

        MsgChannel.addMsgLine("随机生成的数组为："+ Arrays.toString(initedArr));
    }

    public void bubble(){
        MsgChannel.addMsgLine(" ");
        MsgChannel.addMsgLine("[冒泡排序算法]：");
        MsgChannel.addMsgLine("原数组为："+ Arrays.toString(SortCompareTest.arr));

        int[] brr = Arrays.copyOf(SortCompareTest.arr, SortCompareTest.arr.length);

        SortCompareTest.bubbleSort(brr);

        MsgChannel.addMsgLine("排序后数组为：" + Arrays.toString(brr));
        MsgChannel.addMsgLine("比较次数为：" + SortCompareTest.count);
        MsgChannel.addMsgLine("----------------------------------------------------");
        SortCompareTest.count = 0;
    }

    public void select(){
        MsgChannel.addMsgLine(" ");
        MsgChannel.addMsgLine("[选择排序算法]：");
        MsgChannel.addMsgLine("原数组为："+ Arrays.toString(SortCompareTest.arr));

        int[] brr = Arrays.copyOf(SortCompareTest.arr, SortCompareTest.arr.length);

        SortCompareTest.selectSort(brr);

        MsgChannel.addMsgLine("排序后数组为：" + Arrays.toString(brr));
        MsgChannel.addMsgLine("比较次数为：" + SortCompareTest.count);
        MsgChannel.addMsgLine("----------------------------------------------------");
        SortCompareTest.count = 0;
    }
    public void insert(){
        MsgChannel.addMsgLine(" ");
        MsgChannel.addMsgLine("[直接插入排序算法]：");
        MsgChannel.addMsgLine("原数组为："+ Arrays.toString(SortCompareTest.arr));

        int[] brr = Arrays.copyOf(SortCompareTest.arr, SortCompareTest.arr.length);

        SortCompareTest.straightInsertionSort(brr);

        MsgChannel.addMsgLine("排序后数组为：" + Arrays.toString(brr));
        MsgChannel.addMsgLine("比较次数为：" + SortCompareTest.count);
        MsgChannel.addMsgLine("----------------------------------------------------");
        SortCompareTest.count = 0;
    }
    public void merge(){
        MsgChannel.addMsgLine(" ");
        MsgChannel.addMsgLine("[归并排序算法]：");
        MsgChannel.addMsgLine("原数组为："+ Arrays.toString(SortCompareTest.arr));

        int[] brr = Arrays.copyOf(SortCompareTest.arr, SortCompareTest.arr.length);

        SortCompareTest.mergeSort(brr);

        MsgChannel.addMsgLine("排序后数组为：" + Arrays.toString(brr));
        MsgChannel.addMsgLine("比较次数为：" + SortCompareTest.count);
        MsgChannel.addMsgLine("----------------------------------------------------");
        SortCompareTest.count = 0;
    }
    public void quick(){
        MsgChannel.addMsgLine(" ");
        MsgChannel.addMsgLine("[快速排序算法]：");
        MsgChannel.addMsgLine("原数组为："+ Arrays.toString(SortCompareTest.arr));

        int[] brr = Arrays.copyOf(SortCompareTest.arr, SortCompareTest.arr.length);

        SortCompareTest.quickSort(brr, 0, brr.length - 1);

        MsgChannel.addMsgLine("排序后数组为：" + Arrays.toString(brr));
        MsgChannel.addMsgLine("比较次数为：" + SortCompareTest.count);
        MsgChannel.addMsgLine("----------------------------------------------------");
        SortCompareTest.count = 0;
    }
    public void heap(){
        MsgChannel.addMsgLine(" ");
        MsgChannel.addMsgLine("[堆排序算法]：");
        MsgChannel.addMsgLine("原数组为："+ Arrays.toString(SortCompareTest.arr));

        int[] brr = Arrays.copyOf(SortCompareTest.arr, SortCompareTest.arr.length);

        SortCompareTest.heapSort(brr);

        MsgChannel.addMsgLine("排序后数组为：" + Arrays.toString(brr));
        MsgChannel.addMsgLine("比较次数为：" + SortCompareTest.count);
        MsgChannel.addMsgLine("----------------------------------------------------");
        SortCompareTest.count = 0;
    }

}

package servlet;

import algorithm_class.ex_1.Fibonacci;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author: youyinnn
 */
@WebServlet("/fibonacci")
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
        System.out.println(Thread.currentThread());
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

    public void stop(){
        ThreadContainer.threadState();
        System.out.println("stop");
        //ThreadContainer.waitAllThread();
    }

}

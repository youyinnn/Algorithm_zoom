package question.Field.q6;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/29
 */
public class Main {

    public static void f(int[] a, int n)
    {
        if(n==a.length-1)
        {
            int k = 0;
            for(int i=0; i<a.length; i++) k = k*10 + a[i];   // 填空1
            int m = (int)(Math.sqrt(k)+0.5);
            if(m*m==k)
            {
                System.out.println(k);
            }
            return;
        }

        for(int i=n; i<a.length; i++)
        {
            int t = a[n];
            a[n] = a[i];
            a[i] = t;

            f(a, n+1);        // 填空2

            t = a[n];
            a[n] = a[i];
            a[i] = t;
        }
    }

    public static void main(String[] args)
    {
        int[] a = {1,9,6};
        f(a, 0);
    }
}

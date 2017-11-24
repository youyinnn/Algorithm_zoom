package _20170328.done.Field.q5;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/29
 */
public class Main {
    public static void findRepeat(String x)
    {
        for(int i=1; i<=x.length()/2; i++)
        {
            String base = x.substring(0,i);
            int p = i;
            for(;;)
            {
                if(p+i>x.length()) break;
                if(x.substring(p,p+i).equals(base)==false) break;
                p = p + i;   // 填空1
            }

            if(p == x.length())  // 填空2
            {
                System.out.println(base);
                break;
            }
        }
    }

    public static void main(String[] args)
    {
        findRepeat("IhaveagoodideaIhaveagoodideaIhaveagoodidea");
        findRepeat("abcabcabc");
        findRepeat("asdfqwerzxcvasdfqwerzxcvasdfqwerzxcvasdfqwerzxcv");
    }
}

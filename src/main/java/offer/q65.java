package offer;

import org.junit.Test;

public class q65 {

    public int add(int a, int b) {
        int x = a;
        return x += b;
    }

    @Test
    public void testAdd(){
        System.out.println(3 & 4);
        System.out.println(add(100, 200));
    }

}
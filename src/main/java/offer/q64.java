package offer;

import org.junit.Test;

public class q64 {

    /**
     * using if and recursion
     * @param n
     * @return
     */
    public int sumNums1(int n) {
        if (n == 1) {
            return n;
        } else {
            return n + sumNums1(n - 1);
        }
    }
    
    @Test
    public void testSumNums1() {
        System.out.println(sumNums1(9));
    }

    public int sumNums2(int n) {
        boolean f = n > 0 && (n += sumNums2(n - 1)) > 0;
        return n;
    }
    
    
    @Test
    public void testSumNums2() {
        System.out.println(sumNums2(9));
    }

    @Test
    public void testSumNums2Logic() {
        int n = 9;
        System.out.println(n = 8);
        System.out.println(n = n + 8);
        System.out.println(n += 8);
    }
    
}
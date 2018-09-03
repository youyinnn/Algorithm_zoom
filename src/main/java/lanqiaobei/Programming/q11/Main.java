package lanqiaobei.Programming.q11;

import java.util.Scanner;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/4/1
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int i = 2;
        while (step(i) != n){
            i++;
        }
        System.out.println(i);
    }

    public static int step(int n){
        int k = 0;
        int m = n;
        do {
            if ( m % 2 == 0){
                m /= 2;
            }else {
                m = m*3+1;
            }
            k++;
        }while ( m != 1);
        return k;
    }
}

package _20170328.done.Programming.q10;

import java.util.Scanner;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/4/1
 */

public class Main {

    /**
     * 实现思路：
     *          这题是在网上寻求的答案，砝码的重量正好是3的4次方以内，所以我们要表示任意重量的话
     *          可以将任意重量转换为3进制，然后从低位到高位分析，如果数字是1，代表这个位置的砝码
     *          有一个，如果是0，那么代表这个位置的砝码没有，如果是2，代表需要这个位置的砝码数为
     *          2，但是我们没有两个相同的砝码，所以当需要两个砝码的时候，就从高位借一个砝码，并
     *          减去当前位的一个砝码。
     *
     *          我们拥有的砝码：
     *          1 = 3^0  , 3 = 3^1  , 9 = 3^2  ,  27 = 3^3  , 81 = 3^4.
     *          即任意1~121之间的数我们都可以用5位以内的三进制数表示
     *          如我们要表示：77，77转换为3进制是数是：[2212]，我们处理一下需要2个砝码的位置
     *          即[2212]可以转换为：[1，0，0，-1，-1]
     *                      即表示：需要1个81砝码，减去1个3砝码和1个1砝码
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] power_f = {81,27,9,3,1};
        int[] power = new int[5];
        int i = 4;
        while (true){
            if (n == 0) break;
            else {
                power[i] = n % 3 ;
                n /= 3;
                i--;
            }
        }
        for (int j = 4 ; j >= 0 ;--j){
            if (power[j] == 2){
                power[j] = -1;
                power[j-1]++;
            }
            if (power[j] == 3){
                power[j] = 0;
                power[j-1]++;
            }
        }
        StringBuffer s = new StringBuffer();

        for (int k = 0 ; k < 5 ; ++k ){
            if (power[k] == 1){
                s.append("+").append(power_f[k]);
            }
            if (power[k] == -1){
                s.append("-").append(power_f[k]);
            }
        }
        System.out.println(s.delete(0, 1));
    }
}

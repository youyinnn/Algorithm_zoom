package algorithm;

import java.util.Scanner;

/**
 *
 * 多米诺
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 多米诺骨牌大家想必都不陌生，现在有n块多米诺骨牌放在x轴上，每一块骨牌有一个所在位置下标和高度，每一块骨牌都只会向x轴正方向倒下，当处于位置x0，高度为h0的多米诺骨牌倒下，
 * 会压倒[x + 1, x + h - 1]内的所有多米诺骨牌，对于每一块骨牌。我们希望知道，如果我把这块骨牌推倒，那么至多可以倒下多少块骨牌。
 *
 * 输入
 * 输入第一行包含一个正整数n，表示多米诺骨牌的数量(1<=n<=10^5)
 *
 * 接下来n行，每行包含两个正整数x,h，分别表示第i块多米诺骨牌的位置和高度(-10^8<=x<=10^8,2<=h<=10^8)。保证不会有两块骨牌在同一高度。
 *
 * 输出
 * 对于每个测试数据，输出一行， 包含n个正整数，第i个数字表示，如果推倒第i块多米诺骨牌，可以使得多少个骨牌倒下。
 *
 *
 * 样例输入
 * 4
 * 16 5
 * 20 5
 * 10 10
 * 18 2
 * 样例输出
 * 3 1 4 1
 * @author youyinnn
 * Date 9/3/2018
 */
public class Domino {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] x = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = input.nextInt();
            h[i] = input.nextInt();
        }
        int[] rs = new int[n];
        for (int i = 0; i < n; i++) {
            int cover = x[i] + h[i];
            for (int j = 0; j < n; j++) {
                if (x[j] > x[i] && cover > x[j]) {
                    if (x[j] + h[j] > cover) {
                        cover = x[j] + h[j];
                    }
                    rs[i] += 1;
                }
            }
            System.out.print((rs[i] + 1) + " ");
        }
    }

}

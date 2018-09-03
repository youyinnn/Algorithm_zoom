package algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author youyinnn
 * Date 9/1/2018
 */
public class DPTest {

    @Test
    public void testDig(){
        int[] g = {400, 500, 200, 300, 350};
        int[] gw = {5, 5, 3, 4, 3};
        //dig(g, gw, 10);
        //dig2(g, gw, 10);
        dig3(g, gw, 10, 4);
    }

    private void dig(int[] g, int[] gw, int w){
        int[] preResult = new int[w];
        // 准备第一行的数据
        for (int useWorker = 1; useWorker <= w; useWorker++) {
            preResult[useWorker - 1] = useWorker >= gw[0] ? g[0] : 0;
        }
        int[] nowResult = new int[w];
        // 从第二座矿开始算
        for (int m = 1; m < g.length; m++){
            System.out.println(Arrays.toString(preResult));
            // 从第一个工人开始算
            for (int useWorker = 1; useWorker <= w; useWorker++) {
                // 如果当前的工人数不能挖当前的矿，那么就挖之前的矿
                if (useWorker < gw[m]) {
                    nowResult[useWorker - 1] = preResult[useWorker - 1];
                } else {
                    // 在：1.挖当前的矿，剩余的人挖之前的矿；2.当前可用的工人挖之前的矿；中选一个最多金量的
                    nowResult[useWorker - 1] = Math.max(preResult[useWorker - 1], (useWorker - gw[m] - 1 > 0 ? preResult[useWorker - gw[m] - 1] : 0) + g[m]);
                }
            }
            System.arraycopy(nowResult, 0, preResult, 0, w);
        }
        System.out.println(Arrays.toString(nowResult));
    }

    private void dig2(int[] g, int[] gw, int w){
        int[] preResult = new int[w];
        // 准备第一行的数据
        for (int useWorker = 1; useWorker <= w; useWorker++) {
            preResult[useWorker - 1] = useWorker >= gw[0] ? g[0] : 0;
        }
        int[] nowResult = new int[w];
        // 从第二座矿开始算
        for (int m = 1; m < g.length; m++){
            System.out.println(Arrays.toString(preResult));
            // 从第一个工人开始算
            for (int useWorker = 1; useWorker <= w; useWorker++) {
                // 前矿
                int front = preResult[useWorker - 1];
                // 当前工人能不能挖当前这个矿 能就耗费wm人 不能就耗费0个人
                int wm = useWorker >= gw[m] ? gw[m] : 0;
                // 剩下多少人
                int left = useWorker - wm;
                // 后矿：如果挖不了当前的矿，就挖前矿；如果能挖，剩下的人去挖前矿剩下的人能挖的
                int back = wm == 0 ? preResult[useWorker - 1] : g[m] + (left > 0 ? preResult[left - 1] : 0);
                // 前矿后矿谁大挖谁
                nowResult[useWorker - 1] = front > back ? front : back;
            }
            System.arraycopy(nowResult, 0, preResult, 0, w);
        }
        System.out.println(Arrays.toString(nowResult));
    }

    private int[] dig3(int[] g, int[] gw, int w, int m) {
        int[] nowResult = new int[w];
        if (m == 0) {
            nowResult = new int[]{0,0,0,0,400,400,400,400,400,400};
        } else {
            int[] preResult = dig3(g, gw, w, m - 1);
            for (int useWorker = 1; useWorker <= w; useWorker++) {
                if (useWorker < gw[m]) {
                    nowResult[useWorker - 1] = preResult[useWorker - 1];
                } else {
                    nowResult[useWorker - 1] = Math.max(preResult[useWorker - 1], (useWorker - gw[m] - 1 > 0 ? preResult[useWorker - gw[m] - 1] : 0) + g[m]);
                }
            }
        }
        System.out.println(Arrays.toString(nowResult));
        return nowResult;
    }
}

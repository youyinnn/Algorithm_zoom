package leetcode.race.week191;

import java.util.Arrays;

import org.junit.Test;

public class q2 {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxH = 0;
        long maxW = 0;
        for (int i = 0; i < horizontalCuts.length; i++ ){
            if (i == 0) {
                maxH = Math.max(maxH, horizontalCuts[i]);
            } else {
                maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
            }
        }
        maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 0; i < verticalCuts.length; i++ ){
            if (i == 0) {
                maxW = Math.max(maxW, verticalCuts[i]);
            } else {
                maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i - 1]);
            }
        }
        maxW = Math.max(maxW, w - verticalCuts[verticalCuts.length - 1]);
        return (int) Math.floorMod(maxH * maxW, 1000000007L);
    }

    @Test
    public void test() {
        int[] ho = {1, 2, 4};     
        int[] ve = {1, 3};     
        System.out.println(maxArea(5, 4, ho, ve));

        int[] ho2 = {3, 1};     
        int[] ve2 = {1};     
        System.out.println(maxArea(5, 4, ho2, ve2));

        int[] ho3 = {3};     
        int[] ve3 = {3};     
        System.out.println(maxArea(5, 4, ho3, ve3));

        int[] ho4 = {1};     
        int[] ve4 = {1};     
        System.out.println(maxArea(1, 1, ho4, ve4));
    }
}
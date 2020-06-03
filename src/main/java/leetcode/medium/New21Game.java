package leetcode.medium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class New21Game {

    public double new21Game(int n, int k, int w) {
        if (k == 0) return 1.0;
        double[] dp = new double[k + w + 1];
        for (int i = k; i <= k + w - 1 && i <= n; i++) {
            dp[i] = 1.0;
        }
        dp[k - 1] = 1.0 * Math.min(n - k + 1, w) / w;
        for (int i = k - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + w + 1] - dp[i + 1]) / w;
        }

        return dp[0];
    }

    @Test
    public void t1() {
        assertEquals(1.0, new21Game(10, 1, 10), 0.00001);
        assertEquals(0.73278, new21Game(21, 17, 10), 0.00001);
    }

    public double new21Game2(int n, int k, int w) {
        if (k == 0) return 1.0;
        double[] dp = new double[k + w + 1];
        for (int i = k; i <= k + w - 1 && i <= n; i++) {
            dp[i] = 1.0;
        }
        // dp[k - 1] = 1.0 * Math.min(n - k + 1, w) / w;
        for (int i = k - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + w + 1] - dp[i + 1]) / w;
        }

        return dp[0];
    }

    @Test
    public void t2() {
        assertEquals(0.73278, new21Game2(21, 17, 10), 0.00001);
    }
}
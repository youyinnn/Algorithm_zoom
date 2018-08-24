/**
 * @author youyinnn
 * Date 8/23/2018
 */
public class KMPTest {

    public static void main(String[] args) {
        String s = "asdasde";
        String p = "asde";
        System.out.println(bruteForceStringMatch(s, p));
        System.out.println(bruteForceStringMatch2(s, p));
        System.out.println(kmp(s, p));
    }

    public static int[] next(String pattern) {
        char[] p = pattern.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static int kmp(String text, String pattern) {
        char[] t = text.toCharArray();
        char[] p = pattern.toCharArray();
        if (t.length < p.length) {
            return -1;
        } else if (t.length == p.length && t[0] != p[0]) {
            return -1;
        }
        int[] next = next(pattern);
        int i = 0;
        int j = 0;
        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
                if (t.length - i <= p.length && j != -1 && p.length - next[j] <= t.length - i - 1) {
                    return -1;
                }
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int bruteForceStringMatch(String text, String pattern){
        char[] t = text.toCharArray();
        char[] p = pattern.toCharArray();
        int n = t.length;
        int m = p.length;
        for (int i = 0; i <= n - m; i++){
            int j = 0;
            while(j < m && p[j] == t[i + j]){
                j++;
                if (j == m) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int bruteForceStringMatch2(String text, String pattern) {
        char[] t = text.toCharArray();
        char[] p = pattern.toCharArray();
        // 主串的位置
        int i = 0;
        // 模式串的位置
        int j = 0;
        while (i < t.length && j < p.length) {
            // 当两个字符相同，就比较下一个
            if (t[i] == p[j]) {
                i++;
                j++;
            } else {
                // 一旦不匹配，i后退
                i = i - j + 1;
                // j归0
                j = 0;
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }
}

package leetcode.easy;

/**
 * @author youyinnn
 * Date 2/18/2019
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int length = 1;
        int tmp = x;
        int headBase = 1;
        int tailBase = 1;
        while (tmp >= 10) {
            length++;
            tmp /= 10;
            headBase *= 10;
        }

        for (int i = 0; i < length / 2; i++) {
            int head = (x / headBase) % 10;
            int tail = (x / tailBase) % 10;
            if (head != tail) {
                return false;
            } else {
                headBase /= 10;
                tailBase *= 10;
            }
        }
        return true;
    }

}

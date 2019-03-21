package leetcode.medium;

import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MultiplyStrings {

    public String multiply(String a, String b) {
        int maxLength = a.length() + b.length();
        int[] box = new int[maxLength];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                char an = a.charAt(i);
                char bn = b.charAt(j);
                box[i + j + 1] += (an - '0') * (bn - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = box.length - 1; i >= 0; i--) {
            int num = box[i];
            int left = num % 10;
            int carry = num / 10;
            if (i > 0) {
                box[i - 1] += carry;
            }
            sb.insert(0, left);
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }

    @Test
    public void testMultiplication(){
        assertEquals("56088", multiply("123", "456"));
        assertEquals("0", multiply("0", "456"));
        assertEquals("0", multiply("0", "0"));
        for (int i = 0; i < 100; i++) {
            BigInteger a = new BigInteger(110, new Random());
            BigInteger b = new BigInteger(110, new Random());
            assertEquals(a.multiply(b).toString(), multiply(a.toString(), b.toString()));
        }
    }
}

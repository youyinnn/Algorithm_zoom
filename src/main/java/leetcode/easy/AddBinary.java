package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author youyinnn
 * Date 4/2/2019
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int ai = ac.length - 1;
        int bi = bc.length - 1;
        while (bi >= 0) {
            ac[ai] = ac[ai] == '0'
                    // aci = 0
                    ? bc[bi]
                    // aci = 1
                    : (bc[bi] == '0'
                        // bci = 0
                        ? '1'
                        // bci = 1
                        : '2');
            bi--;
            ai--;
        }
        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        for (int i = ac.length - 1; i >= 0; i--) {
            if (carry) {
                if (ac[i] == '0') {
                    ac[i] = '1';
                    carry = false;
                } else if (ac[i] == '1') {
                    ac[i] = '2';
                } else if (ac[i] == '2'){
                    ac[i] = '3';
                }
            }
            if (ac[i] == '2') {
                ac[i] = '0';
                carry = true;
            } else if (ac[i] == '3') {
                ac[i] = '1';
                carry = true;
            }
            sb.insert(0, ac[i]);
        }
        if (carry) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    @Test
    public void test(){
        assertEquals("10010", addBinary("11", "1111"));
    }



}

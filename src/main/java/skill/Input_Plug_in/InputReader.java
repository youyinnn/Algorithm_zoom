package skill.Input_Plug_in;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/4/7
 */
class InputReader {
    private BufferedReader buf;
    private StringTokenizer tok;

    InputReader() {
        buf = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * 不建议使用
     * @return
     */
    boolean hasNext() {
        while (tok == null || !tok.hasMoreElements()) {
            try {
                tok = new StringTokenizer(buf.readLine());
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
    String next() {
        if (hasNext()) {
            return tok.nextToken();
        }
        return null;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    BigDecimal nextBigDecimal() {
        return new BigDecimal(next());
    }
}

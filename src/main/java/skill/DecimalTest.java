package skill;

import java.math.BigDecimal;

/**
 * @author youyinnn
 */
public class DecimalTest {

    public static void main(String[] args) {
        double a = 1.258;
        String format = String.format("%.2f", a);
        System.out.println(format);

        BigDecimal b =
                new BigDecimal(
                        "100000000000000000000000" +
                                "000000000000000000000" +
                                "000000000000000000000" +
                                "000000000000000000000" +
                                "00000000000000000000." +
                                "66666666666666666666");

        //四舍五入
        System.out.println(b.setScale(5, BigDecimal.ROUND_UP));
        //截断
        System.out.println(b.setScale(5, BigDecimal.ROUND_DOWN));
    }

}

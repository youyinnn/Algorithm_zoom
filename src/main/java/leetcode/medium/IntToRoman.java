package leetcode.medium;

import org.junit.Test;

/**
 * @author youyinnn
 * Date 3/1/2019
 */
public class IntToRoman {

    private String[] hashRom = {
            "", "I","II","III","IV","V","VI","VII","VIII","IX",
            "", "X","XX","XXX","XL","L","LX","LXX","LXXX","XC",
            "", "C","CC","CCC","CD","D","DC","DCC","DCCC","CM",
            "", "M","MM","MMM",
    };

    public String intToRoman(int num) {
        return hashRom[30 + (num / 1000)] +
                hashRom[20 + ((num % 1000) / 100)] +
                hashRom[10 + ((num % 100) / 10)] +
                hashRom[num % 10];
    }

    @Test
    public void test1(){
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(3));
    }
}

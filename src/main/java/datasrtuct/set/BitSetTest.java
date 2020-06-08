package datasrtuct.set;

import java.util.BitSet;
import java.util.Scanner;

import org.apache.lucene.util.LongBitSet;
import org.junit.Test;
import org.openjdk.jol.info.GraphLayout;

public class BitSetTest {
    
    public static void main(String... args) {
        // LongBitSet lbs = new LongBitSet(4300000000L);
        // System.out.println(GraphLayout.parseInstance(lbs).totalSize());
        // Scanner sc = new Scanner(System.in);
        // sc.nextInt();

        BitSet bs = new BitSet(Integer.MAX_VALUE);
        System.out.println(GraphLayout.parseInstance(bs).totalSize());
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
    }

}
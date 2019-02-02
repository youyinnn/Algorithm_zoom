package algorithm.hashing;

import org.junit.Test;

/**
 * @author youyinnn
 * Date 2/2/2019
 */
public class Hashing {

    public int hash(int key, int rank) {
        return Math.abs((Math.abs(key) % rank) - 1);
    }

    @Test
    public void testHashing(){
        System.out.println(hash(3, 10));
        System.out.println(hash(13, 10));
    }

    @Test
    public void testBuildUpHashTable(){
        int[] sequence = {3, 3, 28, 5, 33, 51, 39};
        LdHashTable ldHashTable = new LdHashTable(sequence);
        System.out.println(ldHashTable.hash(14));

        ldHashTable.showTable();

        System.out.println(ldHashTable.seek(3));
        System.out.println(ldHashTable.seek(33));
        System.out.println(ldHashTable.seek(51));
        System.out.println(ldHashTable.seek(28));
        System.out.println(ldHashTable.seek(4));
    }
}

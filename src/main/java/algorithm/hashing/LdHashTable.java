package algorithm.hashing;

import java.util.Arrays;

/**
 * @author youyinnn
 * Date 2/2/2019
 */
public class LdHashTable implements HashableInteger {

    private Integer[] table;

    public LdHashTable(int[] originSeq) {
        setHashTable(originSeq);
    }

    @Override
    public int hash(int key) {
        return Math.abs(key) % table.length;
    }

    @Override
    public int collisionHandle(int key) {
        return linearDetection(key, false);
    }

    @Override
    public void setHashTable(int[] originalSeq) {
        this.table = new Integer[originalSeq.length << 1];
        for (int key : originalSeq) {
            int place = collisionHandle(key);
            table[place] = key;
        }
    }

    @Override
    public int seek(int key) {
        return linearDetection(key, true);
    }

    @Override
    public void showTable() {
        System.out.println(Arrays.toString(table));
    }

    private int linearDetection(int key, boolean seek) {
        int hash = hash(key);
        if (!seek && table[hash] == null) {
            return hash;
        } else if (seek && table[hash] == null) {
            return -1;
        } else if (seek && table[hash] == key) {
            return hash;
        } else {
            int offSet = 1;
            boolean after = false;
            while (hash + offSet < table.length) {
                if (!seek && table[hash + offSet] == null) {
                    break;
                } else if (seek && table[hash + offSet] == null) {
                    return -1;
                } else if (seek && table[hash + offSet] == key) {
                    return hash + offSet;
                }
                offSet++;
            }
            if (hash + offSet == table.length) {
                offSet = 1;
                while (hash - offSet >= 0) {
                    if (!seek && table[hash - offSet] == null) {
                        break;
                    } else if (seek && table[hash - offSet] == null) {
                        return -1;
                    } else if (seek && table[hash - offSet] == key) {
                        return hash + offSet;
                    }
                    offSet++;
                }
            } else {
                after = true;
            }
            return after ? hash + offSet : hash - offSet;
        }
    }
}

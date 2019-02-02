package algorithm.hashing;

/**
 * @author youyinnn
 * Date 2/2/2019
 */
public interface HashableInteger {

    int hash(int key);

    int collisionHandle(int key);

    void setHashTable(int[] originSequence);

    int seek(int key);

    void showTable();
}

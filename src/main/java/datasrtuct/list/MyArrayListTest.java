package datasrtuct.list;

import org.junit.Test;

/**
 * @author youyinnn
 */
public class MyArrayListTest {

    @Test
    public void testAdd(){
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 11; i++) {
            list.add(i + 1);
        }
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        list.remove(9);
        System.out.println(list);
        System.out.println(list.get(5));
        System.out.println(list.get(10));
        System.out.println(list.contains(10));
        System.out.println(list.contains(11));
        list.add(7, 15);
        list.add(0, 20);
        System.out.println(list);

        for (Integer aList : list) {
            System.out.print(aList + ",");
        }
    }

}

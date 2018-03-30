package skill;

import java.util.*;

/**
 * @author youyinnn
 */
public class CollectionFramework {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0 ; i < 10 ; ++i) {
            integers.add(i);
        }
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println(integers.contains(5));
        System.out.println(integers.size());
        System.out.println(integers.indexOf(6));
        integers.remove(0);
        System.out.println(integers);
        System.out.println(integers.get(8));

        HashSet<Double> doubles = new HashSet<>();
        doubles.add(5.68);
        doubles.add(3.25);
        doubles.add(7.41);
        doubles.add(5.68);
        System.out.println(doubles);

        ArrayList<Double> doubles1 = new ArrayList<>(doubles);

        TreeSet<Integer> t1 = new TreeSet<>(new IntComparator());
        t1.add(8);
        t1.add(4);
        t1.add(9);
        t1.add(0);
        System.out.println(t1);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(19, "a");
        map.put(9, "b");
        map.put(19, "c");
        map.put(8, "e");
        for (Integer key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

class IntComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) {
            return -1;
        } else if (o1 < o2) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1 , 2, 3, 4};
        // 数组转ArrayList
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a));
        // ArrayList转数组
        Integer[] objects = list.toArray(new Integer[list.size()]);
    }
}

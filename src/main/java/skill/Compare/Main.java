package skill.Compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/4/7
 */
public class Main {

    public static void main(String[] args) {
        Person p1 = new Person("A",10);
        Person p2 = new Person("A",20);
        Person p3 = new Person("B",10);
        Person p4 = new Person("B",1);

        List<Person> arrayList = new ArrayList<>();

        arrayList.add(p2);
        arrayList.add(p1);
        arrayList.add(p3);
        arrayList.add(p4);

        for (Person person : arrayList) {
            System.out.println(person);
        }

        Collections.sort(arrayList);

        System.out.println("----------------------");

        for (Person person : arrayList) {
            System.out.println(person);
        }

    }
}

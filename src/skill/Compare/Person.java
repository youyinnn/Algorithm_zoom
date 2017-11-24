package skill.Compare;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/4/7
 */
public class Person implements Comparable{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Person obj = (Person) o;
        if (name.compareTo(obj.name) != 0){
            return name.compareTo(obj.name);
        }else {
            return age > obj.age ? 1 : -1;
        }
    }
}

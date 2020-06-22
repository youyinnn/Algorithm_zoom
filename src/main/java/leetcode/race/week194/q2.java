package leetcode.race.week194;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

public class q2 {

    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String cur = names[i];
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            } else {
                int count = map.get(cur);
                String newName = newName(cur, count);
                while (map.containsKey(newName)) {
                    count++;
                    newName = newName(cur, count);
                }
                map.put(newName, 1);
                map.put(cur, count);
                names[i] = newName;
            }
        }
        return names;
    }

    public String newName(String raw, int i){
        return new String(raw + '(' + i + ')').intern();
    }
    
    @Test
    public void t1() {
        String[] a = {"gta", "gta(1)", "gta", "avaion"};
        System.out.println(Arrays.toString(getFolderNames(a)));

        String[] b = {"pes","fifa","gta","pes(2019)"};
        System.out.println(Arrays.toString(getFolderNames(b)));

        
        String[] c = {"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"};
        System.out.println(Arrays.toString(getFolderNames(c)));

        String[] d = {"wano","wano","wano","wano"};
        System.out.println(Arrays.toString(getFolderNames(d)));

        String[] e = {"kaido","kaido(1)","kaido","kaido(1)"};
        System.out.println(Arrays.toString(getFolderNames(e)));
    }

    @Test
    public void t2() {
        String[] a = {"t","l(1)(3)","o","i(3)(1)","j(1)","g","z","z","q(3)(2)","u(1)(3)","x","m","l(4)(2)","o","h","s","e","c","v"};
        System.out.println(Arrays.toString(getFolderNames(a)));
    }

    @Test
    public void t3() {
        String[] a = {"t", "t(3)", "t"};
        System.out.println(Arrays.toString(getFolderNames(a)));
    }

    @Test
    public void t4() {
        String[] a = {"t(1)", "t", "t"};
        System.out.println(Arrays.toString(getFolderNames(a)));
    }

    
    @Test
    public void t5() {
        String[] a = {"c(5)", "c", "c(3)", "c", "c(2)", "c"};
        System.out.println(Arrays.toString(getFolderNames(a)));
    }
}
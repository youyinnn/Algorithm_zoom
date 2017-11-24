package skill.Input_Plug_in;

import java.util.ArrayList;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/4/7
 */
public class Main {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader();

        String str = inputReader.next();

        ArrayList<String> a = new ArrayList<>();

        while (inputReader.hasNext()){
            a.add(inputReader.next());
        }

        for (String s : a) {
            System.out.println(s);
        }
    }
}

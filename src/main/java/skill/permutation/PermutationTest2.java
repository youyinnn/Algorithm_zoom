package skill.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author youyinnn
 */
public class PermutationTest2 {
    public static ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() <= 0) {
            return res;
        }
        //结果去重
        HashSet<String> set = new HashSet<>();
        dfs(set, str.toCharArray(), 0);
        res.addAll(set);
        Collections.sort(res);
        return res;
    }

    public static  void dfs(HashSet<String> set, char [] str, int k){
        //得到结果
        if(k == str.length){
            set.add(new String(str));
            return ;
        }
        for(int i = 0; i < str.length; i ++){
            swap(i, k, str);
            dfs(set, str, k + 1);
            //回溯
            swap(i, k, str);
        }
    }

    public static  void swap(int i, int j, char [] str){
        if(i != j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(permutation(s));
    }
}

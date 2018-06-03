package question.Programming.q9;

import java.util.*;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/30
 */
public class Main {

    /**
     * 实现思路：
     *          利用TreeSet不允许元素重复且元素会按照自然顺序排列的特性，我们把任意字符串放到
     *          TreeSet里面，这样里面就是有序且没有重复元素的字母序列。剩下的就是遍历串，串长
     *          是n的串里面取3个字母的所有情况就是解。
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s = input.next();

        String[] ss = s.split("");

        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.addAll(Arrays.asList(ss));

        ArrayList<String> arrayList = new ArrayList<>(treeSet);

        ArrayList<String> result = new ArrayList<>();

        StringBuilder sss = new StringBuilder();

        for (int i = 0 ; i < treeSet.size()-2 ; ++i){
            sss.append(arrayList.get(i));
            for (int j = i+1 ; j < treeSet.size()-1 ; ++j){
                sss.append(arrayList.get(j));
                for (int k = j+1 ; k < treeSet.size() ; ++k){
                    sss.append(arrayList.get(k));
                    result.add(sss.toString());
                    sss.deleteCharAt(sss.length()-1);
                }
                sss.deleteCharAt(sss.length()-1);
            }
            sss.deleteCharAt(sss.length()-1);
        }

        for (String s1 : result) {
            System.out.println(s1);
        }
    }
}

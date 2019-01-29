package algorithm;

import java.util.*;

/**
 * 家族关系
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 小明和小红是亲兄妹，他俩一起翻了翻他们家的族谱，发现他们家非常庞大，有非常多的名字在族谱里面。族谱中会写清楚每一个人的父亲是谁，当然每个人都只会有一个父亲。
 *
 * 对于祖先的定义，我们在这儿举个例子：族谱里面会写小王的父亲是小丁，小丁的父亲是小东，那么实际上小东就是小王的爷爷，也是小王的祖先。
 *
 * 小明很聪明，小明理了理他们的家庭关系，很快就弄清楚了，知道了族谱中每一个人的祖先关系。
 *
 * 但是小红却依旧困惑，于是问了很多问题，希望你能够解答。
 *
 * 小红的问题是，请问A是B的祖先关系是什么？究竟A是不是B的祖先，或者说B是A的祖先，亦或者B和A不存在祖先关系呢。
 *
 * 输入
 * 输入第一行包括一个整数n表示家族成员个数。
 *
 * 接下来n行每行一对整数对a和b表示a是b的父亲，或者b是a的父亲，这需要你来判断。
 *
 * 如果b是-1，那么a就是整个家族的根，也就是辈分最大的人，保证只有一个。
 *
 * 第n+2行是一个整数m表示小红的询问个数。
 *
 * 接下来m行，每行两个正整数A和B。
 *
 * 表示小红想知道A是B的祖先关系。
 *
 * n,m≤40000，每个节点的编号都不超过40000。
 *
 * 输出
 * 对于每一个询问。
 *
 * 输出1表示A是B的祖先，输出2表示B是A的祖先，都不是输出0
 *
 *
 * 样例输入
 * 10
 * 1 -1
 * 3 1
 * 4 1
 * 5 1
 * 6 1
 * 7 1
 * 8 1
 * 9 1
 * 10 1
 * 2 10
 * 5
 * 1 2
 * 2 3
 * 2 4
 * 2 5
 * 2 10
 * 样例输出
 * 1
 * 0
 * 0
 * 0
 * 2
 *
 * @author youyinnn
 * Date 9/3/2018
 */
public class FamilyRelationship {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        HashMap<Integer, ArrayList<Integer>> fa = new HashMap<>(10);
        for (int i = 0; i < n; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            ArrayList<Integer> integers = fa.get(b);
            if (integers == null) {
                fa.put(b, new ArrayList<>(Collections.singletonList(a)));

            } else {
                integers.add(a);
            }
        }
        toF(fa);
        //System.out.println(fa);

    }

    public static void toF(HashMap<Integer, ArrayList<Integer>> fa) {
        F root = new F(null, fa.get(-1).get(0));
        ArrayList<Integer> rootSon = fa.get(fa.get(-1).get(0));
        for (Integer integer : rootSon) {
            root.addSon(new F(root, integer));
        }
        System.out.println(root);
    }

    static class F{
        F father;
        int key;
        ArrayList<F> sons = new ArrayList<>(10);

        public F getFather() {
            return father;
        }

        public void setFather(F father) {
            this.father = father;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public ArrayList<F> getSons() {
            return sons;
        }

        public void setSons(ArrayList<F> sons) {
            this.sons = sons;
        }

        public void addSon(F son) {
            sons.add(son);
        }

        public F(F father, int key) {
            this.father = father;
            this.key = key;
        }

        @Override
        public String toString() {
            return "F{" +
                    "fa=" + father +
                    ", key=" + key +
                    ", sons=" + sons +
                    '}';
        }
    }

}

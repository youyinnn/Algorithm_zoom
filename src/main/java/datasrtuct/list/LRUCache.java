package datasrtuct.list;

import java.util.LinkedList;

/**
 * LRUCache
 */
public class LRUCache {

    private LinkedList<String> cacheList = new LinkedList<>();

    public void visit(String element) {
        int index = cacheList.indexOf(element);
        if (index > 0) {
            cacheList.remove(index);
        }
        if (cacheList.size() == 5) {
            cacheList.removeLast();
        }
        cacheList.addFirst(element);
        System.out.println(cacheList);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache();
        cache.visit("Jack");
        cache.visit("Jim");
        cache.visit("Jimy");
        cache.visit("Jack");
        cache.visit("Jeny");
        cache.visit("Elan");
        cache.visit("Eidy");
        cache.visit("Jack");
        cache.visit("Bob");
    }
}
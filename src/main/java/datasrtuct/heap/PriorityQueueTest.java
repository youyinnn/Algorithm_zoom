package datasrtuct.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(100);
        Random random = new Random();
        int count = 100;
        while (--count > 0) {
            int add = random.nextInt(100);
            if (queue.size() == 0) {
                queue.add(add);
            } else if (add > queue.peek()) {
                queue.add(add);
                if (queue.size() == 11) queue.remove();
            }
        }
        System.out.println(Arrays.toString(queue.toArray()));
    }
}
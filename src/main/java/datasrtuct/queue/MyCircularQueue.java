package datasrtuct.queue;

public class MyCircularQueue {

    private int[] data;
    private int head;
    private int tail;
    private int cap;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new int[k];
        cap = head = tail = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            cap++;
            data[tail] = value;
            tail = (tail + 1) % data.length;
            return true;
        }
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            cap--;
            head = (head + 1) % data.length;
            return true;
        }
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : data[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty()? -1 : data[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return cap == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return cap == data.length;
    }
}
package datasrtuct.queue;

import java.util.LinkedList;

public class MyQueue {

    private LinkedList<Integer> asc  = new LinkedList<>();
    private LinkedList<Integer> desc = new LinkedList<>();
    private int cap = 0;
    private int headOfQueue;
    
    /** Initialize your data structure here. */
    public MyQueue() {

    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (asc.isEmpty()) {
            headOfQueue = x;
        }
        asc.push(x);
        cap++;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (asc.size() > 1) {
            desc.push(asc.pop());
        }
        int pop =  asc.pop();
        while (!desc.isEmpty()) {
            this.push(desc.pop());
        }
        return pop;
    }
    
    /** Get the front element. */
    public int peek() {
        return headOfQueue;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return cap == 0;
    }
}
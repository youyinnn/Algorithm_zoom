package servlet;

import java.util.ArrayList;

/**
 * @author: youyinnn
 */
public class ThreadContainer {

    private static ArrayList<Thread> threadList = new ArrayList<>();

    public static void addThread(Thread currentThread) {
        if (threadList.contains(currentThread)) {
            System.out.println("重复加入 : " + currentThread);
        } else {
            threadList.add(currentThread);
        }
    }

    public static void threadState(){
        System.out.println("---------------------------");
        for (Thread thread : threadList) {
            System.out.println(thread + " : " + thread.getState());
        }
        System.out.println("---------------------------");
    }

    public static void threadIsAlive(){
        System.out.println("---------------------------");
        for (Thread thread : threadList) {
            System.out.println(thread + " : " + thread.isAlive());
        }
        System.out.println("---------------------------");
    }

    public static void waitAllThread(){
        for (Thread thread : threadList) {
            try {
                if (thread.getState().equals(Thread.State.RUNNABLE)) {
                    thread.interrupt();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

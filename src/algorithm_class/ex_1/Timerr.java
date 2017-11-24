package algorithm_class.ex_1;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/11/22
 */
public class Timerr extends Thread{

    private int i = 0;

    private int endSecond;

    public Timerr(int endSecond){
        this.endSecond = endSecond;
    }

    @Override
    public void run() {
        while (true) {
            if (i == endSecond) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }

    }

    public int getI() {
        return i;
    }
}

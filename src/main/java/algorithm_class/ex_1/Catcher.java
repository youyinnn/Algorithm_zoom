package algorithm_class.ex_1;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/11/23
 */
public class Catcher extends Thread {

    Timerr timerr;

    Catcher(Timerr timerr) {
        this.timerr = timerr;
    }

    @Override
    public void run() {
        System.out.println(timerr.getI());
    }
}

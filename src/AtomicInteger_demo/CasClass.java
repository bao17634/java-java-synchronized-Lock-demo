package AtomicInteger_demo;

/**
 * @ClassName: CasClass
 * @Description: TODO
 * @Author: yanrong
 * @Date: 8/29/2019 3:49 PM
 * @Version: 1.0
 */
public class CasClass {
    final static int LOOP = 10000;
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread addThread = new Counter.AddDataThread(counter);
        Thread decThread = new Counter.DecDataThread(counter);
        addThread.start();
        decThread.start();
        addThread.join();
        decThread.join();
        System.out.println(counter.getCount());
    }
}

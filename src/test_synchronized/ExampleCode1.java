package test_synchronized;

/**
 * @ClassName: test_synchronized.ExampleCode1
 * @Description: TODO
 * @Author: yanrong
 * @Date: 8/28/2019 2:24 PM
 * @Version: 1.0
 */
public class ExampleCode1 implements Runnable {
    private int count;

    public ExampleCode1() {
        count = 0;
    }
    public void countAdd() {
        // 同步代码块
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + "同步块:" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
    public void printCount() {
        for (int i = 0; i < 5; i ++) {
            try {
                System.out.println(Thread.currentThread().getName() + " 非同步块:" + count);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("A")) {
            countAdd();
        } else if (threadName.equals("B")) {
            printCount();
        }
    }
}
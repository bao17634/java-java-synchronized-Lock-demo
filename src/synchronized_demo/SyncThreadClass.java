package synchronized_demo;

/**
 * @ClassName: SyncThreadClass
 * @Description: 修饰类
 * @Author: yanrong
 * @Date: 8/28/2019 5:52 PM
 * @Version: 1.0
 */
/**
 * 同步线程
 */
public class SyncThreadClass implements Runnable {
    private static int count;

    public SyncThreadClass() {
        count = 0;
    }

    public static void method() {
        synchronized(SyncThread.class) {
            for (int i = 0; i < 5; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public synchronized void run() {
        method();
    }
}

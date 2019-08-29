package test_synchronized;

/**
 * @ClassName: test_synchronized.SyncThread
 * @Description: TODO
 * @Author: yanrong
 * @Date: 8/28/2019 12:14 PM
 * @Version: 1.0
 */
public class SyncThread implements Runnable{
    private static int count;
    public SyncThread() {
        count = 0;
    }
    //synchronized修饰一个代码块
//    public  void run() {
//        synchronized(this) {
//            for (int i = 0; i < 5; i++) {
//                try {
//                    System.out.println(Thread.currentThread().getName() + "修饰代码块:" + (count++));
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
    //synchronized修饰一个静态方法
    public synchronized static void method() {
        for (int i = 0; i < 5; i ++) {
            try {
                System.out.println("线程"+Thread.currentThread().getName() + "修饰方法时:" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCount() {
        return count;
    }

    @Override
    public synchronized void run() {
        method();
    }
}

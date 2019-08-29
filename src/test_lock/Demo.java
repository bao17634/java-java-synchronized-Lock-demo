package test_lock;

/**
 * @ClassName: Demo
 * @Description: TODO
 * @Author: yanrong
 * @Date: 8/29/2019 2:29 PM
 * @Version: 1.0
 */
public class Demo {
    public static void main(String[] args) {
        ReentrantLockTest.MyService service = new ReentrantLockTest.MyService();
        ReentrantLockTest.MyThread a1 = new ReentrantLockTest.MyThread(service);
        ReentrantLockTest.MyThread a2 = new ReentrantLockTest.MyThread(service);
        ReentrantLockTest.MyThread a3 = new ReentrantLockTest.MyThread(service);
        ReentrantLockTest.MyThread a4 = new ReentrantLockTest.MyThread(service);
        ReentrantLockTest.MyThread a5 = new ReentrantLockTest.MyThread(service);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();

    }
}

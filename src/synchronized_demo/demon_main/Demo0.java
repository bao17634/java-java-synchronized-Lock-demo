package synchronized_demo.demon_main;

import synchronized_demo.entity.Account;
import synchronized_demo.AccountOperator;
import synchronized_demo.SyncThread;

/**
 * @ClassName: synchronized_demo.demon_main.Demo0
 * @Description: 测试哪个就不要注释那个，其余的注释掉
 * @Author: yanrong
 * @Date: 8/28/2019 12:16 PM
 * @Version: 1.0
 */
public class Demo0 {
    public static void main(String args[]) {
        /**
         * 两个线程访问两个对象不会发生阻塞
         */
        /**
         * 修饰一个静态方法
         */
		SyncThread s1 = new SyncThread();
		SyncThread s2 = new SyncThread();
		Thread t1 = new Thread(s1,"Thread1");
		Thread t2 = new Thread(s2,"Thread2");
        t1.start();
        t2.start();
        /**
         * 两个线程访问同一个对象，会发生阻塞
         */
//        synchronized_demo.SyncThread s = new synchronized_demo.SyncThread();
//        Thread t1 = new Thread(s);
//        Thread t2 = new Thread(s);
//        t1.start();
//        t2.start();
        /**
         * 当一个线程方访问synchronized(this)时，另一个线程可以访问该对象的非synchronized(this)方法
         */
//        ExampleCode1 counter = new ExampleCode1();
//        Thread thread1 = new Thread(counter, "A");
//        Thread thread2 = new Thread(counter, "B");
//        thread1.start();
//        thread2.start();
        /**
         *  synchronized给指定对象加锁
         */
        Account account = new Account("张三", 10000.0f);
        AccountOperator accountOperator = new AccountOperator(account);
        final int THREAD_NUM = 5;
        Thread threads[] = new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i ++) {
            threads[i] = new Thread(accountOperator, "Thread" + i);
            threads[i].start();
        }
    }
}

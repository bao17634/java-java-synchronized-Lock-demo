package example_lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: Counter
 * @Description: 多线程争用的数据类
 * @Author: yanrong
 * @Date: 8/29/2019 3:48 PM
 * @Version: 1.0
 */
public class Counter {
//    int count = 0;
//    public int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
//
//    public void add() {
//        count += 1;
//    }
//
//    public void dec() {
//        count -= 1;
//    }
//int count = 0;
//使用AtomicInteger代替基本数据类型
AtomicInteger count = new AtomicInteger(0);

    public int getCount() {
        //return count;
        return count.get();
    }


    public void add() {
        //count += 1;
        count.addAndGet(1);
    }

    public void dec() {
        //count -= 1;
        count.decrementAndGet();
    }

    /**
     * 争用数据做加操作的线程
     */
   static class AddDataThread extends Thread {
        Counter counter;
        public AddDataThread(Counter counter) {
            this.counter = counter;
        }
        @Override
        public void run() {
            for (int i = 0; i < CasClass.LOOP; ++i) {
                counter.add();
            }
        }
    }

    /**
     * 争用数据做减法操作的线程
     */
    static class DecDataThread extends Thread {

        Counter counter;

        public DecDataThread(Counter counter) {
            this.counter = counter;
        }
        @Override
        public void run() {
            for (int j = 0; j < CasClass.LOOP; j++) {
                counter.dec();
            }
        }
    }
}

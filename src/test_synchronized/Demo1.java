package test_synchronized;

/**
 * @ClassName: Demo1
 * @Description: 修饰类
 * @Author: yanrong
 * @Date: 8/28/2019 5:54 PM
 * @Version: 1.0
 */
public class Demo1 {
   public static void main(String[] args){
       SyncThreadClass s1 = new SyncThreadClass();
       SyncThreadClass s2 = new SyncThreadClass();
       Thread t1 = new Thread(s1,"Thread1");
       Thread t2 = new Thread(s2,"Thread2");
       t1.start();
       t2.start();
   }
}

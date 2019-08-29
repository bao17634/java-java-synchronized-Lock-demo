package test_synchronized;

/**
 * @ClassName: test_synchronized.ExampleCode
 * @Description: TODO
 * @Author: yanrong
 * @Date: 8/28/2019 9:38 AM
 * @Version: 1.0
 */
public class ExampleCode {
    //修饰静态方法
    private static int accountNum; // 一共有多少个银行账号
    public static synchronized void setAccountNum() {
        accountNum = accountNum + 1;
    }

    //修饰成员方法
    private double balance;
    public synchronized void deposite(double moneyToAdd) {
        String threadName = Thread.currentThread().getName();
        System.out.print(threadName + "--当前银行余额为：" + this.balance);
        balance = balance + moneyToAdd;
        System.out.print(threadName + "--存后银行余额为：" + this.balance);
    }

    //修饰同步代码块，块快对象时实例对象
    private double balance1;
    public void deposite1(double moneyToAdd) {
        String threadName = Thread.currentThread().getName();
        System.out.print(threadName + "--当前银行余额为：" + this.balance1);
        synchronized (this) {
            balance1 = balance1 + moneyToAdd;
        }
        System.out.print(threadName + "--存后银行余额为：" + this.balance1);
    }

    //修饰同步代码块，块对象时类对象
    private static int accountNum1; // 一共有多少个银行账号
    public synchronized void setAccountNum1() {
        synchronized (ExampleCode.class) {
            accountNum = accountNum + 1;
        }
    }

    public static void main(String[] args) {
        ExampleCode exampleCode=new ExampleCode();
        //修饰静态方法
        setAccountNum();
        System.out.print(accountNum);
//        //修饰成员方法
//        exampleCode.deposite(100.1);
//        //修饰同步代码块，块对象是实例对象
//        exampleCode.deposite1(100.2);
//        //同步代码块，块对象是类对象
//        exampleCode.setAccountNum1();
    }
}
